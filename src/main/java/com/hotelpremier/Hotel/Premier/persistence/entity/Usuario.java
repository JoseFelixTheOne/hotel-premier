package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idusuario;
    @Column(name = "id_pasajero")
    private int idpasajero;
    @Column(name = "user_usuario")
    private String usuarioacceso;
    @Column(name = "clave_usuario", updatable = false)
    private String clave;
    @Column(name = "id_tipouser")
    private int tipousuario;
    @Column(name = "activo_usuario")
    private String activo;

    @ManyToOne
    @JoinColumn(name = "id_pasajero", insertable = false, updatable = false)
    private Pasajero objPasajero;

    @ManyToOne
    @JoinColumn(name = "id_tipouser", insertable = false, updatable = false)
    private TipoUsuario objTpoUsuario;

}
