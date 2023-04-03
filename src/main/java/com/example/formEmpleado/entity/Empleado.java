package com.example.formEmpleado.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 40)
    private String apellido;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "email", nullable = false, unique = true)
    private String email;


}
