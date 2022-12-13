package com.bp.cbe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class Seat extends BaseEntity {

	@NotNull(message = "number no puede ser nulo")
	@Min(value = 1, message = "number valor minimo 1")
	@Column(name = "number", nullable = false)
	private Short number;
	@NotNull(message = "rowNumber no puede ser nulo")
	@Min(value = 1, message = "rowNumber valor minimo 1")
	@Column(name = "row_number", nullable = false)
	private Short rowNumber;
	@ManyToOne
	@JoinColumn(name = "id_room", nullable = false, foreignKey = @ForeignKey(name = "FK_ROOM_SEAT"))
	private Room room;

}
