package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.CotizacionRepository;

public class CrearCotizacionUseCase {

    private final CotizacionRepository repository;

    public CrearCotizacionUseCase(CotizacionRepository repository) {
        this.repository = repository;
    }

    public String crear(CrearCotizacionRequest request) {
        CotizacionDeServicio cotizacionDeServicio = new CotizacionDeServicio();
        this.repository.save(cotizacionDeServicio);
        return cotizacionDeServicio.getId();
    }

}
