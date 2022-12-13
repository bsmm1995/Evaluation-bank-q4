package com.bp.cbe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bp.cbe.domain.enums.MovieGenreEnum;

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
public class Movie extends BaseEntity {

	@NotEmpty(message = "name no puede ser nulo o vacio")
	@Size(max = 30, min = 1, message = "name minimo 1 y maximo 100 caracteres")
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@NotNull(message = "genre no puede ser nulo")
	@Enumerated(value = EnumType.STRING)
	@Column(name = "genre", length = 30, nullable = false)
	private MovieGenreEnum genre;
	@NotNull(message = "allowedAge no puede ser nulo")
	@Min(value = 1, message = "alloewedAge minima 1")
	@Column(name = "allowed_age", nullable = false)
	private Short allowedAge;
	@NotNull(message = "lengthMinutes no puede ser nulo")
	@Min(value = 1, message = "lengthMinutes minimo 1")
	@Column(name = "length_minutes", nullable = false)
	private Short lengthMinutes;

}
