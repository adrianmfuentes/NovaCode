package ast.statements;

import ast.Expression;
import visitor.Visitor;

public class Write extends AbstractStatement {
    public Expression toPrint;

    public Write(int line, int column, Expression toPrint) {
        super(line, column);
        this.toPrint = toPrint;
    }

    @Override
    public String toString() {
        return "Print{" +
                "toPrint=" + toPrint +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
