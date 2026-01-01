package ast;

public interface Expression extends Locatable {

    boolean getLvalue();

    void setLvalue(boolean lvalue);

    Type getType();

    void setType(Type type);
}
