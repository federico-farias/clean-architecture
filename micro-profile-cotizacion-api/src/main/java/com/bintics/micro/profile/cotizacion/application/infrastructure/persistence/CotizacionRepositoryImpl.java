package com.bintics.micro.profile.cotizacion.application.infrastructure.persistence;

import com.bintics.ddd.cotizacion.domain.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.CotizacionRepository;
import com.bintics.ddd.cotizacion.domain.Servicio;
import com.bintics.micro.profile.cotizacion.application.infrastructure.persistence.store.QuoteEntity;
import com.bintics.micro.profile.cotizacion.application.infrastructure.persistence.store.ServiceEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
@Named("cotizacionRepositoryImpl")
public class CotizacionRepositoryImpl implements CotizacionRepository {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    @Override
    public CotizacionDeServicio findById(String cotizacionId) {
        QuoteEntity quote = this.em.find(QuoteEntity.class, cotizacionId);
        List<ServiceEntity> services = this.em.createNamedQuery("Service.findByQuoteId", ServiceEntity.class)
                .setParameter("quoteId", quote.getId())
                .getResultList();
        List<Servicio> servicios = services.stream().map(s -> new Servicio(s.getId().getId(), s.getPrice())).collect(Collectors.toList());
        return new CotizacionDeServicio(
                quote.getId(),
                quote.getName(),
                quote.getTotal(),
                servicios,
                quote.getCreatedAt(),
                quote.getUpdatedAt());
    }

    @Override
    public void save(CotizacionDeServicio cotizacion) {
        System.out.println(cotizacion);
    }

}
