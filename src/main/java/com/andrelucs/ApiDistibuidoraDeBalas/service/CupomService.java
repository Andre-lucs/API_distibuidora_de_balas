package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cupom;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.CupomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CupomService {

    private CupomRepository repository;

    public List<Cupom> findAll() { return repository.findAll(); }

    public Cupom save (Cupom cupom) { return repository.save(cupom);}

}
