package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipousuariomenu")
@Getter
@Setter
public class TipoUsuarioMenu {
    @Id
    @GeneratedValue
    @Column(name = "id_tipousermenu")
    private int idMenuTipoUsuario;
    @Column(name = "id_tipouser")
    private int idTipoUsuario;
    @Column(name = "id_menu")
    private int idMenu;
    @Column(name = "nombre_menu")
    private String nombreMenu;
    @Column(name = "activo_menu")
    private String activoMenu;
}