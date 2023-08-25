package com.bintics.ddd.cotizacion.domain.model;

import lombok.Getter;

public class CotizacionName {

    @Getter
    private final String value;

    public CotizacionName(String name) {
        if (name == null) {
            throw new RuntimeException("El nombre es requerido!");
        }
        this.value = name;
    }


}
