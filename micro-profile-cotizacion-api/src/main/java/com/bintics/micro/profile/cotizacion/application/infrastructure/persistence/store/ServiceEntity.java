package com.bintics.micro.profile.cotizacion.application.infrastructure.persistence.store;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
