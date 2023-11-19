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
    @EmbeddedId
    private DetalleReservaPK id;
    @Column(name = "id_habitacion")
    private Integer idHabitacion;
    @Column(name = "checkin_reserva")
    private LocalDateTime checkinReserva;
    @Column(name = "checkout_reserva")
    private LocalDateTime checkoutReserva;
    @Column(name = "precio_reserva")
    private BigDecimal precioReserva;
    @Column(name = "observacion_reserva")
    private String observacionReserva;

    @ManyToOne
    @JoinColumn(name = "id_reserva", insertable = false, updatable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", insertable = false, updatable = false)
    private Habitacion habitacion;
}
