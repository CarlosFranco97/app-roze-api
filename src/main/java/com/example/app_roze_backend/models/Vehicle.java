package com.example.app_roze_backend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Vehiculo")
public class Vehicle  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "marca")
    private String brand;

    @Column(name = "modelo")
    private String model;

    @Column(name = "año")
    private String year;

    @Column(name = "color")
    private String color;

    @Column(name = "placa")
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver diver;

}
