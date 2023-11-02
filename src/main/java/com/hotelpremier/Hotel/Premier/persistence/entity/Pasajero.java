package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_pasajero")
@Getter
@Setter
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasajero")
    private int idpasajero;
    @Column(name = "id_tpodoc")
    private int idtpodocumento;
    @Column(name = "nrodoc_pasajero")
    private String nrodocumento;
    @Column(name = "nombres_pasajero")
    private String nombres;
    @Column(name = "apellidopaterno_pasajero")
    private String apellidopaterno;
    @Column(name = "apellidomaterno_pasajero")
    private String apellidomaterno;
    @Column(name = "correo_pasajero")
    private String correo;
    @Column(name = "telefono_pasajero")
    private String telefono;
    @Column(name = "activo_pasajero")
    private String activo;

    @ManyToOne
    @JoinColumn(name = "id_tpodoc", insertable = false, updatable = false)
    private TipoDocumento objTpoDoc;
}
