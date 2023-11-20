package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipohabitacion")
@Getter
@Setter
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipohabitacion")
    private int id;
    @Column(name = "nombre_tipohabitacion")
    private String nombre;
    @Column(name = "desc_tipohabitacion")
    private String descripcion;
    @Column(name = "activo_tipohabitacion")
    private String activo;
}
