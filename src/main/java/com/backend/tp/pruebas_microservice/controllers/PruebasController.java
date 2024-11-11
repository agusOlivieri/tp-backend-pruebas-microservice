package com.backend.tp.pruebas_microservice.controllers;

import com.backend.tp.pruebas_microservice.dtos.PruebaDTO;
import com.backend.tp.pruebas_microservice.entities.Prueba;
import com.backend.tp.pruebas_microservice.services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebasController {
    @Autowired
    private PruebaService pruebaService;

    @GetMapping("/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Endpoint accesible");
    }

    @PostMapping("/pruebas")
    public ResponseEntity<Prueba> crearPrueba(@RequestBody PruebaDTO request) {
        try {
            Prueba prueba = pruebaService.crearPrueba(request.getInteresadoId(), request.getInteresadoId(), request.getEmpleadoId(), request.getFechaHoraInicio(), request.getFechaHoraFin());
            return ResponseEntity.status(HttpStatus.CREATED).body(prueba);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
