package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.model.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.model.Servicio;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.repository.ServicioRepository;
import com.bintics.ddd.cotizacion.domain.service.ContizacionFinder;
import com.bintics.ddd.cotizacion.domain.service.ServiceFinder;

public class AgregarServicioUseCase {

    private final CotizacionRepository cotizacionRepository;

    private final ServiceFinder serviceFinder;
    private final ContizacionFinder cotizacionFinder;

    public AgregarServicioUseCase(CotizacionRepository cotizacionRepository, ServicioRepository servicioRepository) {
        this.cotizacionRepository = cotizacionRepository;
        this.serviceFinder = new ServiceFinder(servicioRepository);
        this.cotizacionFinder = new ContizacionFinder(cotizacionRepository);
    }

    public void agregarServicio(AgregarServicioRequest request) {
        CotizacionDeServicio cotizacion = this.cotizacionFinder.find(request.getCotizacionId());
        Servicio servicio = this.serviceFinder.find(request.getServicioId());
        cotizacion.agregarServicio(servicio);
        this.cotizacionRepository.save(cotizacion);
    }

}
