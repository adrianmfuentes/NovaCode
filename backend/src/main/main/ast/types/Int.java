package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

public class Int extends AbstractType {
    private static Int instance;

    private Int() {}

    @Override
    public String toString() {
        return "int";
    }

    public static Int getInstance() {
        if (instance == null) instance = new Int();
        return instance;
    }

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
    }

    @Override
    public Type arithmetic(Type other, Locatable locatable) {
        if(other == Int.getInstance()) return this;
        return super.arithmetic(other, locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Type other, Locatable locatable) {
        if(other == Int.getInstance()) return this;
        return super.logic(other, locatable);
    }

    @Override
    public Type logic(Locatable locatable) {
        return this;
    }

    @Override
    public void mustPromotesTo(Type other, Locatable locatable) {
        if (other == Int.getInstance()) return;
        else if (other == DoubleType.getInstance()) return;
        super.mustPromotesTo(other, locatable);
    }

    @Override
    public Type canBeCastTo(Type other, Locatable locatable) {
        if (other == Int.getInstance()) return this;
        if (other == DoubleType.getInstance()) return other;
        if (other == Char.getInstance()) return other;
        return super.canBeCastTo(other, locatable);
    }

    @Override
    public Type comparison(Type other, Locatable locatable) {
        if(other == Int.getInstance()) return this;
        return super.comparison(other, locatable);
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public String suffix() {
        return "i";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}