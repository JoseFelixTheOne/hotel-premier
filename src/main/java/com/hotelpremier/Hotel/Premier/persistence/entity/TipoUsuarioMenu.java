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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipousermenu")
    private int idMenuTipoUsuario;
    @Column(name = "id_tipouser")
    private int idTipoUsuario;
    @Column(name = "id_menu")
    private int idMenu;

    @ManyToOne
    @JoinColumn(name = "id_tipouser", insertable = false, updatable = false)
    private TipoUsuario objTipoUsu;

    @ManyToOne
    @JoinColumn(name = "id_menu", insertable = false, updatable = false)
    private Menu objMenu;

}
