package com.novacode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovacodeApplication {
    public static void main(String[] args) {
        // Servidor embebido Tomcat en el puerto 8080
        SpringApplication.run(NovacodeApplication.class, args);
    }
}