package com.andrelucs.ApiDistibuidoraDeBalas.repository;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
