package com.example.demo.DTO;

import com.example.demo.Model.Empleado;
import lombok.Data;

@Data
public class EmpleadoBaseDTO {

    private String nombre;
    private String apellido;
    private Integer ventas;

    public EmpleadoBaseDTO(){}

    public EmpleadoBaseDTO(Empleado empleado){
        this.setNombre(empleado.getNombre());
        this.setApellido(empleado.getApellido());
        this.setVentas(empleado.getVentas());
    }
}

