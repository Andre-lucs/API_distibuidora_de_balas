package com.andrelucs.ApiDistibuidoraDeBalas.loader;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cartao;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Produto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Venda;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaProduto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaCartoesId;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaCartoes;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaProdutoId;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.CartaoRepository;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.ProdutoRepository;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.VendaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class Loader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(Loader.class);

    private final CartaoRepository cartaoRepository;
    private final VendaRepository vendaRepository;

    private  final ProdutoRepository produtoRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public Loader(CartaoRepository cartaoRepository, VendaRepository vendaRepository, ProdutoRepository produtoRepository, EntityManager entityManager) {
        this.cartaoRepository = cartaoRepository;
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // criando, salvando e imprimindo cartão
        Cartao cartao = new Cartao();
        cartao.setNome("Andre");
        cartao.setBandeira("MASTERCARD");

        var cartaosalvo = cartaoRepository.save(cartao);

        logger.info("Salvo com ID: {}", cartaosalvo.getNumero());

        //Criando produto e salvando o mesmo para usar em venda
        Produto produto= new Produto();
        produto.setDescricao("Arroz caçarola");
        produto.setQuantidadeAtual(2);

        var produtoSalvo = produtoRepository.save(produto);


        // criando venda
        Venda venda = new Venda();
        Venda vendaCupom= venda.setValorTotal(232d,"Andre","8399999999","Rua Projetada", venda);
        venda = vendaRepository.save(vendaCupom);


        //Criando o relacionamento entre venda e produto
        VendaProduto produtos = new VendaProduto();
        produtos.setVenda(venda);
        produtos.setProduto(produtoSalvo);
        produtos.setId(new VendaProdutoId(produto.getCodBarras(), venda.getCodigo()));
        produtos.setQuantidade(1L);
        produtos.setPrecoUnitario(7L);
        venda.setProdutos(Set.of(produtos));


        // criando relacionamento entre venda e cartão (vendaCartões)
        VendaCartoes cartoes = new VendaCartoes();

        cartoes.setCartao(cartaosalvo);
        cartoes.setVenda(venda);
        cartoes.setId(new VendaCartoesId(cartao.getNumero(), venda.getCodigo())); // mandando as PK's para montar chave composta
        cartoes.setValor(122d);
        venda.setCartoes(Set.of(cartoes));
        entityManager.persist(cartoes);


        Optional<Venda> vendas = vendaRepository.findById(venda.getCodigo());

        logger.info("Vendas : {}", vendas);

    }

}
