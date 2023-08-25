package com.bintics.micro.profile.cotizacion.api.infrastructure;

import com.bintics.ddd.cotizacion.application.CrearCotizacionUseCase;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.repository.ServicioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class Config {

    @Produces
    public CrearCotizacionUseCase crearCotizacionUseCase(CotizacionRepository cotizacionRepository, ServicioRepository servicioRepository) {
        return new CrearCotizacionUseCase(cotizacionRepository, servicioRepository);
    }

}
