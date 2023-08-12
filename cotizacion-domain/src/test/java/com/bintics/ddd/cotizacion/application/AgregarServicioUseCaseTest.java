package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class AgregarServicioUseCaseTest {

    private CotizacionRepository cotizacionRepository;
    private ServicioRepository servicioRepository;

    @BeforeEach
    public void setUp() {
        String cotizacionId = "cotizacion-id-test";
        String servicioId = "servicio-id-test";

        List<CotizacionDeServicio> cotizacionRepositoryDataSource = new LinkedList<>();
        cotizacionRepositoryDataSource.add(new CotizacionDeServicio(cotizacionId));

        List<Servicio> serviciosRepositoryDataSource = new LinkedList<>();
        serviciosRepositoryDataSource.add(new Servicio(servicioId, 100.0));

        this.cotizacionRepository = new CotizacionRepositoryInMemory(cotizacionRepositoryDataSource);
        this.servicioRepository = new ServicioRepositoryInMemory(serviciosRepositoryDataSource);
    }

    @Test
    public void deberiaAgregarUnServivio() {
        CotizacionRepositorySpy cotizacionRepositorySpy = new CotizacionRepositorySpy(cotizacionRepository);
        AgregarServicioUseCase useCase = new AgregarServicioUseCase(
                cotizacionRepositorySpy,
                servicioRepository);

        String cotizacionId = "cotizacion-id-test";
        String servicioId = "servicio-id-test";

        AgregarServicioRequest request = new AgregarServicioRequest(cotizacionId, servicioId);
        useCase.agregarServicio(request);
        cotizacionRepositorySpy.assertSave(1);
    }

    @Test
    public void noDeberiaEncontrarLaCotizacionAlAgregarUnServivio() {
        AgregarServicioUseCase useCase = new AgregarServicioUseCase(
                cotizacionRepository,
                servicioRepository);

        String cotizacionId = "esta-cotizacion-no-existe";
        String servicioId = "empty";

        AgregarServicioRequest request = new AgregarServicioRequest(
                cotizacionId,
                servicioId);

        Assertions.assertThrows(CotizacionNotFoundException.class, () ->
                useCase.agregarServicio(request)
        );
    }

    @Test
    public void noDeberiaEncontrarElServicioAlAgregarUnServivio() {
        AgregarServicioUseCase useCase = new AgregarServicioUseCase(
                cotizacionRepository,
                servicioRepository);

        String cotizacionId = "cotizacion-id-test";
        String servicioId = "este-servicio-no-existe";

        AgregarServicioRequest request = new AgregarServicioRequest(
                cotizacionId,
                servicioId);

        Assertions.assertThrows(ServicioNotFoundException.class, () -> {
            useCase.agregarServicio(request);
        });
    }

}