package ast.expressions;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public abstract class AbstractExpression implements Expression {
    public int line, column;
    public boolean lvalue;
    public Type type;

    protected AbstractExpression(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {return line;}
    public int getColumn() {return column;}

    @Override
    public String toString() {
        return "AbstractExpression{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean getLvalue() {
        return !this.lvalue;
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter);
}
