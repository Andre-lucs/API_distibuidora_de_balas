package com.andrelucs.ApiDistibuidoraDeBalas.controller;


import com.andrelucs.ApiDistibuidoraDeBalas.model.Cupom;
import com.andrelucs.ApiDistibuidoraDeBalas.service.CupomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/cupom")
@AllArgsConstructor
public class CupomController {

    private CupomService cupomService;

    @GetMapping
    public ResponseEntity<List<Cupom>> getCupons() { return ResponseEntity.ok(cupomService.findAll());}

    @PostMapping
    public ResponseEntity<Cupom> createCupom(Cupom cupom) { return ResponseEntity.ok(cupomService.save(cupom));}
}
