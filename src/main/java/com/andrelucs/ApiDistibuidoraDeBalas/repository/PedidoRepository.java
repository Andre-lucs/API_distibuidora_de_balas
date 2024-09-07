package com.andrelucs.ApiDistibuidoraDeBalas.repository;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
