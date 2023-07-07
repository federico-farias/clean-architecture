package com.bintics.ddd.cotizacion.infrastructure.persistence.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesEntitiesRepository extends JpaRepository<QuoteEntity, String> {
}
