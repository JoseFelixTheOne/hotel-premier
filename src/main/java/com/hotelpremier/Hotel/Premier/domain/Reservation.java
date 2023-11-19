package com.hotelpremier.Hotel.Premier.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Reservation {
    private Integer reservationId;
    private Integer iduser;
    private LocalDateTime date;
    private BigDecimal total;
    private String active;
    private List<ReservationDetail> details;
}
