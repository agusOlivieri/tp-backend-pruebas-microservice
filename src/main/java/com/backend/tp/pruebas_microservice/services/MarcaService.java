package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Marca;
import com.backend.tp.pruebas_microservice.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }
}