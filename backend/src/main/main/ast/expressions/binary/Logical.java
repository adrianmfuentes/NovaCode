package ast.expressions.binary;

import ast.Expression;
import visitor.Visitor;

public class Logical extends BinaryExpression {

    public Logical(int line, int column, String operator, Expression left, Expression right) {
        super(line, column, operator, left, right);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
