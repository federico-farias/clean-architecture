package com.bintics.ddd.cotizacion.domain;

public interface CotizacionRepository {

    CotizacionDeServicio findById(String cotizacionId);

    void save(CotizacionDeServicio cotizacion);

}
