package com.andrelucs.ApiDistibuidoraDeBalas.model;

import com.andrelucs.ApiDistibuidoraDeBalas.loader.Loader;
import com.andrelucs.ApiDistibuidoraDeBalas.repository.VendaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VendaTest {

    @Autowired
    private VendaRepository vendaRepository;

    @Test
    void getValorTotal() {
        Venda venda = new Venda();
        venda.setValorTotal(222d);
        venda = vendaRepository.save(venda);

        var savedVenda = vendaRepository.findById(venda.getCodigo());
        assertTrue(savedVenda.isPresent());
        assertEquals(222d, savedVenda.get().getValorTotal());
    }

    @Test
    void getCartoes() {
        // Your test for getCartoes method
    }
}