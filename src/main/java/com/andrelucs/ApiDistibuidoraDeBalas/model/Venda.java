package com.andrelucs.ApiDistibuidoraDeBalas.model;

import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaCartoes;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codigo;
    private LocalDate data;
    private LocalTime hora;
    private Double valorTotal;

    @ManyToOne
    private Funcionario funcionario;

    @OneToMany(mappedBy = "venda")
    private Set<VendaCartoes> cartoes;

    @OneToMany(mappedBy = "venda")
    private Set<VendaProduto> produtos;

    @OneToOne
    private Cupom cupom;

    @PrePersist
    public void prePersist() {
        if (data == null) {
            data = LocalDate.now();
        }
        if (hora == null) {
            hora = LocalTime.now();
        }
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cartoes=" + cartoes +
                ", codigo=" + codigo +
                ", data=" + data +
                ", hora=" + hora +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
