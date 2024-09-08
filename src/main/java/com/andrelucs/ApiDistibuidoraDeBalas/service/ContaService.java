package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Conta;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContaService {

    private ContaRepository repository;

    public List<Conta> findAll() {
        return repository.findAll();
    }

    public Conta save(Conta conta) {
        return repository.save(conta);
    }
}
