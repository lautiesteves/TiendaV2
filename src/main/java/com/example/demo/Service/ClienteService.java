package com.example.demo.Service;

import com.example.demo.DTO.ClienteBaseDTO;
import com.example.demo.DTO.ClienteDTO;
import com.example.demo.DTO.EmailDTO;
import com.example.demo.DTO.EmpleadoBaseDTO;
import com.example.demo.Model.Cliente;
import com.example.demo.Model.Empleado;
import com.example.demo.Repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public void agregarNuevoCliente(ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Cliente> clienteOptional = clienteRepository.findClienteByEmail(clienteDTO.getEmail());
        if(clienteOptional.isPresent()) {
            throw new IllegalStateException("El email esta en uso");
        }
        clienteRepository.save(modelMapper.map(clienteDTO, Cliente.class));
    }

    public ClienteDTO findClienteById (Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Cliente> buscado = clienteRepository.findById(id);
        if(buscado.isEmpty()) {
            throw new IllegalStateException("El id no existe");
        }
        return modelMapper.map(buscado.get(), ClienteDTO.class);
    }

    public void deleteCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        clienteRepository.deleteById(id);
    }
    @Transactional
    public void updateCliente(Long id, EmailDTO emailDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        if(emailDTO.getEmail() != null && emailDTO.getEmail().length() > 0
            && !Objects.equals(clienteOptional.get().getEmail(), emailDTO.getEmail())) {
            clienteOptional.get().setEmail(emailDTO.getEmail());
        }
    }

    public void aumentarCompras(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        clienteOptional.get().aumentarCompras();
        clienteRepository.save(clienteOptional.get());
    }

    public void ajustarCredito(Long id, Float precio) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        if(clienteOptional.get().getCredito() < precio){
            throw new IllegalStateException("Fondos insuficientes");
        }
        clienteOptional.get().ajustarCredito(precio);
    }


    public ClienteBaseDTO mejorCliente() {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Cliente> buscado = clienteRepository.findMejorCliente();
        if(buscado.isEmpty()) {
            throw new IllegalStateException("El id empleado no existe");
        }
        return modelMapper.map(buscado.get(), ClienteBaseDTO.class);
    }
}

