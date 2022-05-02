package com.example.demo.Controller;

import com.example.demo.DTO.PrendaDTO;
import com.example.demo.DTO.VentaDTO;
import com.example.demo.Model.Cliente;
import com.example.demo.Model.Empleado;
import com.example.demo.Model.Prenda;
import com.example.demo.Service.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/prenda")
public class PrendaController {

    private final PrendaService prendaService;

    @Autowired
    public PrendaController(PrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @GetMapping(path = "/all")
    public List<Prenda> getPrendas() {
        return prendaService.getPrendas();
    }

    @GetMapping(path = "/{id}")
    public PrendaDTO getPrendaById(@PathVariable Long id) {
        return prendaService.findPrendaById(id);
    }

    @PostMapping
    public void registrarNuevaPrenda(@RequestBody Prenda prenda){
        prendaService.agregarNuevaPrenda(prenda);
    }

    @DeleteMapping(path = "{id}")
    public void borrarPrenda(@PathVariable("id") Long id){
        prendaService.deletePrenda(id);
    }

    @PutMapping(path = "/venta")
    public void venderPrenda(@RequestBody VentaDTO ventaDTO){
        prendaService.venderPrenda(ventaDTO);
    }


}
