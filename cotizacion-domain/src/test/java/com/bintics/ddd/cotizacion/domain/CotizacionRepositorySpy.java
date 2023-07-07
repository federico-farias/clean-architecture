package com.bintics.ddd.cotizacion.domain;

import org.junit.jupiter.api.Assertions;

public class CotizacionRepositorySpy implements CotizacionRepository {

    private final CotizacionRepository repository;
    private int numCallsSave = 0;

    public CotizacionRepositorySpy(CotizacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public CotizacionDeServicio findById(String cotizacionId) {
        return this.repository.findById(cotizacionId);
    }

    @Override
    public void save(CotizacionDeServicio cotizacion) {
        this.repository.save(cotizacion);
        this.numCallsSave++;
    }

    public void assertSave(int numCalls) {
        Assertions.assertEquals(numCalls, this.numCallsSave, "deberia ejecutarse el metodo save");
    }

}
