package com.bintics.micro.profile.cotizacion.application.infrastructure;

import com.bintics.ddd.cotizacion.domain.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.ServicioRepository;
import com.bintics.ddd.cotizacion.application.AgregarServicioUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class UseCasesConfig {

    @Produces
    @Default
    public AgregarServicioUseCase agregarServicioUseCase(CotizacionRepository cotizacionRepository, ServicioRepository servicioRepository) {
        return new AgregarServicioUseCase(cotizacionRepository, servicioRepository);
    }

}
