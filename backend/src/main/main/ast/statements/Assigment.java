package ast.statements;

import ast.Expression;
import visitor.Visitor;

public class Assigment extends AbstractStatement {
    public Expression left;
    public Expression right;

    public Assigment(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Assigment{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
