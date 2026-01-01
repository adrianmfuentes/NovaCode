package ast.definition;

import ast.Statement;
import ast.Type;
import visitor.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {
    public List<VarDefinition> bodyVarDefs;
    public List<Statement> bodyStmt;
    public String name;
    public int bytesLocalsSum;

    public FunctionDefinition(int line, int column, String name, Type type,
                              List<VarDefinition> bodyVarDefs, List<Statement> bodyStmt) {
        super(line, column, name, type);
        this.name = name;
        this.bodyVarDefs = bodyVarDefs;
        this.bodyStmt = bodyStmt;
    }

    @Override
    public String toString() {
        return "FunctionDefinition{" +
                "varDefs=" + bodyVarDefs +
                "statements=" + bodyStmt +
                ", name=" + name +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
