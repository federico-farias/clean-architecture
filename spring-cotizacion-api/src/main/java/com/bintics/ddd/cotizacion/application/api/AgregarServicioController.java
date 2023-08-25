package com.bintics.ddd.cotizacion.application.api;

import com.bintics.ddd.cotizacion.application.AgregarServicioRequest;
import com.bintics.ddd.cotizacion.application.AgregarServicioUseCase;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AgregarServicioController {

    private final AgregarServicioUseCase useCase;

    public AgregarServicioController(AgregarServicioUseCase useCase, MeterRegistry meterRegistry) {
        this.useCase = useCase;
    }

    @PostMapping("/{cotizacionId}/servicios")
    public ResponseEntity<?> agregarServicio(@PathVariable("cotizacionId") String cotizacionId, @RequestBody AgregarServicioHttpRequest request) {
        this.useCase.agregarServicio(
                new AgregarServicioRequest(
                        cotizacionId,
                        request.getServicioId()
                ));
        return ResponseEntity.ok().build();
    }

}
