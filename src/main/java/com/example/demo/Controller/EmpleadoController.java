package com.example.demo.Controller;

import com.example.demo.DTO.CantVentasDTO;
import com.example.demo.DTO.EmpleadoBaseDTO;
import com.example.demo.DTO.EmpleadoDTO;
import com.example.demo.Model.Empleado;
import com.example.demo.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping(path = "/all")
    public List<Empleado> getEmpleados() {
        return empleadoService.getEmpleados();
    }

    @GetMapping(path = "/{id}")
    public EmpleadoDTO getEmpleadoById(@PathVariable Long id) {
        return empleadoService.findEmpleadoById(id);
    }

    @PostMapping
    public void registrarNuevoEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        empleadoService.agregarNuevoEmpleado(empleadoDTO);
    }

    @DeleteMapping(path = "{id}")
    public void borrarEmpleado(@PathVariable("id") Long id){
        empleadoService.deleteEmpleado(id);
    }

    @GetMapping(path = "/cantventas/{id}")
    public CantVentasDTO cantVentasEmpleado (@PathVariable Long id) {
        return empleadoService.getCantVentas(id);
    }

    @GetMapping(path = "/mejorempleado")
    public EmpleadoBaseDTO mejorEmpleado () {
        return empleadoService.getMejorEmpleado();
    }
}
