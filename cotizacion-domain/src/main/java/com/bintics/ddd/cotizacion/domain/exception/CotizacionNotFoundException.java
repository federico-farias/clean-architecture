package com.bintics.ddd.cotizacion.domain.exception;

public class CotizacionNotFoundException extends RuntimeException {

    public CotizacionNotFoundException(String message) {
        super(message);
    }

}
