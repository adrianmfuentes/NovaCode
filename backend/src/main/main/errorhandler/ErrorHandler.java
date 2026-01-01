package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {
    private static ErrorHandler instance;
    public List<ErrorType> typesOfErrors;

    public ErrorHandler() {
        typesOfErrors = new ArrayList<>();
    }

    public static ErrorHandler getInstance() {
        if(instance == null) instance = new ErrorHandler();
        return instance;
    }

    public void addError(ErrorType errorType) {
        if (errorType != null) this.typesOfErrors.add(errorType);
    }

    public boolean anyError() {
        return !this.typesOfErrors.isEmpty();
    }

    public void showErrors(PrintStream err) {
        for (ErrorType errorType : this.typesOfErrors) {
            err.println(errorType.toString());
        }
    }
}
