package com.hotelpremier.Hotel.Premier.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {
    private String user;
    private String password;
    private int idtpodoc;
    private String nrodoc;
    private String names;
    private String lastname1;
    private String lastname2;
    private String email;
    private String phone;
}
