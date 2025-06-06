package com.example.app_roze_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Viajero")
public class Traveler extends User{

    @Column(name = "id_calificacion")
    private Integer ratingId;

    @Column(name = "id_viaje")
    private Integer tripId;

    @OneToMany(mappedBy = "traveler")
    private List<Address> addresses;

}
