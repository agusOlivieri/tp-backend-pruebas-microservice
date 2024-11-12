package com.backend.tp.pruebas_microservice.controllers;

import com.backend.tp.pruebas_microservice.entities.Notificacion;
import com.backend.tp.pruebas_microservice.entities.Prueba;
import com.backend.tp.pruebas_microservice.services.NotificacionService;
import com.backend.tp.pruebas_microservice.services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reportes")
public class ReportesController {
    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private PruebaService pruebaService;

    @GetMapping("/incidentes")
    public ResponseEntity<Object> generarReporteIncidentes() {
        List<Notificacion> incidentes = notificacionService.getAll();

        if (incidentes.isEmpty()) {
            String response = "No se han registrado incidentes.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.status(HttpStatus.OK).body(incidentes);
    }

    @GetMapping("/incidentes/empleado")
    public ResponseEntity<Object> generarReporteIncidentesPorEmpleado(@RequestParam Integer empleadoId) {
        List<Notificacion> incidentesPorEmpleado = notificacionService.getInicidentesPorEmpleado(empleadoId);

        if (incidentesPorEmpleado.isEmpty()) {
            String response = "No se han registrado incidentes para ese empleado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.status(HttpStatus.OK).body(incidentesPorEmpleado);
    }

    @GetMapping("/pruebas/vehiculo")
    public ResponseEntity<Object> generarReportePruebasPorVehiculo(@RequestParam Integer vehiculoId) {
        List<Prueba> pruebasPorVehiculo = pruebaService.getPruebasPorVehiculo(vehiculoId);

        if (pruebasPorVehiculo.isEmpty()) {
            String response = "No se han registrado pruebas para ese vehiculo.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pruebasPorVehiculo);
    }

}
