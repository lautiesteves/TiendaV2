package com.example.demo.DTO;

import com.example.demo.Model.Cliente;
import com.example.demo.Model.Empleado;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmailDTO implements Serializable {

    private String email;

    public EmailDTO(){}

    public EmailDTO(Empleado empleado){
        this.setEmail(empleado.getEmail());
    }

    public EmailDTO(Cliente cliente){
        this.setEmail(cliente.getEmail());
    }
}
