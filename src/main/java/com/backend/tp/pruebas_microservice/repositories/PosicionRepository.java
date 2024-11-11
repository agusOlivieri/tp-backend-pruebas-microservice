package com.backend.tp.pruebas_microservice.repositories;

import com.backend.tp.pruebas_microservice.entities.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Integer> {
}
