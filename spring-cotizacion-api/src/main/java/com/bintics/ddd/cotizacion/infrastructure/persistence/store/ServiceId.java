package com.bintics.ddd.cotizacion.infrastructure.persistence.store;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class ServiceId implements Serializable {

    private String id;

    private String quoteId;

}
