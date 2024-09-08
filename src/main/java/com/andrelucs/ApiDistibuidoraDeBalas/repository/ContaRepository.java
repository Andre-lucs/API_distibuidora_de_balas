package com.andrelucs.ApiDistibuidoraDeBalas.repository;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
