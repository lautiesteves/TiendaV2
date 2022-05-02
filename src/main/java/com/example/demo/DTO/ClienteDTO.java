package com.example.demo.DTO;

import com.example.demo.Model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Float credito;
    private Integer compras;

    public ClienteDTO() {}

    public ClienteDTO(Cliente cliente) {
        this.setId(cliente.getId());
        this.setNombre(cliente.getNombre());
        this.setApellido(cliente.getApellido());
        this.setEmail(cliente.getEmail());
        this.setCredito(cliente.getCredito());
        this.setCompras(cliente.getCompras());
    }
}
