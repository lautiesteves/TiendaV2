package com.example.demo.Config;

import com.example.demo.Model.Cliente;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClienteConfig {

    @Bean
    CommandLineRunner commandLineRunnerCliente(ClienteRepository repository) {
        return args -> {
            Cliente lautaro = new Cliente(
                    "Lautaro",
                    "Esteves",
                    "lautaesteves@gmail.com",
                    2500F,
                    2
            );

            Cliente alex = new Cliente(
                    "Alex",
                    "Alvarez",
                    "alex.alvarez@gmail.com",
                    4500F,
                    4
            );

            repository.saveAll(List.of(lautaro, alex));
        };
    }
}
