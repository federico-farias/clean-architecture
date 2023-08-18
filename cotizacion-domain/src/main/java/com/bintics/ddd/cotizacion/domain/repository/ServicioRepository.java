package com.bintics.ddd.cotizacion.domain.repository;

import com.bintics.ddd.cotizacion.domain.model.Servicio;

public interface ServicioRepository {
    Servicio findById(String servicioId);
}
