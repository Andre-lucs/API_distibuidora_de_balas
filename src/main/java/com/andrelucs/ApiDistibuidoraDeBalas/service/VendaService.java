package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cupom;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Venda;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class VendaService {

    private VendaRepository repository;

    public List<Venda> findAll(){
        return repository.findAll();
    }

    public Venda save(Venda venda) {
        venda.setData(LocalDate.now());
        venda.setHora(LocalTime.now());
        return repository.save(venda);
    }
}
