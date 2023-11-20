package com.hotelpremier.Hotel.Premier.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDetail {
    private Integer detailId;
    private Integer roomId;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private BigDecimal price;
    private String note;
}
