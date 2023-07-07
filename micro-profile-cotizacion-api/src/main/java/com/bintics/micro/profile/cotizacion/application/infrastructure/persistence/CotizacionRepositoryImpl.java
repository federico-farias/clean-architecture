package com.bintics.micro.profile.cotizacion.application.infrastructure.persistence;

import com.bintics.ddd.cotizacion.domain.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.CotizacionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.inject.Named;


@ApplicationScoped
@Named("cotizacionRepositoryImpl")
public class CotizacionRepositoryImpl implements CotizacionRepository {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    @Override
    public CotizacionDeServicio findById(String cotizacionId) {
        return null;
    }

    @Override
    public void save(CotizacionDeServicio cotizacion) {
        System.out.println(cotizacion);
    }

}
