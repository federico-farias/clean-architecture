package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.*;

public class CrearCotizacionUseCase {

    private final CotizacionRepository repository;

    private final ServicioRepository servicioRepository;

    public CrearCotizacionUseCase(CotizacionRepository repository, ServicioRepository servicioRepository) {
        this.repository = repository;
        this.servicioRepository = servicioRepository;
    }

    public String crear(CrearCotizacionRequest request) {
        Servicio servicio = this.servicioRepository.findById(request.getServicioId());
        if (servicio == null) {
            throw new ServicioNotFoundException("Servicio no encontrado [" + request.getServicioId() + "]");
        }
        CotizacionDeServicio cotizacionDeServicio = CotizacionDeServicio.create(request.getName(), servicio);
        this.repository.save(cotizacionDeServicio);
        return cotizacionDeServicio.getId();
    }

}
