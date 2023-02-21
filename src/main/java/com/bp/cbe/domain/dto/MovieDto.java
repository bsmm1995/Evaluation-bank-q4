package com.bp.cbe.domain.dto;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class MovieDto extends BaseEntityDto {

	@NotEmpty(message = "name no puede ser nulo o vacio")
	@Size(max = 30, min = 1, message = "name minimo 1 y maximo 100 caracteres")
	private String name;
	@NotNull(message = "genre no puede ser nulo")
	private MovieGenreEnum genre;
	@NotNull(message = "allowedAge no puede ser nulo")
	@Min(value = 1, message = "alloewedAge minima 1")
	private Short allowedAge;
	@NotNull(message = "lengthMinutes no puede ser nulo")
	@Min(value = 1, message = "lengthMinutes minimo 1")
	private Short lengthMinutes;

}
