package com.bintics.ddd.cotizacion.infrastructure.persistence;

import com.bintics.ddd.cotizacion.domain.model.Servicio;
import com.bintics.ddd.cotizacion.domain.repository.ServicioRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ServicioGatewayImpl implements ServicioRepository {
    @Override
    public Servicio findById(String servicioId) {
        String id = UUID.randomUUID().toString();
        Double price = randomPrice(500.0, 3000.0);
        return new Servicio(id, price);
    }

    private Double randomPrice(Double min, Double max) {
        double x = (Math.random() * ((max - min) + 1)) + min;   // This Will Create A Random Number Inbetween Your Min And Max.
        double xrounded = Math.round(x * 100.0) / 100.0;   // Creates Answer To The Nearest 100 th, You Can Modify This To Change How It Rounds.
        return xrounded;
    }

}
