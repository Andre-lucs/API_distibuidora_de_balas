package com.andrelucs.ApiDistibuidoraDeBalas.controller;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Fornecedor;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.FornecedorRepository;
import com.andrelucs.ApiDistibuidoraDeBalas.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/fornecedor")
@AllArgsConstructor
public class FornecedorControlle {
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity <List<Fornecedor>> getFornecedor(){
        return ResponseEntity.ok(fornecedorService.listarFornecedores());
    }

    @PostMapping
    public ResponseEntity<Fornecedor> postFornecedor(Fornecedor fornecedor){
        return ResponseEntity.ok(fornecedorService.salvarFornecedor(fornecedor));
    }
}
