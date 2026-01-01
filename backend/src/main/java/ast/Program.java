package ast;

import visitor.Visitor;

import java.util.List;

public class Program implements ASTNode{

    public List<Definition> definitionsSequence;

    public Program(List<Definition> definitionsSequence) {
        this.definitionsSequence = definitionsSequence;
    }

    @Override
    public String toString() {
        return "Program{" +
                "definitionsSequence=" + definitionsSequence +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
