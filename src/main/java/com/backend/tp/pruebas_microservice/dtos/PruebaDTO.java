package com.backend.tp.pruebas_microservice.dtos;

import java.time.LocalDateTime;

public class PruebaDTO {
    private Integer interesadoId;

    private Integer vehiculoId;

    private LocalDateTime fechaHoraInicio;

    private LocalDateTime fechaHoraFin;

    private Integer empleadoId;

    public Integer getInteresadoId() {
        return interesadoId;
    }

    public void setInteresadoId(Integer interesadoId) {
        this.interesadoId = interesadoId;
    }

    public Integer getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
}
