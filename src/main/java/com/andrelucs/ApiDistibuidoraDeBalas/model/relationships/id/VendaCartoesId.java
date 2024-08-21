package com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class VendaCartoesId implements Serializable {
    @Column(name = "numero_cartao")
    private Long numeroCartao;
    @Column(name = "codigo_venda")
    private UUID codigoVenda;
}
