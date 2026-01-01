package ast.types;

import ast.Locatable;
import ast.Type;
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {
    public Locatable locatable;
    public String message;

    public ErrorType(String message, Locatable locatable) {
        this.message = message;
        this.locatable = locatable;

        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return "Error at line " + locatable.getLine() + " and column "
                + locatable.getColumn() + ": " + message;
    }

    @Override
    public Type arithmetic(Type other, Locatable locatable) {
        return this;
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Type other, Locatable locatable) {
        return this;
    }

    @Override
    public Type logic(Locatable locatable) {
        return this;
    }

    @Override
    public Type canBeCastTo(Type other, Locatable locatable) {
        return this;
    }

    @Override
    public Type comparison(Type other, Locatable locatable) {
        return this;
    }

    @Override
    public Type squareBrackets(Type other, Locatable locatable) {
        return this;
    }

    @Override
    public Type dot(String field, Locatable locatable) {
        return this;
    }

    @Override
    public void parenthesis(List<Type> args, Locatable locatable){
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
