package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Funcionario;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private FuncionarioRepository repository;

    public List<Funcionario> findAll() {return repository.findAll();}

    public Funcionario save (Funcionario funcionario) { return repository.save(funcionario);}
}
