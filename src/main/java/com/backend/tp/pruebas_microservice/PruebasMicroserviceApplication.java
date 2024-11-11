package com.backend.tp.pruebas_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebasMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebasMicroserviceApplication.class, args);
		System.out.println("Aplicación corriendo en: http://localhost:8082/");
	}

}
