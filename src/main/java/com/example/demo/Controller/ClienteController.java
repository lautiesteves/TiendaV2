package com.example.demo.Controller;

import com.example.demo.DTO.ClienteBaseDTO;
import com.example.demo.DTO.ClienteDTO;
import com.example.demo.DTO.EmailDTO;
import com.example.demo.Model.Cliente;
import com.example.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/all")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping(path = "/{id}")
    public ClienteDTO getClientesById(@PathVariable("id") Long id) {
        return clienteService.findClienteById(id);
    }

    @PostMapping
    public void registrarNuevoCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.agregarNuevoCliente(clienteDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void borrarCliente(@PathVariable("id") Long id){
        clienteService.deleteCliente(id);
    }

    @PutMapping(path = "/{id}")
    public void updateCliente (@PathVariable("id") Long id, @RequestBody EmailDTO emailDTO) {
        clienteService.updateCliente(id, emailDTO);
    }

    @GetMapping(path = "/mejorcliente")
    public ClienteBaseDTO mejorCliente () {
        return clienteService.mejorCliente();
    }
}
