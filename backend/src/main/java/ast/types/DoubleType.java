package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractType {
    private static DoubleType instance;

    private DoubleType() {}

    public static DoubleType getInstance() {
        if (instance == null) instance = new DoubleType();
        return instance;
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public Type arithmetic(Type other, Locatable locatable) {
        if(other == DoubleType.getInstance()) return this;
        return super.arithmetic(other, locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public void mustPromotesTo(Type other, Locatable locatable) {
        if (other == DoubleType.getInstance()) return;
        super.mustPromotesTo(other, locatable);
    }

    @Override
    public Type canBeCastTo(Type other, Locatable locatable) {
        if (other == DoubleType.getInstance()) return this;
        if (other == Int.getInstance()) return other;
        if (other == Char.getInstance()) return other;
        return super.canBeCastTo(other, locatable);
    }

    @Override
    public Type comparison(Type other, Locatable locatable) {
        if(other == DoubleType.getInstance()) return Int.getInstance();
        return super.comparison(other, locatable);
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public String suffix() {
        return "f";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
