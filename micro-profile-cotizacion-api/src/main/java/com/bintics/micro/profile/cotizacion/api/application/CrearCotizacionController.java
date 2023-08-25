package com.bintics.micro.profile.cotizacion.api.application;

import com.bintics.ddd.cotizacion.application.CrearCotizacionRequest;
import com.bintics.ddd.cotizacion.application.CrearCotizacionUseCase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearCotizacion(CrearCotizacionHttpRequest request) {
        String cotizacionId = this.useCase.crear(new CrearCotizacionRequest(
                request.getName(),
                request.getServicioId()
        ));
        Map<String, String> data = new HashMap<>();
        data.put("cotizacionId", cotizacionId);
        return Response.status(Response.Status.CREATED)
                .location(URI.create(String.format("/%s", cotizacionId)))
                .entity(data).build();
    }

}
