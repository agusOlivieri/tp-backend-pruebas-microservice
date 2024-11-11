package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Posicion;
import com.backend.tp.pruebas_microservice.repositories.PosicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicionService {
    @Autowired
    private PosicionRepository posicionRepository;

    public List<Posicion> getAll() {
        return posicionRepository.findAll();
    }

}
