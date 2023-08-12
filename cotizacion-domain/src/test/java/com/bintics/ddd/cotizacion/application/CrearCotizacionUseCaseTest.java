package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.CotizacionRepositoryInMemory;
import com.bintics.ddd.cotizacion.domain.ServicioRepositoryInMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class CrearCotizacionUseCaseTest {

    @Test
    public void deberiaCrearUnaCotizacion() {
        String cotizacionIdExpected = "";
        ServicioRepositoryInMemory servicioRepository = new ServicioRepositoryInMemory(null);
        CotizacionRepository repository = new CotizacionRepositoryInMemory(new LinkedList<>());
        CrearCotizacionUseCase useCase = new CrearCotizacionUseCase(repository, servicioRepository);

        String cotizacionId = useCase.crear(new CrearCotizacionRequest("cotizacion de prueba",  ""));

        Assertions.assertNotNull(cotizacionId);
        Assertions.assertNotSame(cotizacionIdExpected, cotizacionId);
    }

}