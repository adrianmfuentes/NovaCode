package codegenerator;

import ast.Definition;
import ast.Program;
import ast.Statement;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expressions.FunctionInvocation;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;
import visitor.AbstractCGVisitor;

public class ExecuteCGVisitor extends AbstractCGVisitor<FunctionDefinition, Void> {
    public AddressCGVisitor addressCGVisitor;
    public ValueCGVisitor valueCGVisitor;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.addressCGVisitor = new AddressCGVisitor(cg);
        this.valueCGVisitor = new ValueCGVisitor(cg);

        this.addressCGVisitor.setValueCGVisitor(valueCGVisitor);
        this.valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
    }

    @Override
    public Void visit(Program program, FunctionDefinition parameter) {
        /**
         * execute[[Program : program -> definition*]]() =
         * 	  for definition in definition* {
         * 	      if (definition instanceOf vardefinition) execute[[definition]]()
         * 	  }
         * 	  <call main>
         * 	  <call halt>
         * 	  for definition in definition* {
         * 	      if (definition instanceOf funcdefinition) execute[[definition]]()
         * 	  }
         */
        for (Definition definition : program.definitionsSequence) {
            if (definition instanceof VarDefinition) {
                definition.accept(this, parameter);
            }
        }

        cg.mainFunctionInvocation();
        cg.halt();

        for (Definition definition : program.definitionsSequence) {
            if (definition instanceof FunctionDefinition) {
                definition.accept(this, parameter);
            }
        }

        return null;
    }

    @Override
    public Void visit(VarDefinition vd, FunctionDefinition parameter) {
        /**
         * execute[[VarDefinition : definition -> ID type]]() =
         *      <'*> definition.type.toString definition.getName() <(offset> definition.offset() <)>
         */
        cg.writeGlobal(vd.getName(), vd.type.toString(), vd.offset);
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fd, FunctionDefinition parameter) {
        /**
         * execute[[FunctionDefinition : definition -> type ID vardefinition* statement*]]() =
         *      <# line> definition.getLine()
         *      definition.getName() <:>
         *      <'* Parameters:>
         *      for(VarDefinition vd : type.parameters()) { execute[[vd]]() }
         *      <'* Local variables:>
         *      for(VarDefinition vd : vardefinition*) { execute[[vd]]() }
         *      <enter>  vardefinition*.getLast().offset
         *      for(statement : statement*) { execute[[statement]]() }
         *      <ret>  vardefinition*.stream().mapToInt(vd -> vd.type.numberOfBytes()).sum()
         */
        cg.writeLine(fd.getLine());
        cg.writeFunctionName(fd.getName());

        cg.writeParameters();
        FunctionType functionType = (FunctionType) fd.type;
        for (VarDefinition definition : functionType.parameters) {
            definition.accept(this, parameter);
        }

        cg.writeLocals();
        for (Definition definition : fd.bodyVarDefs) {
            definition.accept(this, parameter);
        }

        int bytesLocals = 0;
        if (!fd.bodyVarDefs.isEmpty()) {
            int lastIndex = fd.bodyVarDefs.size() - 1;
            bytesLocals = -fd.bodyVarDefs.get(lastIndex).offset;
        }
        fd.bytesLocalsSum = bytesLocals;
        cg.writeEnter(bytesLocals);

        int bytesParams = functionType.parameters
                .stream().mapToInt(param -> param.type.numberOfBytes()).sum();
        functionType.bytesParamsSum = bytesParams;

        int bytesReturn = functionType.returnType.numberOfBytes();

        for(Statement statement : fd.bodyStmt) {
            statement.accept(this, fd);
        }

        if (functionType.returnType instanceof VoidType) {
            cg.ret(bytesReturn, bytesLocals, bytesParams);
        }

        return null;
    }

    @Override
    public Void visit(Write write, FunctionDefinition parameter) {
        /**
         * execute[[Write : statement -> expression]]() =
         *       <# line> statement.getLine()
         *       <'*> Write
         * 	     value[[expression]]()
         * 	     <out> expresión.type.suffix()
         */
        cg.writeLine(write.getLine());
        cg.write();
        write.toPrint.accept(this.valueCGVisitor, null);
        cg.out(write.toPrint.getType().suffix());
        return null;
    }

    @Override
    public Void visit(Read read, FunctionDefinition parameter) {
        /**
         * execute[[Read : statement -> expression]]() =
         *      <# line> statement.getLine()
         *      <'*> Read
         * 	    address[[expression]]()
         * 	    <in> expression.type.suffix
         * 	    <store> expression.type.suffix()
         */
        cg.writeLine(read.getLine());
        cg.read();
        read.toRead.accept(this.addressCGVisitor, null);
        cg.in(read.toRead.getType().suffix());
        cg.store(read.toRead.getType().suffix());
        return null;
    }

    @Override
    public Void visit(Assigment assigment, FunctionDefinition parameter) {
        /**
         * execute[[Assignment: statement → exp1 exp2]]() =
         *      <# line> statement.getLine()
         *      <'*> Assignment
         *      address[[exp1]]()
         *      value[[exp2]]()
         *      <store> exp1.type.suffix()
         */
        cg.writeLine(assigment.getLine());
        cg.assignment();
        assigment.left.accept(this.addressCGVisitor, null);
        assigment.right.accept(this.valueCGVisitor, null);
        cg.convertTo(assigment.right.getType(), assigment.left.getType());
        cg.store(assigment.left.getType().suffix());
        return null;
    }

    @Override
    public Void visit(While whileStmt, FunctionDefinition parameter) {
        /**
         * execute[[WhileStatement: statement → exp statement*]]() =
         *      String conditionLabel = cg.nextLabel(), exitLabel = cg.nextLabel();
         *      conditionLabel :
         *      value[[exp]]()
         *      <jz> exitLabel
         *      statement*.forEach(stmt -> execute[[stmt]])
         *      <jmp> conditionLabel
         *      exitLabel :
         */
        String conditionLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();

        cg.writeLabel(conditionLabel);
        whileStmt.condition.accept(this.valueCGVisitor, null);
        cg.jz(exitLabel);

        for (Statement statement : whileStmt.body) {
            statement.accept(this, parameter);
        }

        cg.jmp(conditionLabel);
        cg.writeLabel(exitLabel);
        return null;
    }

    @Override
    public Void visit(IfElse ifElseStmt, FunctionDefinition parameter) {
        /**
         * execute[[IfStatement: statement1 → exp statement2* statement3*]]() =
         *      String elseLabel = cg.nextLabel(), exitLabel = cg.nextLabel();
         *      value[[exp]]()
         *      <jz> elseLabel
         *      statement2*.forEach(stmt -> execute[[stmt]])
         *      <jmp> exitLabel
         *      elseLabel :
         *      statement3*.forEach(stmt -> execute[[stmt]])
         *      exitLabel :
         */
        String elseLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();

        ifElseStmt.condition.accept(this.valueCGVisitor, null);
        cg.jz(elseLabel);

        for (Statement statement2 : ifElseStmt.ifStatements) {
            statement2.accept(this, parameter);
        }

        cg.jmp(exitLabel);
        cg.writeLabel(elseLabel);

        for (Statement statement3 : ifElseStmt.elseStatements) {
            statement3.accept(this, parameter);
        }

        cg.writeLabel(exitLabel);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, FunctionDefinition parameter) {
        /**
         * execute[[FunctionInvocation: statement → exp1 exp2*]]() =
         *      <# line> statement.getLine()
         *      exp2*.forEach(exp -> value[[exp]]())
         *      <call> exp1.getName()
         *      if(!(exp1.definition.type.returnType instanceof VoidType) {
         *           <pop> exp1.definition.type.returnType.suffix()
         *      }
         */
        cg.writeLine(functionInvocation.getLine());
        functionInvocation.accept(this.valueCGVisitor, null);

        FunctionType functionType = (FunctionType) functionInvocation.variable.type;
        if (!(functionType.returnType instanceof VoidType)) {
            cg.pop(functionType.returnType.suffix());
        }

        return null;
    }

    @Override
    public Void visit(Return returnStmt, FunctionDefinition fd) {
        /**
         * execute [[Return: statement → exp]] (int bytesLocals, int bytesParams, int bytesReturn) =
         *      value[exp]()
         *      <ret> bytesReturn, bytesLocals, bytesParams
         */
        returnStmt.returnExpression.accept(this.valueCGVisitor, null);
        FunctionType type = (FunctionType) fd.type;
        cg.convertTo(returnStmt.returnExpression.getType(), type.returnType);
        cg.ret(type.returnType.numberOfBytes(), fd.bytesLocalsSum, type.bytesParamsSum);
        return null;
    }
}
