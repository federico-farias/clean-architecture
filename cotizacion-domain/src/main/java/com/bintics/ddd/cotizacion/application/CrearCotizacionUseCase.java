package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.exception.ServicioNotFoundException;
import com.bintics.ddd.cotizacion.domain.model.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.model.Servicio;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.repository.ServicioRepository;
import com.bintics.ddd.cotizacion.domain.service.ServiceFinder;

public class CrearCotizacionUseCase {

    private final CotizacionRepository repository;

    private final ServiceFinder serviceFinder;

    public CrearCotizacionUseCase(CotizacionRepository repository, ServicioRepository servicioRepository) {
        this.repository = repository;
        this.serviceFinder = new ServiceFinder(servicioRepository);
    }

    public String crear(CrearCotizacionRequest request) {
        Servicio servicio = this.serviceFinder.find(request.getServicioId());
        CotizacionDeServicio cotizacionDeServicio = CotizacionDeServicio.create(request.getName(), servicio);
        this.repository.save(cotizacionDeServicio);
        return cotizacionDeServicio.getId();
    }

}
