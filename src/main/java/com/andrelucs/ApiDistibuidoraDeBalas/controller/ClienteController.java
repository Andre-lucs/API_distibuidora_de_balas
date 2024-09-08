package com.andrelucs.ApiDistibuidoraDeBalas.controller;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cliente;
import com.andrelucs.ApiDistibuidoraDeBalas.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(Cliente cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }
}
