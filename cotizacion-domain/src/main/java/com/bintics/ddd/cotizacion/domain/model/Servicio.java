package com.bintics.ddd.cotizacion.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Servicio {

    private String id;
    private Double costo;

    public Servicio(String id, Double costo) {
        this.id = id;
        this.costo = costo;
    }

    public Servicio(Double costo) {
        this.costo = costo;
    }

}
