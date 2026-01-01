package codegenerator;

import ast.Definition;
import ast.Type;
import ast.definition.VarDefinition;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class CodeGenerator {
    private final FileWriter out;
    private int labels = 1;

    public CodeGenerator(String outputFile, String inputFile) {
        try {
            out = new FileWriter(outputFile);
            writeNewLine(); out.write("#source " + "\"" + inputFile + "\"" + "\n"); writeNewLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeNewLine() {
        try {
            out.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeTab() {
        try {
            out.write("\t");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeInFile(String ...args) {
        try {
            for (String arg : args) out.write(arg);
            out.write("\n");
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    public String nextLabel() {
        this.labels++;
        return "label" + this.labels;
    }

    public void mainFunctionInvocation() {
        writeNewLine();
        writeInFile("' Invocation to the main function \n");
        writeInFile("call main");
    }

    public void halt() {
        writeInFile("halt");
        writeNewLine();
    }

    public void pushBP() {
        writeTab();
        writeInFile("push bp");
    }

    public void load(String suffix) {
        writeTab();
        writeInFile("load" + suffix);
    }

    public void store(String suffix) {
        writeTab();
        writeInFile("store" + suffix);
    }

    public void pushAddress(Definition definition) {
        VarDefinition vdef = (VarDefinition) definition;

        if(vdef.getScope() == 0) {
            push("a", vdef.offset);
        } else {
            pushBP();
            pushi(vdef.offset);
            writeTab();
            writeInFile("addi");
        }
    }

    public void pushi(int value) {
        writeTab();
        writeInFile("pushi " + value);
    }

    public void pushf(double value) {
        writeTab();
        writeInFile("pushf " + value);
    }

    public void pushb(char value) {
        writeTab();
        writeInFile("pushb " + (int) value);
    }

    public void push(String suffix, int value) {
        writeTab();
        writeInFile("push" + suffix + " " + value);
    }

    public void sub(String suffix) {
        writeTab();
        writeInFile("sub" + suffix);
    }

    public void convertTo(Type of, Type to) {
        if(Objects.equals(of.suffix(), to.suffix())) return;
        writeTab();

        if (to.suffix().equals("b") && of.suffix().equals("f")){ // f -> b , real -> int -> char
            writeInFile("f2i");
            writeInFile("i2b");
        } else if (to.suffix().equals("f") && of.suffix().equals("b")){ // b -> f , char -> int -> real
            writeInFile("b2i");
            writeTab();writeInFile("i2f");
        } else {
            writeInFile(of.suffix() + "2" + to.suffix()); // direct conversion (i2b, b2i, i2f, f2i)
        }
    }

    public void arithmetic(String operator, Type type) {
        writeTab();
        switch (operator) {
            case "+": writeInFile("add", type.suffix()); break;
            case "-": writeInFile("sub", type.suffix()); break;
            case "*": writeInFile("mul", type.suffix()); break;
            case "/": writeInFile("div", type.suffix()); break;
            case "%": writeInFile("mod", type.suffix()); break;
        }
    }

    public void logical(String operator) {
        writeTab();
        switch (operator) {
            case "&&": writeInFile("and"); break;
            case "||": writeInFile("or"); break;
        }
    }

    public void comparison(String operator, Type type) {
        writeTab();
        switch (operator) {
            case ">": writeInFile("gt", type.suffix()); break;
            case "<": writeInFile("lt", type.suffix()); break;
            case "==": writeInFile("eq", type.suffix()); break;
            case "!=": writeInFile("ne", type.suffix()); break;
            case ">=": writeInFile("ge", type.suffix()); break;
            case "<=": writeInFile("le", type.suffix()); break;
        }
    }

    public void not() {
        writeTab();
        writeInFile("not");
    }

    public void writeGlobal(String name, String type, int offset) {
        writeTab();
        writeInFile("'* " + type + " " + name + " (offset " + offset + ")");
    }

    public void writeLine(int line) {
        writeNewLine();
        writeInFile("#line " + line);
    }

    public void writeFunctionName(String name) {
        writeNewLine();
        writeInFile(name + ":");
    }

    public void writeParameters() {
        writeTab();
        writeInFile("'* Parameters:");
    }

    public void writeLocals() {
        writeTab();
        writeInFile("'* Local variables:");
    }

    public void writeEnter(int value) {
        writeTab();
        writeInFile("enter " + value);
    }

    public void write() {
        writeTab();
        writeInFile("'* Write");
    }

    public void read() {
        writeTab();
        writeInFile("'* Read");
    }

    public void out(String suffix) {
        writeTab();
        writeInFile("out" + suffix);
    }

    public void ret(int bytesReturn, int bytesLocals, int  bytesParams) {
        writeTab();
        writeInFile("ret " + bytesReturn + ", " + bytesLocals + ", " + bytesParams);
    }

    public void assignment() {
        writeTab();
        writeInFile("'* Assignment");
    }

    public void writeLabel(String conditionLabel) {
        writeTab();
        writeInFile(conditionLabel + ":");
    }

    public void jz(String exitLabel) {
        writeTab();
        writeInFile("jz " + exitLabel);
    }

    public void jmp(String conditionLabel) {
        writeTab();
        writeInFile("jmp " + conditionLabel);
    }

    public void addi() {
        writeTab();
        writeInFile("addi");
    }

    public void in(String suffix) {
        writeTab();
        writeInFile("in" + suffix);
    }

    public void muli() {
        writeTab();
        writeInFile("muli");
    }

    public void call(String name) {
        writeTab();
        writeInFile("call " + name);
    }

    public void pop(String suffix) {
        writeTab();
        writeInFile("pop" + suffix);
    }
}
