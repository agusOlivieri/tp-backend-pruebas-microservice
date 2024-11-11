package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Modelo;
import com.backend.tp.pruebas_microservice.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> getAll() {
        return modeloRepository.findAll();
    }

}
