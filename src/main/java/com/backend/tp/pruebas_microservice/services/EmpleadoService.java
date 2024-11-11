package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Empleado;
import com.backend.tp.pruebas_microservice.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAll(){
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleado(Integer empleadoId) { return empleadoRepository.findByLegajo(empleadoId); }
}
