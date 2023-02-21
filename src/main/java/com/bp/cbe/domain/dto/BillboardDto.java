package com.bp.cbe.domain.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class BillboardDto extends BaseEntityDto {

	@NotNull(message = "date no puede ser nulo")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;
	@NotNull(message = "startTime no puede ser nulo")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime startTime;
	@NotNull(message = "endTime no puede ser nulo")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime endTime;
	@NotNull(message = "movie no puede ser nulo")
	private MovieDto movie;
	@NotNull(message = "room no puede ser nulo")
	private RoomDto room;

}
