package com.hotelpremier.Hotel.Premier.web.dtosecurity;

import com.hotelpremier.Hotel.Premier.domain.Passenger;
import com.hotelpremier.Hotel.Premier.domain.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUserUpdate {

    private int iduser;
    private int idpassenger;
    private String user;
    private int usertpe;
    private String active = "A";

    private UserType objuserType;
    private Passenger objPassenger;
}
