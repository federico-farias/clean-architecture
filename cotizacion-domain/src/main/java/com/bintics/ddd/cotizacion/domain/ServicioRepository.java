package com.bintics.ddd.cotizacion.domain;

public interface ServicioRepository {
    Servicio findById(String servicioId);
}
