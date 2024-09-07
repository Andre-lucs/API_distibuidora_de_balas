package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Fornecedor;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FornecedorService {
    private FornecedorRepository repository;

    public List<Fornecedor> listarFornecedores(){
        return  repository.findAll();
    }
    public Fornecedor salvarFornecedor(Fornecedor fornecedor){
        return repository.save(fornecedor);
    }
}
