package com.andrelucs.ApiDistibuidoraDeBalas.controller;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Conta;
import com.andrelucs.ApiDistibuidoraDeBalas.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/conta")
@AllArgsConstructor
public class ContaController {

    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getContas() {
        return ResponseEntity.ok(contaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Conta> createConta(Conta conta) {
        return ResponseEntity.ok(contaService.save(conta));
    }
}
