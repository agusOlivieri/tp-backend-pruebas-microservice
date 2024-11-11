package com.backend.tp.pruebas_microservice.repositories;

import com.backend.tp.pruebas_microservice.entities.Interesado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresadoRepository extends JpaRepository<Interesado, Integer> {
}
