package com.bintics.ddd.cotizacion;

import com.bintics.ddd.cotizacion.domain.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.Servicio;
import org.junit.jupiter.api.Test;

public class CotizacionDeServicioTest {

    @Test
    public void test() {
        CotizacionDeServicio cotizacion = new CotizacionDeServicio();
        cotizacion.agregarServicio(new Servicio(100.0));

        Double total = cotizacion.calcularPresupuestoTotal();
        System.out.println(total);
    }

}