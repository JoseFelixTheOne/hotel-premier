package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_piso")
@Getter
@Setter
public class Piso {
    @Id
    @Column(name = "id_piso")
    private int id;
    @Column(name = "desc_piso")
    private String descripcion;
    @Column(name = "activo_piso")
    private String activo;
}
