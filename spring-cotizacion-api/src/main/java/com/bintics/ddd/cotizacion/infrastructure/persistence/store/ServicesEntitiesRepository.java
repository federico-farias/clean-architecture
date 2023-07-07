package com.bintics.ddd.cotizacion.infrastructure.persistence.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesEntitiesRepository extends JpaRepository<ServiceEntity, ServiceId> {

    List<ServiceEntity> findByIdId(String quoteId);

}
