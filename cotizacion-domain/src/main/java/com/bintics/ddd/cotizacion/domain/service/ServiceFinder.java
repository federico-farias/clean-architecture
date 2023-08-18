package com.bintics.ddd.cotizacion.domain.service;

import com.bintics.ddd.cotizacion.domain.exception.ServicioNotFoundException;
import com.bintics.ddd.cotizacion.domain.model.Servicio;
import com.bintics.ddd.cotizacion.domain.repository.ServicioRepository;

public class ServiceFinder {

    private final ServicioRepository servicioRepository;

    public ServiceFinder(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public Servicio find(String id) {
        Servicio servicio = this.servicioRepository.findById(id);
        if (servicio == null) {
            throw new ServicioNotFoundException("Servicio no encontrado [" + id+ "]");
        }
        return servicio;
    }

}
