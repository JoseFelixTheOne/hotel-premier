package com.hotelpremier.Hotel.Premier.domain;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocType {

    private int idTypeDoc;
    private String desc;
}
