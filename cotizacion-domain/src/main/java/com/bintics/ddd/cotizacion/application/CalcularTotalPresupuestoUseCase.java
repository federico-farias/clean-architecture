package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.CotizacionRepository;

public class CalcularTotalPresupuestoUseCase {

    private final CotizacionRepository repository;


    public CalcularTotalPresupuestoUseCase(CotizacionRepository repository) {
        this.repository = repository;
    }


}
