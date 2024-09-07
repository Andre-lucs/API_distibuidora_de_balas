package com.andrelucs.ApiDistibuidoraDeBalas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID codBarras;

    private String descricao;
    private Integer quantidadeAtual;

    @Override
    public String toString() {
        return "Produto{" +
                "codBarras='" + codBarras + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidadeAtual=" + quantidadeAtual +
                '}';
    }
}
