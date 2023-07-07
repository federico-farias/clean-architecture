package com.bintics.ddd.cotizacion.application;

import com.bintics.ddd.cotizacion.domain.*;

public class AgregarServicioUseCase {

    private final CotizacionRepository cotizacionRepository;

    private final ServicioRepository servicioRepository;

    public AgregarServicioUseCase(CotizacionRepository cotizacionRepository, ServicioRepository servicioRepository) {
        this.cotizacionRepository = cotizacionRepository;
        this.servicioRepository = servicioRepository;
    }

    public void agregarServicio(AgregarServicioRequest request) {
        CotizacionDeServicio cotizacion = this.cotizacionRepository.findById(request.getCotizacionId());
        if (cotizacion == null) {
            throw new CotizacionNotFoundException("Cotizacion no encontrada [" + request.getCotizacionId() + "]");
        }
        Servicio servicio = this.servicioRepository.findById(request.getServicioId());
        if (servicio == null) {
            throw new ServicioNotFoundException("Servicio no encontrado [" + request.getServicioId() + "]");
        }
        cotizacion.agregarServicio(servicio);
        //this.cotizacionRepository.save(cotizacion); // TODO: ¿Cómo probamos que se ejecuto el método save?
    }

}
