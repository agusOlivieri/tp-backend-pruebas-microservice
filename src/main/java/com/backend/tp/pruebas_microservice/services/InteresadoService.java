package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Interesado;
import com.backend.tp.pruebas_microservice.repositories.InteresadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresadoService {
    @Autowired
    private InteresadoRepository interesadoRepository;

    public List<Interesado> getAll() {
        return interesadoRepository.findAll();
    }

    public Interesado getInteresado(Integer interesadoId) {
        return interesadoRepository.findById(interesadoId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
