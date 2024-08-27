package com.andrelucs.ApiDistibuidoraDeBalas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dependente {

    @Id
    private String cpf;
    private String registroGeral;
    private String nome;

    @ManyToOne
    private Funcionario funcionario;
}
