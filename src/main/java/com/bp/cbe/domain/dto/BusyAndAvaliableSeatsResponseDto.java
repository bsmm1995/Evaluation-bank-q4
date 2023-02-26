package com.bp.cbe.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BusyAndAvaliableSeatsResponseDto {
    private Integer avaliableSeats;
    private Integer busySeats;
    private LocalDate billboardDate;
}
