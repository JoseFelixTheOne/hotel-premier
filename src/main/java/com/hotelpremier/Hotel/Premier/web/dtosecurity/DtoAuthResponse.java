package com.hotelpremier.Hotel.Premier.web.dtosecurity;

import lombok.Data;

// Esta clase va a ser la que nos delvolverá la información del token y el tipo que tenga este
@Data
public class DtoAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer ";

    public DtoAuthResponse(String accessToken){
        this.accessToken = accessToken;
    }
}
