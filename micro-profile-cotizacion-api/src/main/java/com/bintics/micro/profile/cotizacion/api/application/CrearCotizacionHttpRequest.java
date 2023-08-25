package com.bintics.micro.profile.cotizacion.api.application;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearCotizacionHttpRequest {

    @JsonbProperty("name")
    private String name;

    @JsonbProperty("servicioId")
    private String servicioId;

}
