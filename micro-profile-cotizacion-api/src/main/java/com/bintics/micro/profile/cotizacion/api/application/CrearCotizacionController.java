package com.bintics.micro.profile.cotizacion.api.application;

import com.bintics.ddd.cotizacion.application.CrearCotizacionRequest;
import com.bintics.ddd.cotizacion.application.CrearCotizacionUseCase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

/**
 *
 */
@Path("")
@Singleton
public class CrearCotizacionController {

    @Inject
    private CrearCotizacionUseCase useCase;

    @GET
    public String sayHello() {
        return "Hello World";
    }

    @POST
    public String crearCotizacion(@BeanParam CrearCotizacionHttpRequest request) {
        return this.useCase.crear(new CrearCotizacionRequest(
                request.getName(),
                request.getServicioId()
        ));
    }

}
