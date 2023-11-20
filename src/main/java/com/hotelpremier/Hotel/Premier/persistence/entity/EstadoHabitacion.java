package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_estado_habitacion")
@Getter
@Setter
public class EstadoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadohabitacion")
    private int id;
    @Column(name = "nombre_estadohabitacion")
    private String nombre;
}
