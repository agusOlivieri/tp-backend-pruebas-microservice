package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Empleado;
import com.backend.tp.pruebas_microservice.entities.Notificacion;
import com.backend.tp.pruebas_microservice.repositories.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private EmpleadoService empleadoService;

    public List<Notificacion> getAll() {
        return notificacionRepository.findAll();
    }

    public List<Notificacion> getInicidentesPorEmpleado(Integer legajo) {
        Empleado empleado = empleadoService.getByLegajo(legajo);

        return notificacionRepository.findByEmpleado(empleado);
    }

}
