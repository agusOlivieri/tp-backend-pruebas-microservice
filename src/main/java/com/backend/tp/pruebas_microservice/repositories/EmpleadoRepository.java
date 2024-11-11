package com.backend.tp.pruebas_microservice.repositories;

import com.backend.tp.pruebas_microservice.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Empleado findByLegajo(Integer empleadoId);
}