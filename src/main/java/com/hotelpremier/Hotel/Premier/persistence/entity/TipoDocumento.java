package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipodoc")
@Getter
@Setter
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tpodoc")
    private Integer idTipoDoc;
    @Column(name = "nombre_tpodoc")
    private String descripcion;
    @Column(name = "activo_tpodoc")
    private String activo;
}
