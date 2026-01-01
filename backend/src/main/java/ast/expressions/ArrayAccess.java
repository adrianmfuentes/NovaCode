package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class ArrayAccess extends AbstractExpression {
    public Expression var;
    public Expression index;

    public ArrayAccess(int line, int column, Expression var, Expression index) {
        super(line, column);
        this.var = var;
        this.index = index;
    }

    @Override
    public String toString() {
        return "ArrayAccess{" +
                "var=" + var +
                ", index=" + index +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
