package ast.statements;

import ast.Expression;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class IfElse extends AbstractStatement {
    public Expression condition;
    public List<Statement> ifStatements;
    public List<Statement> elseStatements;

    public IfElse(int line, int column, Expression condition, List<Statement> ifStatements,
                  List<Statement> elseStatements) {
        super(line, column);
        this.condition = condition;
        this.ifStatements = ifStatements;
        this.elseStatements = elseStatements;
    }

    @Override
    public String toString() {
        return "IfElse{" +
                "condition=" + condition +
                ", ifStatements=" + ifStatements +
                ", elseStatements=" + elseStatements +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
