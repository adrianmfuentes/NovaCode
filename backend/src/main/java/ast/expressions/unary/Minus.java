package ast.expressions.unary;

import ast.Expression;
import visitor.Visitor;

public class Minus extends UnaryExpression {

    public Minus(int line, int column, Expression expressionMinus) {
        super(line, column, expressionMinus);
    }

    @Override
    public String toString() {
        return "Minus: " + super.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
