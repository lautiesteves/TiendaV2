package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serial;

@Entity(name = "Prenda")
@Table
public class Prenda {

    @Id
    @SequenceGenerator(
            name = "prenda_sequence",
            sequenceName = "prenda_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prenda_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "detalle",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String detalle;

    @Column(
            name = "precio",
            nullable = false
    )
    private Float precio;

    private Integer stock;

    public Prenda() {
    }

    public Prenda(String detalle, Float precio, Integer stock) {
        this.detalle = detalle;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void reducirStock(){this.stock = this.stock - 1;}

    @Override
    public String toString() {
        return "Prenda{" +
                "id=" + id +
                ", detalle='" + detalle + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

}
