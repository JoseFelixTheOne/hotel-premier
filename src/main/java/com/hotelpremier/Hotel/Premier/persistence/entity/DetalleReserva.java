package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_detallereserva")
@Getter
@Setter
public class DetalleReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detallereserva")
    private Integer idDetalle;
    @Column(name = "id_habitacion")
    private Integer idHabitacion;
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Column(name = "checkin_reserva")
    private LocalDateTime checkinReserva;
    @Column(name = "checkout_reserva")
    private LocalDateTime checkoutReserva;
    @Column(name = "precio_reserva")
    private BigDecimal precioReserva;
    @Column(name = "observacion_reserva")
    private String observacionReserva;
}
