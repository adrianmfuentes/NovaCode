package ast.types;

import ast.Locatable;
import visitor.Visitor;

public class VoidType extends AbstractType {
    private static VoidType instance;

    private VoidType() {
    }

    public static synchronized VoidType getInstance() {
        if(instance == null) instance = new VoidType();
        return instance;
    }

    @Override
    public String toString() {
        return "none";
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
