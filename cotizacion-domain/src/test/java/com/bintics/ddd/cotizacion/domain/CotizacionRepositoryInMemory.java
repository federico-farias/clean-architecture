package com.bintics.ddd.cotizacion.domain;

import com.bintics.ddd.cotizacion.domain.model.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;

import java.util.List;

public class CotizacionRepositoryInMemory implements CotizacionRepository {

    private final List<CotizacionDeServicio> dataSource;

    public CotizacionRepositoryInMemory(List<CotizacionDeServicio> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public CotizacionDeServicio findById(String cotizacionId) {
        for (CotizacionDeServicio cotizacion : this.dataSource) {
            if (cotizacion.getId() == cotizacionId) {
                return cotizacion;
            }
        }
        return null;
    }

    @Override
    public void save(CotizacionDeServicio cotizacion) {
        this.dataSource.add(cotizacion);
    }
}