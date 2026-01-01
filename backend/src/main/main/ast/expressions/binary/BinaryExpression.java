package ast.expressions.binary;

import ast.expressions.AbstractExpression;
import ast.Expression;
import visitor.Visitor;

public abstract class BinaryExpression extends AbstractExpression {
    public String operator;
    public Expression left;
    public Expression right;

    protected BinaryExpression(int line, int column, String operator, Expression left, Expression right) {
        super(line, column);

        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "AbstractBinaryExpression{" +
                "operator='" + operator + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter);
}
