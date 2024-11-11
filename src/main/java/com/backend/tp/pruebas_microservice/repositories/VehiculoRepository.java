package com.backend.tp.pruebas_microservice.repositories;

import com.backend.tp.pruebas_microservice.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
