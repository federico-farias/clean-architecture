package com.bintics.ddd.cotizacion.domain;

public class ServicioNotFoundException extends RuntimeException {

    public ServicioNotFoundException(String message) {
        super(message);
    }
}
