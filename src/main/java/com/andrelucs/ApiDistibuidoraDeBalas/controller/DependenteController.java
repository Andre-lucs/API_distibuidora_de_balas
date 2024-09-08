package com.andrelucs.ApiDistibuidoraDeBalas.controller;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Dependente;
import com.andrelucs.ApiDistibuidoraDeBalas.service.DependenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/dependente")
@AllArgsConstructor
public class DependenteController {

    private DependenteService dependenteService;

    @GetMapping
    public ResponseEntity<List<Dependente>> getDependentes() { return ResponseEntity.ok(dependenteService.findAll());}

    @PostMapping
    public ResponseEntity<Dependente> createDependente(Dependente dependente) { return ResponseEntity.ok(dependenteService.save(dependente));}
}