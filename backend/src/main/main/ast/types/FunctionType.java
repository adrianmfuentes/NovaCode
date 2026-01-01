package ast.types;

import ast.Locatable;
import ast.Type;
import ast.definition.VarDefinition;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType {
    public Type returnType;
    public List<VarDefinition> parameters;
    public int bytesParamsSum;

    public FunctionType(Type type, List<VarDefinition> parameters) {
        this.returnType = type;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "function " + returnType.toString() + "(" + parameters.toString() + ")";
    }

    @Override
    public void parenthesis(List<Type> args, Locatable locatable){
        if(args.size() != parameters.size()){
            new ErrorType("Function call with wrong number of arguments", locatable);
            return;
        }

        for(int i = 0; i < args.size(); i++){
            args.get(i).mustPromotesTo(parameters.get(i).type, locatable);
        }

    }

    @Override
    public void mustPromotesTo(Type other, Locatable locatable) {
        if(other == returnType) return;
        super.mustPromotesTo(other, locatable);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}