package codegenerator;

import ast.Type;
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
import ast.types.DoubleType;
import ast.types.FunctionType;
import visitor.AbstractCGVisitor;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {
    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setAddressCGVisitor(AddressCGVisitor addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
    }

    @Override
    public Void visit(Variable var, Void parameter) {
        /**
         * value[[Variable : expression -> ID]]() =
         * 	    address[[expression]]()
         * 	    <load> expression.type.suffix()
         */
        var.accept(this.addressCGVisitor, null);
        cg.load(var.getType().suffix());
        return null;
    }

    @Override
    public Void visit(Arithmetic var, Void parameter) {
        /**
         * value[[Arithmetic: exp1 → exp2 (+|-|*|/) exp3]]() =
         *      value[[exp2]]
         *      exp2.type.convertTo(exp1.type)
         *      value[[exp3]]
         *      exp3.type.convertTo(exp1.type)
         *      switch (exp1.operator) {
         *          case "+": <add> exp1.type.suffix() break;
         *          case "-": <sub> exp1.type.suffix() break;
         *          case "*": <div> exp1.type.suffix() break;
         *          case "/": <mul> exp1.type.suffix() break;
         *          caes "%": <mod> exp1.type.suffix() break;
         *      }
         */
        var.left.accept(this, parameter);
        cg.convertTo(var.left.getType(), var.type);
        var.right.accept(this, parameter);
        cg.convertTo(var.right.getType(), var.type);
        cg.arithmetic(var.operator, var.type);
        return null;
    }

    @Override
    public Void visit(Logical l, Void parameter) {
        /**
         * value[[Logical:exp1 → exp2 ('&&'|'||') exp3]]() =
         *      value[[exp2]]
         *      exp2.type.convertTo(exp1.type)
         *      value[[exp3]]
         *      exp3.type.convertTo(exp1.type)
         *      switch (exp1.operator) {
         *          case "&&": <and> exp1.type.suffix() break;
         *          case "||": <or> exp1.type.suffix() break;
         *      }
         */
        l.left.accept(this, parameter);
        cg.convertTo(l.left.getType(), l.type);
        l.right.accept(this, parameter);
        cg.convertTo(l.right.getType(), l.type);
        cg.logical(l.operator);
        return null;
    }

    @Override
    public Void visit(Comparison comp, Void parameter) {
        /**
         * value[[Comparison:exp1 → exp2 (>|<|==|!=|>=|<=) exp3]]() =
         *      Type typeToConvertTo = exp1.type
         *      if(comp.left.getType().suffix().equals("f")) typeToConvertTo = DoubleType.getInstance();        *
         *      value[[exp2]]
         *      exp2.type.convertTo(typeToConvertTo)
         *      value[[exp3]]
         *      exp3.type.convertTo(typeToConvertTo)
         *      switch (exp1.operator) {
         *          case ">":  <gt> exp1.type.suffix() break;
         *          case "<":  <lt> exp1.type.suffix() break;
         *          case "==": <eq> exp1.type.suffix() break;
         *          case "!=": <ne> exp1.type.suffix() break;
         *          case ">=": <ge> exp1.type.suffix() break;
         *          case "<=": <le> exp1.type.suffix() break;
         *      }
         */
        Type typeToConvertTo = comp.type;
        if(comp.left.getType().suffix().equals("f")) typeToConvertTo = DoubleType.getInstance();

        comp.left.accept(this, parameter);
        cg.convertTo(comp.left.getType(), typeToConvertTo);
        comp.right.accept(this, parameter);
        cg.convertTo(comp.right.getType(), typeToConvertTo);
        cg.comparison(comp.operator, typeToConvertTo);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void parameter) {
        /**
         * value[[IntLiteral: exp → INT_CONSTANT]]() = <pushi> INT_CONSTANT
         */
        cg.pushi(intLiteral.value);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void parameter) {
        /**
         *  value[[CharLiteral: exp → CHAR_CONSTANT]]() = <pushb> CHAR_CONSTANT
         */
        cg.pushb(charLiteral.value);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void parameter) {
        /**
         * value[[RealLiteral: exp → REAL_CONSTANT]]() = <pushf> exp.value
         */
        cg.pushf(doubleLiteral.value);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void parameter) {
        /**
         * value[[Cast: exp1 → type exp2]]() =
         *     value[[exp2]]
         *     exp2.type.convertTo(type)
         */
        cast.expression.accept(this, parameter);
        cg.convertTo(cast.expression.getType(), cast.type);
        return null;
    }

    @Override
    public Void visit(Minus minus, Void parameter) {
        /**
         * value[[Minus: exp1 → exp2]]() =
         *      <push> exp2.type.suffix() < 0>
         *      value[[exp2]]()
         *      exp2.type.convertTo(exp1.type)
         *      <sub> exp2.type.suffix()
         */
        cg.push(minus.type.suffix(), 0);
        minus.expression.accept(this, parameter);
        cg.convertTo(minus.expression.getType(), minus.type);
        cg.sub(minus.type.suffix());
        return null;
    }

    @Override
    public Void visit(Not not, Void parameter) {
        /**
         * value[[Not: exp1 → exp2]]() =
         *      value[[exp2]]()
         *      <not>
         */
        not.expression.accept(this, parameter);
        cg.not();
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void parameter) {
        /**
         * address[[ArrayAccess : exp1 -> exp2 exp3]]() =
         * 	    address [[exp1]]()
         *      <load> exp1.type.suffix()
         */
        arrayAccess.accept(this.addressCGVisitor, null);
        cg.load(arrayAccess.type.suffix());
        return null;
    }

    @Override
    public Void visit(StructAccess structAccess, Void parameter) {
        /**
         * value[[StructAccess: exp1 → exp2 ID]]() =
         *      address [[exp1]]()
         *      <load> exp1.type.suffix()
         */
        structAccess.accept(this.addressCGVisitor, null);
        cg.load(structAccess.type.suffix());
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void parameter) {
        /**
         * value[[FunctionInvocation: exp1 → exp2 exp3*]]() =
         *     exp3*.forEach(exp -> value[[exp]]())
         *     <call> exp2.name
         */
        FunctionType funcType = (FunctionType) functionInvocation.variable.definition.getType();

        for(int i = 0; i < functionInvocation.parameters.size(); i++){
            functionInvocation.parameters.get(i).accept(this, parameter);
            cg.convertTo(functionInvocation.parameters.get(i).getType(), funcType.parameters.get(i).getType());
        }

        cg.call(functionInvocation.variable.name);
        return null;
    }
}
