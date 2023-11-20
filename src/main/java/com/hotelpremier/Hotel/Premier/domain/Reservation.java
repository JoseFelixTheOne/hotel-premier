package com.hotelpremier.Hotel.Premier.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Reservation {
    private Integer reservationId;
    @NotNull(message = "iduser can't be null")
    private Integer iduser;
    private LocalDateTime date = LocalDateTime.now();
    private BigDecimal total;
    private String active = "A";
    @Valid
    private List<ReservationDetail> details;
}
