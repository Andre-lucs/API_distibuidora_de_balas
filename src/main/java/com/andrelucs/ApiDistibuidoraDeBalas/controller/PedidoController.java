package com.andrelucs.ApiDistibuidoraDeBalas.controller;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Pedido;
import com.andrelucs.ApiDistibuidoraDeBalas.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/pedido")
@AllArgsConstructor
public class PedidoController {
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity <List<Pedido>> getPedidos(){
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    public  ResponseEntity<Pedido> createPedido(Pedido pedido){
        return ResponseEntity.ok(pedidoService.salvarPedido(pedido));
    }

}
