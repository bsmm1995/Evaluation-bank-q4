package com.bp.cbe.domain.dto;

import java.time.LocalDateTime;

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
public class BookingDto extends BaseEntityDto {

	@NotNull(message = "date no puede ser nulo")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime date;
	@NotNull(message = "customer no puede ser nulo")
	private CustomerDto customer;
	@NotNull(message = "seat no puede ser nulo")
	private SeatDto seat;
	@NotNull(message = "billboard no puede ser nulo")
	private BillboardDto billboard;

}
