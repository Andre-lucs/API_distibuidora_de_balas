package com.andrelucs.ApiDistibuidoraDeBalas.controller;


import com.andrelucs.ApiDistibuidoraDeBalas.model.Funcionario;
import com.andrelucs.ApiDistibuidoraDeBalas.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/funcionario")
@AllArgsConstructor
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionarios() { return ResponseEntity.ok(funcionarioService.findAll());}

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(Funcionario funcionario) { return ResponseEntity.ok(funcionarioService.save(funcionario));}
}