package com.andrelucs.ApiDistibuidoraDeBalas.loader;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cartao;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Venda;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaCartoesId;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaCartoes;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.CartaoRepository;
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

    @PersistenceContext
    private final EntityManager entityManager;

    public Loader(CartaoRepository cartaoRepository, VendaRepository vendaRepository, EntityManager entityManager) {
        this.cartaoRepository = cartaoRepository;
        this.vendaRepository = vendaRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Cartao cartao = new Cartao();
        cartao.setNome("Andre");
        cartao.setBandeira("MASTERCARD");

        var cartaosalvo = cartaoRepository.save(cartao);

        logger.info("Salvo com ID: {}", cartaosalvo.getNumero());

        Venda venda = new Venda();
        venda.setValorTotal(232d);
        venda = vendaRepository.save(venda);

        VendaCartoes cartoes = new VendaCartoes();
        cartoes.setCartao(cartaosalvo);
        cartoes.setVenda(venda);
        cartoes.setId(new VendaCartoesId(cartao.getNumero(), venda.getCodigo()));
        cartoes.setValor(122d);
        venda.setCartoes(Set.of(cartoes));
        entityManager.persist(cartoes);


        Optional<Venda> vendas = vendaRepository.findById(venda.getCodigo());

        logger.info("Vendas : {}", vendas);

    }

}
