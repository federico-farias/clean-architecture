package com.bintics.micro.profile.cotizacion.api.infrastructure.persistence;

import com.bintics.ddd.cotizacion.domain.model.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named
public class CotizacionRepositoryImpl implements CotizacionRepository {

    @Override
    public CotizacionDeServicio findById(String cotizacionId) {
        return new CotizacionDeServicio();
    }

    @Override
    public void save(CotizacionDeServicio cotizacion) {

    }
}
