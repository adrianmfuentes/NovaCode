package ast.expressions;

import ast.Expression;
import ast.Statement;
import visitor.Visitor;

import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {
    public List<Expression> parameters;
    public Variable variable;

    public FunctionInvocation(int line, int column, Variable var, List<Expression> parameters) {
        super(line, column);
        this.variable = var;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "FunctionInvocation{" +
                "parameters=" + parameters +
                ", variable=" + variable +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}
