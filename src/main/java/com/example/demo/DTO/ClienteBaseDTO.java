package com.example.demo.DTO;

import com.example.demo.Model.Cliente;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteBaseDTO implements Serializable {

    private String nombre;
    private String apellido;
    private Integer compras;

    public ClienteBaseDTO() {}

    public ClienteBaseDTO(Cliente cliente) {
        this.setNombre(cliente.getNombre());
        this.setApellido(cliente.getApellido());
        this.setCompras(cliente.getCompras());
    }
}
