package com.andrelucs.ApiDistibuidoraDeBalas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String telefone;
    private String endereco;

    @OneToOne
    private Venda venda;

    @Override
    public String toString() {
        return "Cupom{" +
                "endereco='" + endereco + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
