package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.model.Servicio;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.CotizacionRepositoryInMemory;
import com.bintics.ddd.cotizacion.domain.ServicioRepositoryInMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

class CrearCotizacionUseCaseTest {

    @Test
    public void deberiaCrearUnaCotizacion() {
        String servicioId = "e0054ff5-82cb-4e48-b791-609df206e916";
        String cotizacionIdExpected = "";
        ServicioRepositoryInMemory servicioRepository = new ServicioRepositoryInMemory(Arrays.asList(new Servicio(servicioId, 100.0)));
        CotizacionRepository repository = new CotizacionRepositoryInMemory(new LinkedList<>());
        CrearCotizacionUseCase useCase = new CrearCotizacionUseCase(repository, servicioRepository);

        String cotizacionId = useCase.crear(new CrearCotizacionRequest("cotizacion de prueba", servicioId));

        Assertions.assertNotNull(cotizacionId);
        Assertions.assertNotSame(cotizacionIdExpected, cotizacionId);
    }

}