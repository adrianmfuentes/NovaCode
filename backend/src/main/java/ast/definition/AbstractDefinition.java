package ast.definition;

import ast.Definition;
import ast.Type;
import visitor.Visitor;

public abstract class AbstractDefinition implements Definition {
    public int line, column;
    public String name;
    public Type type;
    private int scope;

    protected AbstractDefinition(int line, int column, String name, Type type) {
        this.line = line;
        this.column = column;
        this.name = name;
        this.type = type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getScope() {
        return this.scope;
    }

    @Override
    public String toString() {
        return "AbstractDefinition{" +
                "line=" + line +
                ", column=" + column +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter);
}
