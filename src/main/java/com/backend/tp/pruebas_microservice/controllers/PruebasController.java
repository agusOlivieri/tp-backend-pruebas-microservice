package com.backend.tp.pruebas_microservice.controllers;

import com.backend.tp.pruebas_microservice.dtos.PruebaDTO;
import com.backend.tp.pruebas_microservice.entities.Prueba;
import com.backend.tp.pruebas_microservice.services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PruebasController {
    @Autowired
    private PruebaService pruebaService;

    @GetMapping("/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Endpoint accesible");
    }

    @PostMapping("/pruebas")
    public ResponseEntity<Object> crearPrueba(@RequestBody PruebaDTO request) {
        try {
            System.out.println("Request: " + request.getVehiculoId());

            Prueba prueba = pruebaService.crearPrueba(request.getVehiculoId(), request.getInteresadoId(), request.getEmpleadoId(), request.getFechaHoraInicio(), request.getFechaHoraFin());
            return ResponseEntity.status(HttpStatus.CREATED).body(prueba);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No se pudo crear la prueba");
            errorResponse.put("detalle", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/pruebas")
    public ResponseEntity<Object> mostrarPruebasEnCurso() {
        List<Prueba> pruebasEnCurso = pruebaService.getPruebasEnCurso();

        if (pruebasEnCurso.isEmpty()) {
            String errorResponse = "Error al buscar las pruebas o no hay pruebas en curso";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pruebasEnCurso);
    }

    @GetMapping("/finalizar")
    public ResponseEntity<Object> finalizarPrueba(@RequestParam Integer pruebaId, @RequestParam String comentarios) {
        try {
            Prueba pruebaFinalizada = pruebaService.finalizarPrueba(pruebaId, comentarios);
            return ResponseEntity.ok(pruebaFinalizada);
        } catch(Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No se pudo finalizar la prueba");
            errorResponse.put("detalle", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/notificar-promociones")
    public ResponseEntity<Object> notificarPromociones() {
        -.....
    }
}
