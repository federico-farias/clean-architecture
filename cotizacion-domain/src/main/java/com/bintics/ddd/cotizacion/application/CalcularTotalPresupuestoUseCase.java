package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;

public class CalcularTotalPresupuestoUseCase {

    private final CotizacionRepository repository;


    public CalcularTotalPresupuestoUseCase(CotizacionRepository repository) {
        this.repository = repository;
    }


}
