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

    @ManyToOne
    @JoinColumn(name = "id_tipouser", insertable = false, updatable = false)
    private TipoUsuario objTipoUsu;

    @ManyToOne
    @JoinColumn(name = "id_menu", insertable = false, updatable = false)
    private Menu objMenu;

    public int getIdMenuTipoUsuario() {
        return idMenuTipoUsuario;
    }

    public void setIdMenuTipoUsuario(int idMenuTipoUsuario) {
        this.idMenuTipoUsuario = idMenuTipoUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public TipoUsuario getObjTipoUsu() {
        return objTipoUsu;
    }

    public void setObjTipoUsu(TipoUsuario objTipoUsu) {
        this.objTipoUsu = objTipoUsu;
    }

    public Menu getObjMenu() {
        return objMenu;
    }

    public void setObjMenu(Menu objMenu) {
        this.objMenu = objMenu;
    }
}
