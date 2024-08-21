package com.andrelucs.ApiDistibuidoraDeBalas.model.relationships;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Cartao;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Venda;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.VendaCartoesId;
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
public class VendaCartoes {
    @EmbeddedId
    private VendaCartoesId id;

    @ManyToOne
    @MapsId("codigoVenda")
    @JoinColumn(name = "codigo_venda")
    private Venda venda;

    @ManyToOne
    @MapsId("numeroCartao")
    @JoinColumn(name = "numero_cartao")
    private Cartao cartao;

    private Double valor;

    @Override
    public String toString() {
        return "VendaCartoes{" +
                ", id=" + id +
                ", valor=" + valor +
                '}';
    }
}
