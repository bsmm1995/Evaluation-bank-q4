package com.bp.cbe.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusyAndAvaliableSeatsResponseDto {
	private Integer avaliableSeats;
	private Integer busySeats;
	private LocalDate billboardDate;
}
