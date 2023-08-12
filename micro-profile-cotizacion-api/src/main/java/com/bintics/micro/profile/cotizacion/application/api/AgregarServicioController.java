package com.bintics.micro.profile.cotizacion.application.api;

import com.bintics.ddd.cotizacion.application.AgregarServicioRequest;
import com.bintics.ddd.cotizacion.application.AgregarServicioUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;

import javax.inject.Inject;

@Path("cotizaciones")
@ApplicationScoped
public class AgregarServicioController {

    @Inject
    private AgregarServicioUseCase useCase;

    @GET
    public String getHome() {
        return "Hola!";
    }

    @GET
    @Path("{cotizacionId}/servicios")
    public String getServicio(@PathParam("cotizacionId") String cotizacionId) {
        return cotizacionId;
    }

    @POST
    @Path("/{cotizacionId}/servicios")
    public void agregarServicio(@PathParam("cotizacionId") String cotizacionId, @BeanParam AgregarServicioHttpRequest request) {
        System.out.println("Entro al controlador!");
        this.useCase.agregarServicio(new AgregarServicioRequest(
                cotizacionId,
                request.getServicioId()
        ));
    }

}
