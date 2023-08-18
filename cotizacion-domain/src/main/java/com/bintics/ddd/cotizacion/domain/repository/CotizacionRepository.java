package com.bintics.ddd.cotizacion.domain.repository;

import com.bintics.ddd.cotizacion.domain.model.CotizacionDeServicio;

public interface CotizacionRepository {

    CotizacionDeServicio findById(String cotizacionId);

    void save(CotizacionDeServicio cotizacion);

}
