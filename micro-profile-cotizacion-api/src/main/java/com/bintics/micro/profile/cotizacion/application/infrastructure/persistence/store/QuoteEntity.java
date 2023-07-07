package com.bintics.micro.profile.cotizacion.application.infrastructure.persistence.store;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Table(name = "quotes")
@Entity
@Getter
@Setter
public class QuoteEntity implements Serializable {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Double total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

}
