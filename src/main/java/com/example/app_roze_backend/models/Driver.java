package com.example.app_roze_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Driver")
public class Driver extends User{

    @OneToMany(mappedBy = "diver")
    @Column(name = "id_vehiculo")
    private List<Vehicle> vehicles;

    @Column(name = "id_viaje")
    private Integer tripId;

    @Column(name = "id_calificacion")
    private Integer ratingId;

}
