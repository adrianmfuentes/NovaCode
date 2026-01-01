package codegenerator;

import ast.expressions.ArrayAccess;
import ast.expressions.Variable;
import ast.expressions.unary.StructAccess;
import ast.types.Struct;
import visitor.AbstractCGVisitor;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {
    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Void visit(Variable var, Void parameter) {
        /**
         * address[[Variable : expression -> ID]]() =
         * 	    if(expression.definition.scope == 0){
         * 		    <pusha> expression.definition.offset
         * 	    } else {
         * 		    <push bp>
         * 		    <pushi> expression.definition.offset
         * 		    <addi>
         *      }
         */
        cg.pushAddress(var.getDefinition());
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void parameter) {
        /**
         * address[[ArrayAccess : exp1 -> exp2 exp3]]() =
         * 	    address[exp2]()
         * 	    value[exp3]()
         * 	    <push> exp1.getType().numberOfBytes
         * 	    <muli>
         * 	    <addi>
         */
        arrayAccess.var.accept(this, parameter);
        arrayAccess.index.accept(valueCGVisitor, null);
        cg.pushi(arrayAccess.type.numberOfBytes());
        cg.muli();
        cg.addi();
        return null;
    }

    @Override
    public Void visit(StructAccess structAccess, Void parameter) {
        /**
         * address[[StructAccess: exp1 → exp2 ID]] =
         *      address[[exp2]]
         *      <pushi> exp2.type.getField(ID).offset
         *      <addi>
         */
        structAccess.expression.accept(this, parameter);
        Struct struct = (Struct) structAccess.expression.getType();
        cg.pushi(struct.getField(structAccess.field).offset);
        cg.addi();
        return null;
    }
}
