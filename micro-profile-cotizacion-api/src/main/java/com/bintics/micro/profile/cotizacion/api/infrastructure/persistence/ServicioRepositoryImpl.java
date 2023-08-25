package com.bintics.micro.profile.cotizacion.api.infrastructure.persistence;

import com.bintics.ddd.cotizacion.domain.model.Servicio;
import com.bintics.ddd.cotizacion.domain.repository.ServicioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named
public class ServicioRepositoryImpl implements ServicioRepository {

    @Override
    public Servicio findById(String servicioId) {
        return new Servicio("id-prueba", 120.0);
    }

}
