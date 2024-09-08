package com.andrelucs.ApiDistibuidoraDeBalas.repository;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
}
