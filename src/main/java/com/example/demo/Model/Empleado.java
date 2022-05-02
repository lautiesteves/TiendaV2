package com.example.demo.Model;

import javax.persistence.*;

@Entity(name = "Empleado")
@Table
public class Empleado {

    @Id
    @SequenceGenerator(
            name = "empleado_sequence",
            sequenceName = "empleado_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "empleado_sequence"
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
            name = "ventas",
            nullable = false
    )
    private Integer ventas;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String email, Integer ventas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ventas = ventas;
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

    public Integer getVentas() {
        return ventas;
    }

    public void setVentas(Integer ventas) {
        this.ventas = ventas;
    }

    public void aumentarVentas(){this.ventas = this.ventas + 1;}

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", ventas=" + ventas +
                '}';
    }
}
