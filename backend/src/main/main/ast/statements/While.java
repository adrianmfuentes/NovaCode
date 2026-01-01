package ast.statements;

import ast.Expression;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class While extends AbstractStatement {
    public Expression condition;
    public List<Statement> body;

    public While(int line, int column, Expression condition, List<Statement> body) {
        super(line, column);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public String toString() {
        return "While{" +
                "condition=" + condition +
                ", body=" + body +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
