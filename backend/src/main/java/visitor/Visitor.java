package visitor;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expressions.ArrayAccess;
import ast.expressions.FunctionInvocation;
import ast.expressions.binary.Arithmetic;
import ast.expressions.Variable;
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

public interface Visitor<TP, TR> {

    public TR visit(Program program, TP parameter);

    public TR visit(VarDefinition vd, TP parameter);

    public TR visit(FunctionDefinition fd, TP parameter);

    public TR visit(Arithmetic ar, TP parameter);

    public TR visit(Variable var, TP parameter);

    public TR visit(Logical l, TP parameter);

    public TR visit(Comparison comp, TP parameter);

    public TR visit(IntLiteral lit, TP parameter);

    public TR visit(DoubleLiteral lit, TP parameter);

    public TR visit(CharLiteral lit, TP parameter);

    public TR visit(Cast cast, TP parameter);

    public TR visit(Minus minus, TP parameter);

    public TR visit(Not not, TP parameter);

    public TR visit(FunctionInvocation fi, TP parameter);

    public TR visit(ArrayAccess arrayAccess, TP parameter);

    public TR visit(StructAccess structAccess, TP parameter);

    public TR visit(Write write, TP parameter);

    public TR visit(Read read , TP parameter);

    public TR visit(Assigment assigment, TP parameter);

    public TR visit(IfElse ifElse, TP parameter);

    public TR visit(While whileClass, TP parameter);

    public TR visit(Return returnClass, TP parameter);

    public TR visit(VoidType voidType, TP parameter);

    public TR visit(Int intType, TP parameter);

    public TR visit(DoubleType doubleType, TP parameter);

    public TR visit(Char charType, TP parameter);

    public TR visit(Array array, TP parameter);

    public TR visit(Struct struct, TP parameter);

    public TR visit(Field field, TP parameter);

    public TR visit(FunctionType function, TP parameter);

    public TR visit(ErrorType error, TP parameter);

}
