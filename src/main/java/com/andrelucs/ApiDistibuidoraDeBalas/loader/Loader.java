package com.andrelucs.ApiDistibuidoraDeBalas.loader;

import com.andrelucs.ApiDistibuidoraDeBalas.model.*;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.PedidoProduto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaProduto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.PedidoProdutoId;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaCartoesId;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaCartoes;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaProdutoId;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.CartaoRepository;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.FornecedorRepository;
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

    private final FornecedorRepository fornecedorRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public Loader(CartaoRepository cartaoRepository, VendaRepository vendaRepository, ProdutoRepository produtoRepository, FornecedorRepository fornecedorRepository, EntityManager entityManager) {
        this.cartaoRepository = cartaoRepository;
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //Criando e salvando fornecedor
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("70.108.090/0001-20");
        fornecedor.setEmail("paubrasil@coporation.com.br");
        fornecedor.setRazaoSocial("Comel. Pau Brasil Distr.");
        fornecedor.setTelefone("(83) 3531-1928");
        var fornecedorSalvo = fornecedorRepository.save(fornecedor);

        //Criando e salvandoproduto para pedido
        Produto produtoPedido= new Produto();
        produtoPedido.setDescricao("Bala hortelã");
        produtoPedido.setQuantidadeAtual(19); //pacotes
        var produtoPedidoSalvo = produtoRepository.save(produtoPedido);

        //Criando pedido
        Pedido pedido = new Pedido();
        pedido.setFornecedor(fornecedorSalvo);
        pedido.setValor(1713D);
        pedido.setStatus("Pendente");

        //Criando relacionamento entre pedido e produto
        PedidoProduto pedidoProdutoRelacao= new PedidoProduto();
        pedidoProdutoRelacao.setPedido(pedido);
        pedidoProdutoRelacao.setProduto(produtoPedidoSalvo);
        pedidoProdutoRelacao.setId(new PedidoProdutoId(pedido.getPedidos(), produtoPedidoSalvo.getCodBarras()));

        pedido.setPedidos(Set.of(pedidoProdutoRelacao));
        entityManager.persist(pedidoProdutoRelacao);


        // criando, salvando e imprimindo cartão
        Cartao cartao = new Cartao();
        cartao.setNome("Andre");
        cartao.setBandeira("MASTERCARD");
        var cartaoSalvo = cartaoRepository.save(cartao);
        logger.info("Salvo com ID: {}", cartaoSalvo.getNumero());

        //Criando produto e salvando o mesmo para usar em venda
        Produto produto= new Produto();
        produto.setDescricao("Pipoca reizinho");
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
        entityManager.persist(produtos);


        // criando relacionamento entre venda e cartão (vendaCartões)
        VendaCartoes cartoes = new VendaCartoes();

        cartoes.setCartao(cartaoSalvo);
        cartoes.setVenda(venda);
        cartoes.setId(new VendaCartoesId(cartao.getNumero(), venda.getCodigo())); // mandando as PK's para montar chave composta
        cartoes.setValor(122d);
        venda.setCartoes(Set.of(cartoes));
        entityManager.persist(cartoes);


        Optional<Venda> vendas = vendaRepository.findById(venda.getCodigo());

        logger.info("Vendas : {}", vendas);

    }

}
