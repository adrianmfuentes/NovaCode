package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class Char extends AbstractType {
    private static Char instance;

    private Char() {}

    public static Char getInstance() {
        if (instance == null) instance = new Char();
        return instance;
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
    }

    @Override
    public Type arithmetic(Type other, Locatable locatable) {
        if(other == Char.getInstance()) return this;
        return super.arithmetic(other, locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return Int.getInstance();
    }

    @Override
    public void mustPromotesTo(Type other, Locatable locatable) {
        if (other == Char.getInstance()) return;
        if (other == DoubleType.getInstance()) return;
        if (other == Int.getInstance()) return;
        super.mustPromotesTo(other, locatable);
    }

    @Override
    public Type canBeCastTo(Type other, Locatable locatable) {
        if (other == Int.getInstance()) return other;
        if (other == DoubleType.getInstance()) return other;
        if (other == Char.getInstance()) return this;
        return super.canBeCastTo(other, locatable);
    }

    @Override
    public Type comparison(Type other, Locatable locatable) {
        if(other == Char.getInstance()) return Int.getInstance();
        return super.comparison(other, locatable);
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public String suffix() {
        return "b";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
