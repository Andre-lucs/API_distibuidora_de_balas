package com.andrelucs.ApiDistibuidoraDeBalas.model;

import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaCartoes;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.VendaProduto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @OneToOne(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cupom cupom;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Conta conta;

    @PrePersist
    public void prePersist() {
        if (data == null) {
            data = LocalDate.now();
        }
        if (hora == null) {
            hora = LocalTime.now();
        }
    }
    public Venda setValorTotal(Double valorTotal, String nome, String telefone, String endereco) {
        if (valorTotal > 100) {
            Cupom cupom = new Cupom();
            cupom.setNome(nome);
            cupom.setTelefone(telefone);
            cupom.setEndereco(endereco);
            cupom.setVenda(this);
            setCupom(cupom);
        }
        this.valorTotal = valorTotal;
        return this;
    }

    public void setCliente(Cliente cliente){
        Conta conta = new Conta();
        conta.setCliente(cliente);
        conta.setValor(getValorTotal());
        this.conta = conta;
    }



}
