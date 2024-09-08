package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Dependente;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.DependenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DependenteService {
    private DependenteRepository repository;

    public List<Dependente> findAll () {return repository.findAll();}

    public Dependente save(Dependente dependente) {return repository.save(dependente);}
}
