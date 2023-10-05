package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_menu")
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private int idMenu;
    @Column(name = "nombre_menu")
    private String nombreMenu;
    @Column(name = "url_menu")
    private String urlMenu;
    @Column(name = "icono_menu")
    private String iconoMenu;
    @Column(name = "activo_menu")
    private String activoMenu;
}
