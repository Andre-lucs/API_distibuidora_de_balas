package com.andrelucs.ApiDistibuidoraDeBalas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Funcionario {
    @Id
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private LocalDate dataAdmissao;
    private Double salario;
    private String cargo;

    @OneToMany(mappedBy = "funcionario")
    List<Venda> vendas;

    @OneToMany(mappedBy = "funcionario")
    private List<Dependente> dependentes;
}
