package com.bintics.micro.profile.cotizacion.example;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 *
 */
@Path("/cotizacion")
@Singleton
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello World";
    }

}
