package com.example.app_roze_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Driver")
public class Driver extends User{

    @Column(name = "id_vehiculo")
    private Integer vehicleId;

    @Column(name = "id_viaje")
    private Integer tripId;

    @Column(name = "id_calificacion")
    private Integer ratingId;

}
