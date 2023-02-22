package com.bp.cbe.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity
public class Booking extends BaseEntity {

	@NotNull(message = "date no puede ser nulo")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "date", nullable = false)
	private LocalDateTime date;
	@ManyToOne
	@JoinColumn(name = "id_custumer", nullable = false, foreignKey = @ForeignKey(name = "FK_CUSTOMER_BOOKING"))
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "id_seat", nullable = false, foreignKey = @ForeignKey(name = "FK_SEAT_BOOKING"))
	private Seat seat;
	@ManyToOne
	@JoinColumn(name = "id_billboard", nullable = false, foreignKey = @ForeignKey(name = "FK_BILLBOARD_BOOKING"))
	private Billboard billboard;

}
