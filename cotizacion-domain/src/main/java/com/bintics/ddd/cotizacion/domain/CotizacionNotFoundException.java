package com.bintics.ddd.cotizacion.domain;

public class CotizacionNotFoundException extends RuntimeException {

    public CotizacionNotFoundException(String message) {
        super(message);
    }

}
