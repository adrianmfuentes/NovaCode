package ast.definition;

import ast.Statement;
import ast.Type;
import visitor.Visitor;

public class VarDefinition extends AbstractDefinition implements Statement {
    public int offset;

    public VarDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
