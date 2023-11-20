package com.hotelpremier.Hotel.Premier.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {
    private int idpas;
    private int idtpodoc;
    private String nrodoc;
    private String names;
    private String lastname1;
    private String lastname2;
    private String email;
    private String phone;
    private String active;
    private String passengerHasUser;

    private DocType docType;
}
