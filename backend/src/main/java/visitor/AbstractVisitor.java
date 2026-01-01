package visitor;

import ast.*;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expressions.ArrayAccess;
import ast.expressions.FunctionInvocation;
import ast.expressions.Variable;
import ast.expressions.binary.Arithmetic;
import ast.expressions.binary.Comparison;
import ast.expressions.binary.Logical;
import ast.expressions.literal.CharLiteral;
import ast.expressions.literal.DoubleLiteral;
import ast.expressions.literal.IntLiteral;
import ast.expressions.unary.Cast;
import ast.expressions.unary.Minus;
import ast.expressions.unary.Not;
import ast.expressions.unary.StructAccess;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Program program, TP parameter) {
        for (Definition def : program.definitionsSequence) { def.accept(this, parameter); }
        return null;
    }

    @Override
    public TR visit(VarDefinition vd, TP parameter) {
        vd.getType().accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(FunctionDefinition fd, TP parameter) {
        fd.getType().accept(this, parameter);
        for (VarDefinition vd : fd.bodyVarDefs) {vd.accept(this, parameter);}
        for (Statement st : fd.bodyStmt) { st.accept(this, parameter); }
        return null;
    }

    @Override
    public TR visit(Arithmetic ar, TP parameter) {
        ar.left.accept(this, parameter);
        ar.right.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Variable var, TP parameter) {
        return null;
    }

    @Override
    public TR visit(Logical l, TP parameter) {
        l.left.accept(this, parameter);
        l.right.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Comparison comp, TP parameter) {
        comp.left.accept(this, parameter);
        comp.right.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(IntLiteral lit, TP parameter) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral lit, TP parameter) {
        return null;
    }

    @Override
    public TR visit(CharLiteral lit, TP parameter) {
        return null;
    }

    @Override
    public TR visit(Cast cast, TP parameter) {
        cast.expression.accept(this, parameter);
        cast.castType.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Minus minus, TP parameter) {
        minus.expression.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Not not, TP parameter) {
        not.expression.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation fi, TP parameter) {
        fi.variable.accept(this, parameter);
        for (Expression expression : fi.parameters) { expression.accept(this, parameter); }
        return null;
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP parameter) {
        arrayAccess.var.accept(this, parameter);
        arrayAccess.index.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(StructAccess structAccess, TP parameter) {
        structAccess.expression.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Write write, TP parameter) {
        write.toPrint.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Read read, TP parameter) {
        read.toRead.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Assigment assigment, TP parameter) {
        assigment.left.accept(this, parameter);
        assigment.right.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP parameter) {
        ifElse.condition.accept(this, parameter);
        ifElse.ifStatements.forEach(stmt -> stmt.accept(this, parameter));
        ifElse.elseStatements.forEach(stmt -> stmt.accept(this, parameter));
        return null;
    }

    @Override
    public TR visit(While whileClass, TP parameter) {
        whileClass.condition.accept(this, parameter);
        whileClass.body.forEach(stmt -> stmt.accept(this, parameter));
        return null;
    }

    @Override
    public TR visit(Return returnClass, TP parameter) {
        returnClass.returnExpression.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(Int intType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(Char charType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(Array array, TP parameter) {
        array.of.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(Struct struct, TP parameter) {
        for(Field field : struct.fields) { field.accept(this, parameter); }
        return null;
    }

    @Override
    public TR visit(Field field, TP parameter) {
        field.typeOf.accept(this, parameter);
        return null;
    }

    @Override
    public TR visit(FunctionType function, TP parameter) {
        function.returnType.accept(this, parameter);
        for(VarDefinition vd : function.parameters) { vd.accept(this, parameter); }
        return null;
    }

    @Override
    public TR visit(ErrorType error, TP parameter) {
        return null;
    }
}
