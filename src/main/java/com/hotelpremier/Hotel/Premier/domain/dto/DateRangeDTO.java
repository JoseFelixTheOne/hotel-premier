package com.hotelpremier.Hotel.Premier.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DateRangeDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
