package ast.types;

import ast.Locatable;
import ast.Type;
import visitor.Visitor;

import java.util.List;

public class Struct extends AbstractType {
    public List<Field> fields;

    public Struct(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Struct of " + fields.toString();
    }

    @Override
    public Type dot(String field, Locatable locatable) {
        for(Field f : fields) {
            if (f.name.equals(field)) {
                return f.typeOf;
            }
        }

        return new ErrorType("Struct does not have field " + field, locatable);
    }

    @Override
    public int numberOfBytes() {
        return this.fields.stream().mapToInt(rf -> rf.typeOf.numberOfBytes()).sum();
    }

    public Field getField(String field) {
        for(Field f : fields) {
            if (f.name.equals(field)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }
}