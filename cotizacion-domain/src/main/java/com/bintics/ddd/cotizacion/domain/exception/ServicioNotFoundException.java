package com.bintics.ddd.cotizacion.domain.exception;

public class ServicioNotFoundException extends RuntimeException {

    public ServicioNotFoundException(String message) {
        super(message);
    }
}
