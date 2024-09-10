package com.andrelucs.ApiDistibuidoraDeBalas.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
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

    @OneToMany (mappedBy = "funcionario")
    private List<Pedido> pedidos;

    @Override
    public String toString() {
        return "Funcionario{" +
                "cargo='" + cargo + '\'' +
                ", codigo=" + codigo +
                ", cpf='" + cpf + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", endereco='" + endereco + '\'' +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
