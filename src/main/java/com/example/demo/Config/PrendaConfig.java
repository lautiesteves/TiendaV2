package com.example.demo.Config;

import com.example.demo.Model.Prenda;
import com.example.demo.Repository.PrendaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PrendaConfig {

    @Bean
    CommandLineRunner commandLineRunnerPrenda(PrendaRepository repository) {
        return args -> {
            Prenda remera = new Prenda(
                   "Remera Blanca",
                    350F,
                    19
            );

            Prenda bermuda = new Prenda(
                    "Bermuda Roja",
                    250F,
                    15
            );

            Prenda medias = new Prenda(
                    "Medias de la Suerte",
                    100F,
                    25
            );

            Prenda buzo = new Prenda(
                    "Buzo Negro",
                    500F,
                    8
            );

            repository.saveAll(List.of(remera, bermuda, medias, buzo));
        };
    }
}
