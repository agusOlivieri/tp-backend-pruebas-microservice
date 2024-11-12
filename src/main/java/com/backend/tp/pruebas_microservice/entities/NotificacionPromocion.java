package com.backend.tp.pruebas_microservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "notificacion_promocion")
public class NotificacionPromocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "texto")
    private String textoNotificaion;

    public NotificacionPromocion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextoNotificaion() {
        return textoNotificaion;
    }

    public void setTextoNotificaion(String textoNotificaion) {
        this.textoNotificaion = textoNotificaion;
    }
}
