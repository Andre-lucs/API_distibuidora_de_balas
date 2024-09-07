package com.andrelucs.ApiDistibuidoraDeBalas.model.relationships;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cartao;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Produto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Venda;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaCartoesId;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaProdutoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaProduto {
    @EmbeddedId
    private VendaProdutoId id;

    @ManyToOne
    @MapsId("codigoVenda")
    @JoinColumn(name = "codigo_venda")
    private Venda venda;

    @ManyToOne
    @MapsId("numeroCartao")
    @JoinColumn(name = "codigo_de_barra")
    private Produto produto;

    private Long quantidade;
    private Long precoUnitario;

    @Override
    public String toString() {
        return "VendaProduto{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
