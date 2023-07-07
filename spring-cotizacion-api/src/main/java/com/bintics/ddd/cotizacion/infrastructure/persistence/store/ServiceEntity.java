package com.bintics.ddd.cotizacion.infrastructure.persistence.store;

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
public class ServiceEntity implements Serializable {

    @EmbeddedId
    private ServiceId id;

    @Column
    private Double price;

}
