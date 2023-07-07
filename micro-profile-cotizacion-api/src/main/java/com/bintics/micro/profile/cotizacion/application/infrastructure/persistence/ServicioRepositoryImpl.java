package com.bintics.micro.profile.cotizacion.application.infrastructure.persistence;

import com.bintics.ddd.cotizacion.domain.Servicio;
import com.bintics.ddd.cotizacion.domain.ServicioRepository;
import jakarta.enterprise.context.ApplicationScoped;

import javax.inject.Named;

@ApplicationScoped
@Named("servicioRepositoryImpl")
public class ServicioRepositoryImpl implements ServicioRepository {

    @Override
    public Servicio findById(String servicioId) {
        return null;
    }

}
