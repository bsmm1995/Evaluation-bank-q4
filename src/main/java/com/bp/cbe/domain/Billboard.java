package com.bp.cbe.domain;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class Billboard extends BaseEntity {

	@NotNull(message = "date no puede ser nulo")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date", nullable = false)
	private LocalDate date;
	@NotNull(message = "startTime no puede ser nulo")
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "startTime", nullable = false)
	private LocalTime startTime;
	@NotNull(message = "endTime no puede ser nulo")
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "endTime", nullable = false)
	private LocalTime endTime;
	@ManyToOne
	@JoinColumn(name = "id_movie", nullable = false, foreignKey = @ForeignKey(name = "FK_MOVIE_BILLBOARD"))
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "id_room", nullable = false, foreignKey = @ForeignKey(name = "FK_ROOM_BILLBOARD"))
	private Room room;

}
