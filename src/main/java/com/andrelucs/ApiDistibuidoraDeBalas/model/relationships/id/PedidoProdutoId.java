package com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id;

import com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.PedidoProduto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PedidoProdutoId  implements Serializable {
    @Column (name = "codigo_pedido" )
    private UUID codigo;

    @Column (name = "codigo_de_barras_produto")
    private  UUID codBarras;

    public PedidoProdutoId(Set<PedidoProduto> pedidos, UUID codBarras) {
    }
}
