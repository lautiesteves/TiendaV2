package com.example.demo.Service;

import com.example.demo.DTO.CantVentasDTO;
import com.example.demo.DTO.EmpleadoBaseDTO;
import com.example.demo.DTO.EmpleadoDTO;
import com.example.demo.Model.Empleado;
import com.example.demo.Repository.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getEmpleados(){
        return empleadoRepository.findAll();
    }

    public void agregarNuevoEmpleado(EmpleadoDTO empleadoDTO) {
            ModelMapper modelMapper = new ModelMapper();
            Optional<Empleado> empleadoOptional = empleadoRepository.findEmpleadoByEmail(empleadoDTO.getEmail());
            if(empleadoOptional.isPresent()) {
                throw new IllegalStateException("El email esta en uso");
            }
            empleadoRepository.save(modelMapper.map(empleadoDTO, Empleado.class));
    }

    public EmpleadoDTO findEmpleadoById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isEmpty()) {
            throw new IllegalStateException("El empleado no existe");
        }
        return modelMapper.map(empleadoOptional.get(), EmpleadoDTO.class);
    }

    public void deleteEmpleado(Long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        empleadoRepository.deleteById(id);
    }

    @Transactional
    public void aumentarVentas(Long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        empleadoOptional.get().aumentarVentas();
        empleadoRepository.save(empleadoOptional.get());
    }

    public CantVentasDTO getCantVentas(Long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isEmpty()) {
            throw new IllegalStateException("El id " + id + " no esta registrado");
        }
        CantVentasDTO cantVentasDTO = new CantVentasDTO(empleadoOptional.get());
        return cantVentasDTO;
    }

    public EmpleadoBaseDTO getMejorEmpleado() {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Empleado> buscado = empleadoRepository.findMejorEmpleado();
        if(buscado.isEmpty()) {
            throw new IllegalStateException("El id empleado no existe");
        }
        return modelMapper.map(buscado.get(), EmpleadoBaseDTO.class);
    }
}
