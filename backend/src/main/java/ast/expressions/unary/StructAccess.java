package ast.expressions.unary;

import ast.Expression;
import visitor.Visitor;

public class StructAccess extends UnaryExpression {
    public String field;

    public StructAccess(int line, int column, Expression expression, String field) {
        super(line, column, expression);
        this.field = field;
    }

    @Override
    public String toString() {
        return "StructAccess{" +
                "field='" + field + '\'' +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
