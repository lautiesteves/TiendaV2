package com.example.demo.Repository;

import com.example.demo.Model.Empleado;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Bean
    public default JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Query("SELECT e FROM Empleado e WHERE e.email = ?1")
    Optional<Empleado> findEmpleadoByEmail(String email);

    @Query("SELECT e FROM Empleado e WHERE e.ventas = (SELECT MAX(ventas) FROM Empleado)")
    Optional<Empleado> findMejorEmpleado();

}
