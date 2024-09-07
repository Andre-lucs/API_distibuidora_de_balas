package com.andrelucs.ApiDistibuidoraDeBalas.model.relationships;

import com.andrelucs.ApiDistibuidoraDeBalas.model.Pedido;
import com.andrelucs.ApiDistibuidoraDeBalas.model.Produto;
import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id.PedidoProdutoId;
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
public class PedidoProduto {
    @EmbeddedId
    private PedidoProdutoId id;

    @ManyToOne
    @MapsId("codigo")
    @JoinColumn (name = "codigo_pedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("codBarras")
    @JoinColumn (name = "codigo_de_barras_produto")
    private Produto produto;

}
