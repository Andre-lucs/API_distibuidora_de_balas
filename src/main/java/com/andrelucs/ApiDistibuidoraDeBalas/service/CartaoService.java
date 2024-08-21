package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cartao;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.CartaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartaoService {

    private CartaoRepository repository;

    public List<Cartao> findAll(){
        return repository.findAll();
    }

    public Cartao save(Cartao card) {
        return repository.save(card);
    }
}
