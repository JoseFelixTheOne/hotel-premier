package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_habitacion")
@Getter
@Setter
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private int idHabitacion;
    @Column(name = "numero_habitacion")
    private String numeroHabitacion;
    @Column(name = "precio_habitacion")
    private double precioHabitacion;
    @Column(name = "id_estadohabitacion")
    private int idEstadoHabitacion;
    @Column(name = "id_piso")
    private int idPiso;
    @Column(name = "id_tipohabitacion")
    private int idTipoHabitacion;
    @Column(name = "activo_habitacion")
    private String activoHabitacion;

    @ManyToOne
    @JoinColumn(name = "id_estadohabitacion", insertable = false, updatable = false)
    private EstadoHabitacion objEstadoHabitacion;

    @ManyToOne
    @JoinColumn(name = "id_piso", insertable = false, updatable = false)
    private Piso objPiso;

    @ManyToOne
    @JoinColumn(name = "id_tipohabitacion", insertable = false, updatable = false)
    private TipoHabitacion objTipoHabitacion;
}
