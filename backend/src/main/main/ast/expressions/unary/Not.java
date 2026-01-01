package ast.expressions.unary;

import ast.Expression;
import visitor.Visitor;

public class Not extends UnaryExpression {

    public Not(int line, int column, Expression expressionToNegate) {
        super(line, column, expressionToNegate);
    }

    @Override
    public String toString() {
        return "Not{" +
                "expressionToNegate=" + super.expression +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
