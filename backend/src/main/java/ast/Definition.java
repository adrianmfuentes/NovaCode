package ast;

public interface Definition extends Locatable {

    Type getType();

    String getName();

    int getScope();

    void setScope(int scope);

}
