package com.bintics.micro.profile.cotizacion.application.api;

import com.bintics.ddd.cotizacion.application.AgregarServicioRequest;
import com.bintics.ddd.cotizacion.application.AgregarServicioUseCase;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import javax.inject.Inject;
import javax.inject.Singleton;

@Path("/cotizaciones")
@Singleton
public class AgregarServicioController {

    private final AgregarServicioUseCase useCase;

    @Inject
    public AgregarServicioController(AgregarServicioUseCase useCase) {
        this.useCase = useCase;
    }

    @POST
    @Path("/{cotizacionId}/servicios")
    public void agregarServicio(@PathParam("cotizacionId") String cotizacionId, @BeanParam AgregarServicioHttpRequest request) {
        this.useCase.agregarServicio(new AgregarServicioRequest(
                cotizacionId,
                request.getServicioId()
        ));
    }

}
