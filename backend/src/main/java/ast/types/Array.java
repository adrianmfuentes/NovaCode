package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class Array extends AbstractType {
    public int size;
    public Type of;

    public Array(int size, Type type) {
        this.size = size;
        this.of = type;
    }

    @Override
    public String toString() {
        return "Array[" + size + "] of " + of.toString();
    }

    @Override
    public int numberOfBytes() {
        return size * of.numberOfBytes();
    }

    @Override
    public Type squareBrackets(Type other, Locatable locatable) {
        if (other == Int.getInstance()) {
            return this.of;
        }

        return super.squareBrackets(other, locatable);
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}