package ast.statements;

import ast.Statement;
import visitor.Visitor;

public abstract class AbstractStatement implements Statement {
    public int line, column;

    protected AbstractStatement(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {return line;}
    public int getColumn() {return column;}

    @Override
    public String toString() {
        return "AbstractStatement{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter);
}
