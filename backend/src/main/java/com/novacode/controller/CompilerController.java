package com.novacode.controller;

import com.novacode.service.CompilerService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CompilerController {

    private final CompilerService compilerService;

    public CompilerController(CompilerService compilerService) {
        this.compilerService = compilerService;
    }

    @PostMapping("/compile")
    public Map<String, Object> compile(@RequestBody String code) {
        return compilerService.compile(code);
    }
}