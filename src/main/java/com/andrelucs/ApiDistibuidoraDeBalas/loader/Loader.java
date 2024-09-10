package com.andrelucs.ApiDistibuidoraDeBalas.loader;

import com.andrelucs.ApiDistibuidoraDeBalas.model.*;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.PedidoProduto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaProduto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.PedidoProdutoId;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaCartoesId;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaCartoes;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaProdutoId;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Component
public class Loader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(Loader.class);

    private final CartaoRepository cartaoRepository;
    private final VendaRepository vendaRepository;

    private  final ProdutoRepository produtoRepository;

    private final FornecedorRepository fornecedorRepository;

    private  final FuncionarioRepository funcionarioRepository;

    private  final DependenteRepository dependenteRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public Loader(CartaoRepository cartaoRepository, VendaRepository vendaRepository, ProdutoRepository produtoRepository, FornecedorRepository fornecedorRepository, EntityManager entityManager, FuncionarioRepository funcionarioRepository, DependenteRepository dependenteRepository) {
        this.cartaoRepository = cartaoRepository;
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.entityManager = entityManager;
        this.funcionarioRepository = funcionarioRepository;
        this.dependenteRepository = dependenteRepository;

    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //Criando e salvando Funcionario
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Carlos Silva");
        funcionario.setCpf("11177788837");
        funcionario.setCargo("Atendente");
        funcionario.setSalario(1200.00);
        funcionario.setDataAdmissao(LocalDate.now());
        funcionario.setEndereco("Rua das Flores");
        funcionario.setTelefone("839991110849");
        var funcionarioSalvo = funcionarioRepository.save(funcionario);


        // Criando e salvando dependentes
        Dependente dependente = new Dependente();
        dependente.setCpf("73746749821");
        dependente.setNome("Geraldo Silva");
        dependente.setRegistroGeral("39848978478974");
        dependente.setFuncionario(funcionario);
        var dependenteSalvo = dependenteRepository.save(dependente);


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
        pedido.setFuncionario(funcionario);


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
        venda.setFuncionario(funcionario);
        Venda vendaCupom= venda.setValorTotal(232d,"Andre","8399999999","Rua Projetada");
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

        Cliente cliente = new Cliente();
        cliente.setNome("Jose");
        cliente.setCpf("11111111111");
        cliente.setEndereco("Rua do Meio");
        cliente.setTelefone("40028922");

        venda.setCliente(cliente);

        entityManager.persist(venda);

        venda = entityManager.find(venda.getClass(), venda.getCodigo());
        logger.info("Venda final:" + venda);


    }

}
