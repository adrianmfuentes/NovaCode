package ast.expressions.unary;

import ast.Expression;
import ast.expressions.AbstractExpression;
import visitor.Visitor;

public abstract class UnaryExpression extends AbstractExpression {

    public int line, column;
    public Expression expression;

    protected UnaryExpression(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "UnaryExpression{" +
                "line=" + line +
                ", column=" + column +
                ", expression=" + expression +
                '}';
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter);
}
