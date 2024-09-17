package com.cursoPlatzi.platzi_market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ComprasProductoPK implements Serializable {
    @Column(name = "id_compra")
    private Integer idNommbre;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdNommbre() {
        return idNommbre;
    }

    public void setIdNommbre(Integer idNommbre) {
        this.idNommbre = idNommbre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
