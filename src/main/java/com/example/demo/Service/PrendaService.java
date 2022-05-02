package com.example.demo.Service;

import com.example.demo.DTO.PrendaDTO;
import com.example.demo.DTO.VentaDTO;
import com.example.demo.Model.Prenda;
import com.example.demo.Repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrendaService {

    private final PrendaRepository prendaRepository;
    private final ClienteService clienteService;
    private final EmpleadoService empleadoService;


    @Autowired
    public PrendaService(PrendaRepository prendaRepository, ClienteService clienteService, EmpleadoService empleadoService) {
        this.prendaRepository = prendaRepository;
        this.clienteService = clienteService;
        this.empleadoService = empleadoService;
    }

    public List<Prenda> getPrendas(){
        return prendaRepository.findAll();
    }


    public void agregarNuevaPrenda(Prenda prenda) {
        Optional<Prenda> prendaOptional = prendaRepository.findPrendaByDetalle(prenda.getDetalle());
        if(prendaOptional.isPresent()) {
            throw new IllegalStateException("Esa prenda ya existe");
        }
        prendaRepository.save(prenda);
    }

    public PrendaDTO findPrendaById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Prenda> prendaOptional = prendaRepository.findById(id);
        if(prendaOptional.isEmpty()) {
            throw new IllegalStateException("No trabajamos esa prenda");
        }
        return modelMapper.map(prendaOptional.get(), PrendaDTO.class);
    }

    public void deletePrenda(Long id) {
        Optional<Prenda> prendaOptional = prendaRepository.findById(id);
        if(prendaOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        prendaRepository.deleteById(id);
    }

    public void venderPrenda(VentaDTO ventaDTO) {
        Optional<Prenda> prendaOptional = prendaRepository.findById(ventaDTO.getPrendaId());
        if(prendaOptional.isEmpty()) {
            throw new IllegalStateException("El id de la prenda no esta registrado");
        }
        if(prendaOptional.get().getStock() <= 0) {
            throw new IllegalStateException("No poseemos stock");
        }
        clienteService.ajustarCredito(ventaDTO.getClienteId(), prendaOptional.get().getPrecio());
        empleadoService.aumentarVentas(ventaDTO.getEmpleadoId());
        clienteService.aumentarCompras(ventaDTO.getClienteId());
        prendaOptional.get().reducirStock();
        prendaRepository.save(prendaOptional.get());
    }
}
