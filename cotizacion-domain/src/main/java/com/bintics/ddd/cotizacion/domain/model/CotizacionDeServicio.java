package com.bintics.ddd.cotizacion.domain.model;

import com.bintics.ddd.cotizacion.domain.exception.ServivioAlreadyExistsExceotion;
import lombok.Getter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

// Root aggregate
public class CotizacionDeServicio {

    @Getter
    private String id;

    @Getter
    private CotizacionName name;

    @Getter
    private List<Servicio> servicios = new LinkedList<>();

    @Getter
    private Date createdAt;

    @Getter
    private Date updatedAt;
    private double presupuestoTotal;

    public CotizacionDeServicio(String id) {
        this.id = id;
    }

    public CotizacionDeServicio() {
        this.id = UUID.randomUUID().toString();
    }

    public static CotizacionDeServicio create(CotizacionName name, Servicio servicio) {
        CotizacionDeServicio root = new CotizacionDeServicio();
        root.name = name;
        root.agregarServicio(servicio);
        return root;
    }

    public CotizacionDeServicio(String id, String name, Double total, List<Servicio> servicios, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = new CotizacionName(name);
        this.presupuestoTotal = total;
        this.servicios = servicios;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void agregarServicio(Servicio servicio) {
        for (Servicio s : servicios) {
            if (s.equals(servicio)) {
                throw new ServivioAlreadyExistsExceotion(String.format("El servicio %s ya existe", servicio));
            }
        }
        this.servicios.add(servicio);
        this.presupuestoTotal += servicio.getCosto();
    }

    public double calcularPresupuestoTotal() {
        return this.presupuestoTotal;
    }
}
