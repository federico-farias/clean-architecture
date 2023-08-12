package com.bintics.ddd.cotizacion.application.api;

import com.bintics.ddd.cotizacion.application.AgregarServicioUseCase;
import com.bintics.ddd.cotizacion.application.AgregarServicioRequest;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AgregarServicioController {

    private final AgregarServicioUseCase useCase;
    //private final Counter bookCounter;
    private final Timer timer;

    public AgregarServicioController(AgregarServicioUseCase useCase, MeterRegistry meterRegistry) {
        this.useCase = useCase;
        //this.bookCounter = meterRegistry.counter("agregar.servicio.cnt", "status_code");
        this.timer = meterRegistry.timer("agregar.servicio.tmr", "status_code");
    }

    @PostMapping("/{cotizacionId}/servicios")
    public ResponseEntity<?> agregarServicio(@PathVariable("cotizacionId") String cotizacionId, @RequestBody AgregarServicioHttpRequest request) {
        this.timer.record(() -> this.useCase.agregarServicio(
                new AgregarServicioRequest(
                        cotizacionId,
                        request.getServicioId()
                )
        ));
        //this.bookCounter.increment();
        return ResponseEntity.ok().build();
    }

}
