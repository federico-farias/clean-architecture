package com.bintics.ddd.cotizacion.infrastructure;

import com.bintics.ddd.cotizacion.domain.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.ServicioRepository;
import com.bintics.ddd.cotizacion.application.AgregarServicioUseCase;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AgregarServicioUseCase agregarServicioUseCase(CotizacionRepository cotizacionRepository, ServicioRepository servicioRepository) {
        return new AgregarServicioUseCase(cotizacionRepository, servicioRepository);
    }

    @Bean
    public MeterRegistry getMeterRegistry() {
        CompositeMeterRegistry meterRegistry = new CompositeMeterRegistry();
        return meterRegistry;
    }

}
