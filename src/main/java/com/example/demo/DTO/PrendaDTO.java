package com.example.demo.DTO;

import com.example.demo.Model.Prenda;
import lombok.Data;

import java.io.Serializable;

@Data
public class PrendaDTO implements Serializable {

    private Long id;
    private String detalle;
    private Float precio;
    private Integer stock;

    public PrendaDTO(Prenda prenda) {
        this.setId(prenda.getId());
        this.setDetalle(prenda.getDetalle());
        this.setPrecio(prenda.getPrecio());
        this.setStock(prenda.getStock());
    }

    public PrendaDTO() {}
}
