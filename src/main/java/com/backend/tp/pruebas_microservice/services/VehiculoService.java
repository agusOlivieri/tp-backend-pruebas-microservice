package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Vehiculo;
import com.backend.tp.pruebas_microservice.repositories.PruebaRepository;
import com.backend.tp.pruebas_microservice.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private PruebaRepository pruebaRepository;

    public List<Vehiculo> getAll() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo getVehiculo(Integer vehiculoId) { return vehiculoRepository.findById(vehiculoId).orElseThrow(() -> new RuntimeException("Vehículo no encontrado")); }

    public boolean isVehiculoEnPrueba(Integer vehiculoId) {
        return pruebaRepository.existsByVehiculoIdAndEstado(vehiculoId, "en curso");
    }
}
