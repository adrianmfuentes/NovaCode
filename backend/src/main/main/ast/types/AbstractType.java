package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

import java.util.List;

public abstract class AbstractType implements Type {

    @Override
    public void mustBeBuiltIn(Locatable locatable) {
        new ErrorType("Type must be built-in", locatable);
    }

    @Override
    public void mustBeLogical(Locatable locatable) {
        new ErrorType("Type must be logical", locatable);
    }

    @Override
    public Type arithmetic(Type other, Locatable locatable) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Type must be arithmetic", locatable);
    }

    @Override
    public Type arithmetic(Locatable locatable) {
        return new ErrorType("Invalid type for unary minus operator", locatable);
    }

    @Override
    public Type logic(Type other, Locatable locatable) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Invalid type for logical operation: " + other.toString(), locatable);
    }

    @Override
    public Type logic(Locatable locatable) {
        return new ErrorType("Invalid type for negation", locatable);
    }

    @Override
    public void mustPromotesTo(Type other, Locatable locatable) {
        if(!(other instanceof ErrorType)) {
            new ErrorType("Invalid type for assignment", locatable);
        }
    }

    @Override
    public Type canBeCastTo(Type other, Locatable locatable) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Invalid type for cast: " + other.toString(), locatable);
    }

    @Override
    public Type comparison(Type other, Locatable locatable) {
        if(other instanceof ErrorType) {
            return other;
        }

        return new ErrorType("Invalid type for comparison", locatable);
    }

    @Override
    public Type squareBrackets(Type other, Locatable locatable) {
        if(other instanceof ErrorType) {
            return other;
        }

        return new ErrorType("Invalid type for array indexing: " + other.toString(), locatable);
    }

    @Override
    public Type dot(String field, Locatable locatable) {
        return new ErrorType("Invalid field for struct access", locatable);
    }

    @Override
    public void parenthesis(List<Type> args, Locatable locatable){
        for (Type arg : args) {
            if(arg instanceof ErrorType) {
                return;
            }
        }

        new ErrorType("Invalid type for function call", locatable);
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

    @Override
    public String suffix() {
        return "";
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter);
}
