package com.hotelpremier.Hotel.Premier.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "reserva", cascade = {CascadeType.ALL})
    private List<DetalleReserva> detalles;
}
