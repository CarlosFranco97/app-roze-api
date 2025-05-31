package com.example.app_roze_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Viajero")
public class Traveler extends User{

    @Column(name = "id_calificacion", nullable = false)
    private Integer ratingId;

    @Column(name = "id_viaje", nullable = false)
    private Integer tripId;

    @Column(name = "id_direccion", nullable = false)
    private Integer addressId;

}
