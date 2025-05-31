package com.example.app_roze_backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionIdMutability;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "correo", unique = true, nullable = false)
    private String email;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "dni")
    private int dni;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "fecha_nacimiento")
    private LocalDate birthdate;

    @Column(name = "tipo_usuario")
    private String userType;


}
