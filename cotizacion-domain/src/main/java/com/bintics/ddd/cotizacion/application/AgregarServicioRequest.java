package com.bintics.ddd.cotizacion.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AgregarServicioRequest {

    private String cotizacionId;
    private String servicioId;

}
