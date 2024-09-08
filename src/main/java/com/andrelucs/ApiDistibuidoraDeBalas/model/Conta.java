package com.andrelucs.ApiDistibuidoraDeBalas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Double valor;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;

    @OneToMany(mappedBy = "conta")
    private List<Venda> vendas;

    @Override
    public String toString() {
        return "Conta{" +
                "codigo=" + codigo +
                ", valor=" + valor +
                ", data=" + data +
                ", cliente=" + cliente +
                '}';
    }

    @PrePersist
    public void prePersist() {
        if (data == null) {
            data = LocalDate.now();
        }
    }
}
