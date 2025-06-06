package com.example.app_roze_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "correo", unique = true, nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String password;

    @Column(name = "dni")
    private String dni;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "fecha_nacimiento")
    private LocalDate birthdate;

    @Column(name = "tipo_usuario")
    private String userType;


}
