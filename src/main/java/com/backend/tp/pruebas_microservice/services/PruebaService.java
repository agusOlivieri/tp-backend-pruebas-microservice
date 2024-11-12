package com.backend.tp.pruebas_microservice.services;

import com.backend.tp.pruebas_microservice.entities.Interesado;
import com.backend.tp.pruebas_microservice.entities.Empleado;
import com.backend.tp.pruebas_microservice.entities.Prueba;
import com.backend.tp.pruebas_microservice.entities.Vehiculo;
import com.backend.tp.pruebas_microservice.repositories.PruebaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PruebaService {
    @Autowired
    private PruebaRepository pruebaRepository;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private InteresadoService interesadoService;

    @Autowired
    private EmpleadoService empleadoService;

    @Transactional
    public Prueba crearPrueba(Integer vehiculoId, Integer interesadoId, Integer empleadoId, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) throws Exception {
        System.out.println("Vehiculo ID: " + vehiculoId);
        System.out.println(interesadoId);
        System.out.println(empleadoId);
        System.out.println(fechaHoraFin);
        System.out.println(fechaHoraInicio);

        Interesado interesado = interesadoService.getInteresado(interesadoId);
        Vehiculo vehiculo = vehiculoService.getVehiculo(vehiculoId);
        Empleado empleado = empleadoService.getEmpleado(empleadoId);

        System.out.println(interesado);
        System.out.println(vehiculo);
        System.out.println(empleado);

        boolean esVehiculoEnPrueba = vehiculoService.isVehiculoEnPrueba(vehiculoId);

        System.out.println(esVehiculoEnPrueba);

        // validar si la licencia de conducir esta vencida
        if (interesado.getFechaVencimientoLicencia().isBefore(LocalDateTime.now())) {
            System.out.println("Se llego hasta 1");
            throw new Exception("La licencia del cliente está vencida.");
        }

        // validar si el cliente está restringido para probar vehículos
        if (interesado.getRestringido()) {
            System.out.println("Se llego hasta 2");
            throw new Exception("El cliente está restringido para probar vehículos.");
        }

        // validar si el vehiculo que se quiere usar ya está siendo usado en otra prueba
        if (vehiculoService.isVehiculoEnPrueba(vehiculoId)) {
            System.out.println("Se llego hasta 3");
            throw new Exception("El vehículo ya está siendo usado en otra prueba.");
        }

        // creamos la prueba
        System.out.println("Se llego hasta 4");
        Prueba prueba = new Prueba(vehiculo, interesado, empleado, fechaHoraInicio, fechaHoraFin, "", "en curso");

        return pruebaRepository.save(prueba);
    }

    public List<Prueba> getPruebasEnCurso() {
        return pruebaRepository.findByEstado("en curso");
    }
}
