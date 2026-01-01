package semantic;

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
import visitor.AbstractVisitor;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Boolean> {

    @Override
    public Boolean visit(FunctionDefinition fd, Type parameter) {
        fd.getType().accept(this, parameter);
        Type returnType = ((FunctionType)fd.getType()).returnType;
        boolean hasReturn = false;

        if(!(returnType instanceof VoidType)){
            returnType.mustBeBuiltIn(fd);
        }

        for (VarDefinition vd : fd.bodyVarDefs) {
            vd.accept(this, parameter);
        }

        int returnStmtCount = 0;
        for (Statement st : fd.bodyStmt) {
            if(st instanceof Return) returnStmtCount++;
            hasReturn = Boolean.TRUE.equals(st.accept(this, returnType)) || hasReturn;
        }

        if(returnStmtCount > 1) {
            new ErrorType("At the base level, we have found several return statements." + fd.name, fd);
        }

        if(!hasReturn && !(returnType instanceof VoidType)){
            new ErrorType("Missing return statement", fd);
        }

        return false;
    }

    @Override
    public Boolean visit(Arithmetic ar, Type parameter) {
        ar.left.accept(this, parameter);
        ar.right.accept(this, parameter);
        ar.setLvalue(false);

        ar.setType(
                ar.left.getType().arithmetic(
                        ar.right.getType(),
                        ar
                )
        );

        return null;
    }

    @Override
    public Boolean visit(Variable var, Type parameter) {
        var.setType(var.getDefinition().getType());
        var.setLvalue(true);
        return null;
    }

    @Override
    public Boolean visit(Logical l, Type parameter) {
        l.left.accept(this, parameter);
        l.right.accept(this, parameter);
        l.setLvalue(false);

        l.setType(
                l.left.getType().logic(
                        l.right.getType(),
                        l
                )
        );

        return null;
    }

    @Override
    public Boolean visit(Comparison comp, Type parameter) {
        comp.left.accept(this, parameter);
        comp.right.accept(this, parameter);
        comp.setLvalue(false);

        comp.setType(
                comp.left.getType().comparison(
                        comp.right.getType(),
                        comp
                )
        );

        return null;
    }

    @Override
    public Boolean visit(IntLiteral lit, Type parameter) {
        lit.setLvalue(false);

        lit.setType(
                Int.getInstance()
        );

        return null;
    }

    @Override
    public Boolean visit(DoubleLiteral lit, Type parameter) {
        lit.setLvalue(false);

        lit.setType(
                DoubleType.getInstance()
        );

        return null;
    }

    @Override
    public Boolean visit(CharLiteral lit, Type parameter) {
        lit.setLvalue(false);

        lit.setType(
                Char.getInstance()
        );

        return null;
    }

    @Override
    public Boolean visit(Cast cast, Type parameter) {
        cast.expression.accept(this, parameter);
        cast.castType.accept(this, parameter);
        cast.setLvalue(false);

        cast.setType(
                cast.expression.getType().canBeCastTo(
                        cast.castType,
                        cast
                )
        );

        return null;
    }

    @Override
    public Boolean visit(Minus minus, Type parameter) {
        minus.expression.accept(this, parameter);
        minus.setLvalue(false);
        minus.setType(minus.expression.getType().arithmetic(minus));
        return null;
    }

    @Override
    public Boolean visit(Not not, Type parameter) {
        not.expression.accept(this, parameter);
        not.setLvalue(false);
        not.setType(not.expression.getType().logic(not));

        return null;
    }

    @Override
    public Boolean visit(FunctionInvocation fi, Type parameter) {
        fi.variable.accept(this, parameter);

        List<Type> types = new ArrayList<>();
        for (Expression expression : fi.parameters) {
            expression.accept(this, parameter);
            expression.getType().mustBeBuiltIn(fi);
            types.add(expression.getType());
        }

        fi.setLvalue(false);

        // Verification that the variable is a function
        Type variableType = fi.variable.getType();
        if (!(variableType instanceof FunctionType)) {
            fi.setType(new ErrorType("Expression is not callable", fi));
            return null;
        }

        variableType.parenthesis(types, fi);
        fi.setType(((FunctionType) variableType).returnType);
        return null;
    }

    @Override
    public Boolean visit(ArrayAccess arrayAccess, Type parameter) {
        arrayAccess.var.accept(this, parameter);
        arrayAccess.index.accept(this, parameter);
        arrayAccess.setLvalue(true);

        arrayAccess.setType(
                arrayAccess.var.getType().squareBrackets(
                        arrayAccess.index.getType(),
                        arrayAccess
                )
        );

        return null;
    }

    @Override
    public Boolean visit(StructAccess structAccess, Type parameter) {
        structAccess.expression.accept(this, parameter);
        structAccess.setLvalue(true);

        structAccess.setType(
                structAccess.expression.getType().dot(
                        structAccess.field,
                        structAccess
                )
        );

        return null;
    }

    @Override
    public Boolean visit(Write write, Type parameter) {
        write.toPrint.accept(this, parameter);

        if(!(write.toPrint.getType() instanceof ErrorType)) {
            write.toPrint.getType().mustBeBuiltIn(write);
        }

        return false;
    }

    @Override
    public Boolean visit(Read read, Type parameter) {
        read.toRead.accept(this, parameter);

        if(read.toRead.getLvalue()) {
            new ErrorType("Cannot assign a value", read.toRead);
        }

        if(!(read.toRead.getType() instanceof ErrorType)){
            read.toRead.getType().mustBeBuiltIn(read);
        }

        return false;
    }

    @Override
    public Boolean visit(Assigment assigment, Type parameter) {
        assigment.left.accept(this, parameter);
        assigment.right.accept(this, parameter);

        if(assigment.left.getLvalue()) {
            new ErrorType("Invalid left assignment", assigment.left);
        }

        assigment.right.getType().mustPromotesTo(
                assigment.left.getType(),
                assigment
        );

        return false;
    }

    @Override
    public Boolean visit(IfElse ifElse, Type parameter) {
        ifElse.condition.accept(this, parameter);
        ifElse.condition.getType().mustBeLogical(ifElse);

        boolean hasReturnIf = false, hasReturnElse = ifElse.elseStatements.isEmpty();

        for (Statement stmt : ifElse.ifStatements)
            hasReturnIf = Boolean.TRUE.equals(stmt.accept(this, parameter)) || hasReturnIf;

        for (Statement stmt : ifElse.elseStatements)
            hasReturnElse = Boolean.TRUE.equals(stmt.accept(this, parameter)) || hasReturnElse;

        return hasReturnIf && hasReturnElse;
    }

    @Override
    public Boolean visit(While whileClass, Type parameter) {
        whileClass.condition.accept(this, parameter);
        whileClass.condition.getType().mustBeLogical(whileClass);

        boolean hasReturnBody = false;

        for (Statement stmt : whileClass.body)
            hasReturnBody = Boolean.TRUE.equals(stmt.accept(this, parameter)) || hasReturnBody;

        return hasReturnBody;
    }

    @Override
    public Boolean visit(Return returnClass, Type parameter) {
        returnClass.returnExpression.accept(this, parameter);
        returnClass.returnExpression.getType().mustBeBuiltIn(returnClass);
        returnClass.returnExpression.getType().mustPromotesTo(parameter, returnClass);
        return true;
    }

    @Override
    public Boolean visit(VoidType voidType, Type parameter) {return null;}

    @Override
    public Boolean visit(Int intType, Type parameter) {
        return null;
    }

    @Override
    public Boolean visit(DoubleType doubleType, Type parameter) {
        return null;
    }

    @Override
    public Boolean visit(Char charType, Type parameter) {
        return null;
    }

    @Override
    public Boolean visit(Array array, Type parameter) {
        array.of.accept(this, parameter);
        return null;
    }

    @Override
    public Boolean visit(Struct struct, Type parameter) {
        for(Field field : struct.fields) { field.accept(this, parameter); }
        return null;
    }

    @Override
    public Boolean visit(Field field, Type parameter) {
        field.typeOf.accept(this, parameter);
        return null;
    }

    @Override
    public Boolean visit(FunctionType function, Type parameter) {
        function.returnType.accept(this, parameter);
        for(VarDefinition vd : function.parameters) { vd.accept(this, parameter); }
        return null;
    }

    @Override
    public Boolean visit(ErrorType error, Type parameter) {
        return null;
    }
}
