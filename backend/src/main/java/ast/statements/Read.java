package ast.statements;

import ast.Expression;
import visitor.Visitor;

public class Read extends AbstractStatement {
    public Expression toRead;

    public Read(int line, int column, Expression toRead) {
        super(line, column);
        this.toRead = toRead;
    }

    @Override
    public String toString() {
        return "Read{" +
                "toRead=" + toRead +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
