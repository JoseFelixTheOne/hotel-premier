package com.hotelpremier.Hotel.Premier.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDetail {
    @NotNull(message = "detailId can't be null")
    private Integer detailId;
    @NotNull(message = "roomId can't be null")
    private Integer roomId;
    @NotNull(message = "checkin can't be null")
    private LocalDateTime checkin;
    @NotNull(message = "checkout can't be null")
    private LocalDateTime checkout;
    @NotNull(message = "price can't be null")
    private BigDecimal price;
    @NotEmpty(message = "note can't be null")
    private String note;
}
