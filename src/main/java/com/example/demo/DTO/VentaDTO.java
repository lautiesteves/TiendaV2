package com.example.demo.DTO;

import com.example.demo.Model.Cliente;
import com.example.demo.Model.Empleado;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonFormat
public class VentaDTO implements Serializable{

    private Long prendaId;
    private Long clienteId;
    private Long empleadoId;

    public VentaDTO(){}

    public VentaDTO(Long prendaId, Long clienteId, Long empleadoId) {
        this.setPrendaId(prendaId);
        this.setClienteId(clienteId);
        this.setEmpleadoId(empleadoId);
    }



}
