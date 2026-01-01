package ast.statements;

import ast.Expression;
import visitor.Visitor;

public class Return extends AbstractStatement {
    public Expression returnExpression;

    public Return(int line, int column, Expression returnExpression) {
        super(line, column);
        this.returnExpression = returnExpression;
    }

    @Override
    public String toString() {
        return "Return{" +
                "returnExpression=" + returnExpression +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
