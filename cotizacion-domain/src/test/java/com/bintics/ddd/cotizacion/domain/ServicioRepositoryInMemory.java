package com.bintics.ddd.cotizacion.domain;

import java.util.List;

public class ServicioRepositoryInMemory implements ServicioRepository {

    private final List<Servicio> dataSource;

    public ServicioRepositoryInMemory(List<Servicio> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Servicio findById(String servicioId) {
        for (Servicio servicio : this.dataSource) {
            if (servicio.getId() == servicioId) {
                return servicio;
            }
        }
        return null;
    }
}
