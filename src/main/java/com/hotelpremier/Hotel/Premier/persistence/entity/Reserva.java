package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_reserva")
@Getter
@Setter
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    private Integer idReserva;
    
}
