package com.example.demo.DTO;

import com.example.demo.Model.Empleado;
import lombok.Data;

@Data
public class CantVentasDTO {

    private Integer Ventas;

    public CantVentasDTO() {}

    public CantVentasDTO(Empleado empleado){
        this.setVentas(empleado.getVentas());
    }
}
