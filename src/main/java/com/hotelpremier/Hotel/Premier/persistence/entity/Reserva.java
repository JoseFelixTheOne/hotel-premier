package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reserva")
@Getter
@Setter
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;
    @Column(name = "total_reserva")
    private BigDecimal totalReserva;
    @Column(name = "activo_reserva")
    private String activoReserva;
}
