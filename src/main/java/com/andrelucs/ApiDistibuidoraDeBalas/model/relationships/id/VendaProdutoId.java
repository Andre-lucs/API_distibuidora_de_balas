package com.andrelucs.ApiDistibuidoraDeBalas.model.relationships.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class VendaProdutoId implements Serializable {

    @Column (name = "codigo_de_barras")
    private UUID codBarras;

    @Column (name = "codigo_venda")
    private UUID codigoVenda;

}
