package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class Field implements Locatable {
    public Type typeOf;
    public String name;
    public int line, column;
    public int offset;

    public Field(int line, int column, Type type, String name) {
        this.line = line;
        this.column = column;
        this.typeOf = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Field: " +
                "Type: " + typeOf.toString() + ", " +
                "Name: " + name + ", ";
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
