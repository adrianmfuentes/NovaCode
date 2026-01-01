package codegenerator;

import ast.Type;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.types.Field;
import ast.types.FunctionType;
import ast.types.Struct;
import visitor.AbstractVisitor;

public class OffSetVisitor extends AbstractVisitor<Type, Void> {

    private int globalBytesSum = 0;

    @Override
    public Void visit(FunctionDefinition fd, Type parameter) {
        fd.type.accept(this, parameter);
        int localBytesSum = 0; // Local variables offset

        for(VarDefinition vd : fd.bodyVarDefs) {
            vd.type.accept(this, parameter);
            localBytesSum += vd.type.numberOfBytes(); // We sum the size of the local variable
            vd.offset = -localBytesSum; // Negative offset for local variables
        }

        return null;
    }

    @Override
    public Void visit(VarDefinition vd, Type parameter) {
        // globalBytesSum es una variable global del main.java.visitor que se inicializa a 0
        vd.offset = globalBytesSum;

        vd.type.accept(this, parameter);
        globalBytesSum += vd.type.numberOfBytes();
        return null;
    }

    @Override
    public Void visit(Struct vd, Type parameter) {
        int fieldsBytesSum = 0; // Fields offset

        for(Field field : vd.fields) {
            field.offset = fieldsBytesSum;
            fieldsBytesSum += field.typeOf.numberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(FunctionType ft, Type parameter) {
        int paramsBytesSum = 4; // Parameters offset from right to left

        for(int i = ft.parameters.size() -1; i >= 0; i--) {
            VarDefinition vd = ft.parameters.get(i);
            vd.offset += paramsBytesSum;
            paramsBytesSum += vd.type.numberOfBytes();
        }
        return null;
    }

}
