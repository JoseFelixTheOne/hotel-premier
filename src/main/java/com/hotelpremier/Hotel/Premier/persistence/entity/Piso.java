package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_piso")
@Getter
@Setter
public class Piso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piso")
    private int id;
    @Column(name = "desc_piso")
    private String descripcion;
    @Column(name = "activo_piso")
    private String activo;
}
