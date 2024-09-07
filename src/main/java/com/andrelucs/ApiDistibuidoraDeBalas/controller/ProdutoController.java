package com.andrelucs.ApiDistibuidoraDeBalas.controller;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Produto;
import com.andrelucs.ApiDistibuidoraDeBalas.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/api/produto")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() { return ResponseEntity.ok(produtoService.findAll());}

    @PostMapping
    public ResponseEntity<Produto> createProduto(Produto produto) { return ResponseEntity.ok(produtoService.save(produto));}

}
