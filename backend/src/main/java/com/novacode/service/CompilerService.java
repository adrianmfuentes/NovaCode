package com.novacode.service;

import org.springframework.stereotype.Service;
import org.antlr.v4.runtime.*;
import java.io.*;
import java.util.*;
import ast.ASTNode;
import parser.*;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;
import visitor.*;
import errorhandler.ErrorHandler;
import codegenerator.*;

@Service
public class CompilerService {

    public Map<String, Object> compile(String sourceCode) {
        Map<String, Object> result = new LinkedHashMap<>(); // Usamos LinkedHashMap para mantener el orden de las claves

        // 1. LIMPIEZA: Crucial para que los errores de una petición no salgan en la siguiente
        ErrorHandler.getInstance().clearErrors();

        try {
            // 2. LEXER Y PARSER
            CharStream input = CharStreams.fromString(sourceCode);
            PmmLexer lexer = new PmmLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PmmParser parser = new PmmParser(tokens);

            // Intentamos generar el AST
            PmmParser.ProgramContext context = parser.program();
            ASTNode ast = context.ast;

            // 3. CONTROL DE ERRORES SINTÁCTICOS
            // Si el parser detectó errores o el AST no se pudo crear, paramos aquí
            if (ast == null || ErrorHandler.getInstance().anyError()) {
                result.put("status", "error");
                result.put("stage", "Syntax / Lexical");
                result.put("errors", getErrorsAsString());
                return result;
            }

            // 4. ANÁLISIS SEMÁNTICO (VISITORS)
            ast.accept(new IdentificationVisitor(), null);
            ast.accept(new TypeCheckingVisitor(), null);

            // 5. CONTROL DE ERRORES SEMÁNTICOS
            if (ErrorHandler.getInstance().anyError()) {
                result.put("status", "error");
                result.put("stage", "Semantic Analysis");
                result.put("errors", getErrorsAsString());
                return result;
            }

            // 6. GENERACIÓN DE CÓDIGO (OPCIONAL)
            // Por ahora solo ejecutamos el OffSetVisitor para comprobar que todo va bien
            ast.accept(new OffSetVisitor(), null);

            // Si todo ha ido bien hasta aquí:
            result.put("status", "success");
            result.put("message", "¡Compilación terminada con éxito!");
            result.put("output", "El AST ha sido validado correctamente.");

        } catch (Exception e) {
            // Captura cualquier fallo inesperado (como el NullPointer que tenías)
            result.put("status", "critical_error");
            result.put("message", "Error interno en el servidor: " + e.getMessage());

            // Imprimimos el error en la consola del backend para que tú puedas depurarlo
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Captura los errores acumulados en el ErrorHandler y los devuelve como String
     */
    private String getErrorsAsString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        ErrorHandler.getInstance().showErrors(ps);
        return baos.toString();
    }
}