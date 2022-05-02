package com.example.demo.Repository;

import com.example.demo.Model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
    @Query("SELECT p FROM Prenda p WHERE p.detalle = ?1")
    Optional<Prenda> findPrendaByDetalle(String detalle);
}
