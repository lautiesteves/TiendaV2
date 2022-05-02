package com.example.demo.Repository;

import com.example.demo.Model.Cliente;
import com.example.demo.Model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.email = ?1")
    Optional<Cliente> findClienteByEmail(String email);

    @Query("SELECT c FROM Cliente c WHERE c.compras = (SELECT MAX(compras) FROM Cliente)")
    Optional<Cliente> findMejorCliente();
}
