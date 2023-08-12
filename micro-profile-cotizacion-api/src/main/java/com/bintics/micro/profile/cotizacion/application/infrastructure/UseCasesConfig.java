package com.bintics.micro.profile.cotizacion.application.infrastructure;

import com.bintics.ddd.cotizacion.application.AgregarServicioUseCase;
import com.bintics.ddd.cotizacion.domain.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.ServicioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class UseCasesConfig {

    @Produces
    public AgregarServicioUseCase agregarServicioUseCase(CotizacionRepository cotizacionRepository, ServicioRepository servicioRepository) {
        return new AgregarServicioUseCase(cotizacionRepository, servicioRepository);
    }

}
