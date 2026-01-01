package com.novacode.service;

import org.springframework.stereotype.Service;
import org.antlr.v4.runtime.*;
import java.io.*;
import java.util.*;
import ast.ASTNode;
import parser.*;
import semantic.*;
import errorhandler.ErrorHandler;
import codegenerator.*;

@Service
public class CompilerService {

    public Map<String, Object> compile(String sourceCode) {
        Map<String, Object> result = new LinkedHashMap<>();
        ErrorHandler.getInstance().clearErrors();

        try {
            CharStream input = CharStreams.fromString(sourceCode);
            PmmLexer lexer = new PmmLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PmmParser parser = new PmmParser(tokens);

            PmmParser.ProgramContext context = parser.program();
            ASTNode ast = context.ast;

            // 1. Fase Sintáctica
            if (ast == null || ErrorHandler.getInstance().anyError()) {
                return createErrorResponse("Syntax / Lexical", result);
            }

            // 2. Fase Semántica
            ast.accept(new IdentificationVisitor(), null);
            ast.accept(new TypeCheckingVisitor(), null);

            if (ErrorHandler.getInstance().anyError()) {
                return createErrorResponse("Semantic Analysis", result);
            }

            // 3. Generación de Código
            ast.accept(new OffSetVisitor(), null);
            CodeGenerator cg = new CodeGenerator();
            ast.accept(new ExecuteCGVisitor(cg), null);
            String finalCode = cg.getGeneratedCode();

            result.put("status", "success");
            result.put("message", "¡Compilación y generación exitosa!");
            result.put("generatedCode", finalCode);

        } catch (Exception e) {
            result.put("status", "critical_error");
            result.put("message", e.getMessage());
        }

        return result;
    }

    private Map<String, Object> createErrorResponse(String stage, Map<String, Object> result) {
        result.put("status", "error");
        result.put("stage", stage);
        result.put("errors", getErrorsAsString());
        return result;
    }

    private String getErrorsAsString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        ErrorHandler.getInstance().showErrors(ps);
        return baos.toString();
    }
}