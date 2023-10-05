package com.hotelpremier.Hotel.Premier.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int iduser;
    private int idpassenger;
    private String user;
    private String password;
    private int usertpe;
    private String active;

    private UserType objuserType;
}
