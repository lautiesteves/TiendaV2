package com.example.demo.DTO;

import com.example.demo.Model.Empleado;
import lombok.Data;

@Data
public class EmpleadoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Integer ventas;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Empleado empleado) {
        this.setNombre(empleado.getNombre());
        this.setApellido(empleado.getApellido());
        this.setEmail(empleado.getEmail());
        this.setVentas(empleado.getVentas());
    }
}
