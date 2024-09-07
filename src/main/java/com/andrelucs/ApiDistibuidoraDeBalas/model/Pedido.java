package com.andrelucs.ApiDistibuidoraDeBalas.model;

import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.PedidoProduto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private UUID codigo;
    private Double valor;
    private LocalDate data;
    private String status;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToOne
    private Funcionario funcionario;

    @OneToMany(mappedBy = "pedido")
    private Set<PedidoProduto> pedidos;

    @PrePersist
    public void prePersist() {
        if (data == null) {
            data = LocalDate.now();
        }
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", valor=" + valor +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", fornecedor=" + fornecedor +
                ", funcionario=" + funcionario +
                '}';
    }
}
