package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_estado_habitacion")
@Getter
@Setter
public class EstadoHabitacion {
    @Id
    @Column(name = "id_estadohabitacion")
    private int id;
    @Column(name = "nombre_estadohabitacion")
    private String nombre;
}
