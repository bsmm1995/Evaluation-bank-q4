package com.bp.cbe.service.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusyAndAvaliableSeatsRequestDto {
	@NotNull(message = "Room no puede ser nulo")
	@Min(value = 1)
	private Integer idRoom;
	@NotNull(message = "billboardDate no puede ser nulo")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate billboardDate;
}
