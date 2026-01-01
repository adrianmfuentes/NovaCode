package ast;

import java.util.List;

public interface Type extends ASTNode {

    void mustBeBuiltIn(Locatable locatable);

    void mustBeLogical(Locatable locatable);

    Type arithmetic(Type other, Locatable locatable);

    Type arithmetic(Locatable locatable);

    Type logic(Type other, Locatable locatable);

    Type logic(Locatable locatable);

    void mustPromotesTo(Type other, Locatable locatable);

    Type canBeCastTo(Type other, Locatable locatable);

    Type comparison(Type other, Locatable locatable);

    Type squareBrackets(Type other, Locatable locatable);

    Type dot(String field, Locatable locatable);

    void parenthesis(List<Type> args, Locatable locatable);

    int numberOfBytes();

    String suffix();
}
