package com.hotelpremier.Hotel.Premier.web.dtosecurity;

import lombok.Data;

@Data
public class DtoRegistro {
    private int iduser;
    private int idpassenger;
    private String username;
    private String password;
    private int usertpe;
    private String active;
}
