package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Pedido;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {
    private PedidoRepository repository;
    public List<Pedido> listarPedidos(){
        return repository.findAll();
    }

    public Pedido salvarPedido(Pedido pedido){
        pedido.setData(LocalDate.now());
        return repository.save(pedido);
    }
}
