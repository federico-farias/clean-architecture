package com.bintics.ddd.cotizacion.domain.service;

import com.bintics.ddd.cotizacion.domain.exception.CotizacionNotFoundException;
import com.bintics.ddd.cotizacion.domain.model.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;

public class ContizacionFinder {

    private final CotizacionRepository cotizacionRepository;

    public ContizacionFinder(CotizacionRepository cotizacionRepository) {
        this.cotizacionRepository = cotizacionRepository;
    }

    public CotizacionDeServicio find(String id) {
        CotizacionDeServicio cotizacion = this.cotizacionRepository.findById(id);
        if (cotizacion == null) {
            throw new CotizacionNotFoundException("Cotizacion no encontrada [" + id + "]");
        }
        return cotizacion;
    }

}
