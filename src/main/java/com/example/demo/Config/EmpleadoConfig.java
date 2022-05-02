package com.example.demo.Config;

import com.example.demo.Model.Empleado;
import com.example.demo.Repository.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmpleadoConfig {

    @Bean
    CommandLineRunner commandLineRunnerEmpleado(EmpleadoRepository repository) {
        return args -> {
            Empleado joaquin = new Empleado(
                    "Joaquin",
                    "Ferri",
                    "jferri@tienda.com",
                    8
            );

            Empleado viviana = new Empleado(
                    "Viviana",
                    "Pesek",
                    "vpesek@tienda.com",
                    12
            );

            Empleado valentino = new Empleado(
                    "Valentino",
                    "Pesek",
                    "valenpesek@tienda.com",
                    12
            );

            Empleado ricardo = new Empleado(
                    "Ricardo",
                    "Esteves",
                    "resteves@tienda.com",
                    3
            );

            repository.saveAll(List.of(joaquin, viviana, valentino, ricardo));
        };
    }
}
