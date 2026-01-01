package ast.expressions.literal;

import ast.expressions.AbstractExpression;
import visitor.Visitor;

public class CharLiteral extends AbstractExpression {
    public char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return "CharLiteral{" +
                "value=" + value +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}