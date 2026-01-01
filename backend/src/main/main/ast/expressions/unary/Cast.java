package ast.expressions.unary;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public class Cast extends UnaryExpression {
    public Type castType;

    public Cast(int line, int column, Expression expressionToCast, Type castType) {
        super(line, column, expressionToCast);
        this.castType = castType;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "castType=" + castType + " " + super.toString() +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
