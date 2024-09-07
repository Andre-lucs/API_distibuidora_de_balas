package com.andrelucs.ApiDistibuidoraDeBalas.service;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Produto;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;

    public List<Produto> findAll() {return repository.findAll();}

    public Produto save(Produto produto) { return repository.save(produto);}
}
