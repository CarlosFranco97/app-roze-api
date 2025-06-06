package com.example.app_roze_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Direccion")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "calle")
    private String street;

    @Column(name = "barrio")
    private String neighborhood;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "traveler_id")
    private Traveler traveler;
}
