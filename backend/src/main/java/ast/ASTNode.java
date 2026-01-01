package ast;

import visitor.Visitor;

public interface ASTNode {

    <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter);
}
