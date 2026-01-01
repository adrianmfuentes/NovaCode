package visitor;

import ast.Program;
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
import codegenerator.CodeGenerator;

public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    protected final CodeGenerator cg;

    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    @Override
    public TR visit(Program program, TP parameter) {
        throw new IllegalStateException("Program should not be visited");
    }

    @Override
    public TR visit(VarDefinition vd, TP parameter) {
        throw new IllegalStateException("Variable definition should not be visited");
    }

    @Override
    public TR visit(FunctionDefinition fd, TP parameter) {
        throw new IllegalStateException("Function definition should not be visited");
    }

    @Override
    public TR visit(Arithmetic ar, TP parameter) {
        throw new IllegalStateException("Arithmetic should not be visited");
    }

    @Override
    public TR visit(Variable var, TP parameter) {
        throw new IllegalStateException("Variable should not be visited");
    }

    @Override
    public TR visit(Logical l, TP parameter) {
        throw new IllegalStateException("Logical should not be visited");
    }

    @Override
    public TR visit(Comparison comp, TP parameter) {
        throw new IllegalStateException("Comparison should not be visited");
    }

    @Override
    public TR visit(IntLiteral lit, TP parameter) {
        throw new IllegalStateException("IntLiteral should not be visited");
    }

    @Override
    public TR visit(DoubleLiteral lit, TP parameter) {
        throw new IllegalStateException("DoubleLiteral should not be visited");
    }

    @Override
    public TR visit(CharLiteral lit, TP parameter) {
        throw new IllegalStateException("CharLiteral should not be visited");
    }

    @Override
    public TR visit(Cast cast, TP parameter) {
        throw new IllegalStateException("Cast should not be visited");
    }

    @Override
    public TR visit(Minus minus, TP parameter) {
        throw new IllegalStateException("Minus should not be visited");
    }

    @Override
    public TR visit(Not not, TP parameter) {
        throw new IllegalStateException("Not should not be visited");
    }

    @Override
    public TR visit(FunctionInvocation fi, TP parameter) {
        throw new IllegalStateException("FunctionInvocation should not be visited");
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP parameter) {
        throw new IllegalStateException("ArrayAccess should not be visited");
    }

    @Override
    public TR visit(StructAccess structAccess, TP parameter) {
        throw new IllegalStateException("StructAccess should not be visited");
    }

    @Override
    public TR visit(Write write, TP parameter) {
        throw new IllegalStateException("Write should not be visited");
    }

    @Override
    public TR visit(Read read, TP parameter) {
        throw new IllegalStateException("Read should not be visited");
    }

    @Override
    public TR visit(Assigment assigment, TP parameter) {
        throw new IllegalStateException("Assigment should not be visited");
    }

    @Override
    public TR visit(IfElse ifElse, TP parameter) {
        throw new IllegalStateException("IfElse should not be visited");
    }

    @Override
    public TR visit(While whileClass, TP parameter) {
        throw new IllegalStateException("While should not be visited");
    }

    @Override
    public TR visit(Return returnClass, TP parameter) {
        throw new IllegalStateException("Return should not be visited");
    }

    @Override
    public TR visit(VoidType voidType, TP parameter) {
        throw new IllegalStateException("Void should not be visited");
    }

    @Override
    public TR visit(Int intType, TP parameter) {
        throw new IllegalStateException("Int should not be visited");
    }

    @Override
    public TR visit(DoubleType doubleType, TP parameter) {
        throw new IllegalStateException("Double should not be visited");
    }

    @Override
    public TR visit(Char charType, TP parameter) {
        throw new IllegalStateException("Char should not be visited");
    }

    @Override
    public TR visit(Array array, TP parameter) {
        throw new IllegalStateException("Array should not be visited");
    }

    @Override
    public TR visit(Struct struct, TP parameter) {
        throw new IllegalStateException("Struct should not be visited");
    }

    @Override
    public TR visit(Field field, TP parameter) {
        throw new IllegalStateException("Field should not be visited");
    }

    @Override
    public TR visit(FunctionType ft, TP parameter) {
        throw new IllegalStateException("FunctionType should not be visited");
    }

    @Override
    public TR visit(ErrorType error, TP parameter) {
        throw new IllegalStateException("ErrorType should not be visited");
    }
}
