package semantic;

import ast.Definition;
import ast.Statement;
import ast.Type;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expressions.Variable;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Type, Boolean> {

    private final SymbolTable symbolTable = new SymbolTable();

    @Override
    public Boolean visit(VarDefinition vd, Type parameter) {
        vd.getType().accept(this, parameter);

        boolean result = symbolTable.insert(vd);
        if(!result) new ErrorType("Variable " + vd.name + " is already defined", vd);

        return null;
    }

    @Override
    public Boolean visit(FunctionDefinition fd, Type parameter) {
        boolean result = symbolTable.insert(fd);
        if(!result) new ErrorType("Function " + fd.name + " is already defined", fd);

        symbolTable.set();
        fd.getType().accept(this, parameter);

        for (VarDefinition vd : fd.bodyVarDefs) {
            vd.accept(this, parameter);
        }
        for (Statement st : fd.bodyStmt) {
            st.accept(this, parameter);
        }

        symbolTable.reset();
        return null;
    }

    @Override
    public Boolean visit(Variable var, Type parameter) {
        Definition result = symbolTable.find(var.name);

        if(result == null) {
            result = new VarDefinition(0, 0, var.name,
                    new ErrorType("Variable " + var.name + " is not defined", var));
        }

        var.setDefinition(result);
        return null;
    }
}
