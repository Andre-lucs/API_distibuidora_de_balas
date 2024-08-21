package com.andrelucs.ApiDistibuidoraDeBalas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private String nome;
    private String bandeira;


    @Override
    public String toString() {
        return "Cartao{" +
                "bandeira='" + bandeira + '\'' +
                ", numero=" + numero +
                ", nome='" + nome + '\'' +
                '}';
    }
}
