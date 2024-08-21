package com.andrelucs.ApiDistibuidoraDeBalas.repository;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendaRepository extends JpaRepository<Venda, UUID> {
}
