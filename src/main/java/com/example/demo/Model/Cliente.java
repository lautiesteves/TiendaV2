package com.example.demo.Model;

import javax.persistence.*;

@Entity(name = "Cliente")
@Table
public class Cliente {
    @Id
    @SequenceGenerator(
            name = "cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;
    @Column(
            name = "apellido",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String apellido;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            name = "credito"
    )
    private Float credito;

    @Column(
            name = "compras"
    )
    private Integer compras;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, Float credito, Integer compras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.credito = credito;
        this.compras = compras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getCredito() {
        return credito;
    }

    public void setCredito(Float credito) {
        this.credito = credito;
    }

    public Integer getCompras() {
        return compras;
    }

    public void setCompras(Integer compras) {
        this.compras = compras;
    }

    public void aumentarCompras(){this.compras = this.compras + 1;}

    public void ajustarCredito(Float precio){this.credito = this.credito - precio;}

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", credito=" + credito +
                ", compras=" + compras +
                '}';
    }
}
