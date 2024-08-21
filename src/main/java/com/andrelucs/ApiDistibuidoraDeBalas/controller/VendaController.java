package com.andrelucs.ApiDistibuidoraDeBalas.controller;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Venda;
import com.andrelucs.ApiDistibuidoraDeBalas.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/venda")
@AllArgsConstructor
public class VendaController {

    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> getVendas(){
        return ResponseEntity.ok(vendaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Venda> createVenda(Venda venda){
        return ResponseEntity.ok(vendaService.save(venda));
    }
}