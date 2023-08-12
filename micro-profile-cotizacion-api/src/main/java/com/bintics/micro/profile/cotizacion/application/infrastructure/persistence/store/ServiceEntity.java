package com.bintics.micro.profile.cotizacion.application.infrastructure.persistence.store;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Table(name = "services")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@NamedQuery(name = "Service.findByQuoteId", query = "SELECT s FROM ServiceEntity s WHERE s.id.quoteId = :quoteId")
public class ServiceEntity implements Serializable {

    @EmbeddedId
    private ServiceId id;

    @Column
    private Double price;

}
