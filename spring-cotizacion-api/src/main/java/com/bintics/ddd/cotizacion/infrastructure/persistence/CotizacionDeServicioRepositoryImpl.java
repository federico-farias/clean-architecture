package com.bintics.ddd.cotizacion.infrastructure.persistence;

import com.bintics.ddd.cotizacion.domain.model.CotizacionDeServicio;
import com.bintics.ddd.cotizacion.domain.model.Servicio;
import com.bintics.ddd.cotizacion.domain.repository.CotizacionRepository;
import com.bintics.ddd.cotizacion.infrastructure.persistence.store.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CotizacionDeServicioRepositoryImpl implements CotizacionRepository {

    private final QuotesEntitiesRepository quotesRepository;

    private final ServicesEntitiesRepository servicesRepository;

    public CotizacionDeServicioRepositoryImpl(QuotesEntitiesRepository repository, ServicesEntitiesRepository servicesRepository) {
        this.quotesRepository = repository;
        this.servicesRepository = servicesRepository;
    }

    @Override
    public CotizacionDeServicio findById(String cotizacionId) {
        Optional<QuoteEntity> quoteOptional = this.quotesRepository.findById(cotizacionId);
        if (!quoteOptional.isPresent()) {
            return null;
        }

        QuoteEntity quote = quoteOptional.get();

        List<ServiceEntity> services = this.servicesRepository.findByIdId(quote.getId());
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
    @Transactional
    public void save(CotizacionDeServicio cotizacion) {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setId(cotizacion.getId());
        quoteEntity.setName(cotizacion.getName().getValue());
        quoteEntity.setTotal(cotizacion.calcularPresupuestoTotal());
        quoteEntity.setCreatedAt(cotizacion.getCreatedAt()); // TODO: ¿Donde se setea?
        quoteEntity.setUpdatedAt(cotizacion.getUpdatedAt()); // TODO: ¿Donde se setea?

        // TODO: La lista es mutable
        List<ServiceEntity> servicesEntity = cotizacion.getServicios().stream().map(s ->
                        new ServiceEntity(
                                new ServiceId(
                                        s.getId(),
                                        cotizacion.getId()
                                ),
                                s.getCosto()
                        ))
                .collect(Collectors.toList());
        this.quotesRepository.save(quoteEntity);
        this.servicesRepository.saveAll(servicesEntity);
    }

}
