package com.bp.cbe.service.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class RoomDto extends BaseEntityDto {

	@NotEmpty(message = "name no puede ser nulo o vacio")
	@Size(max = 50, min = 1, message = "name minimo 1 y maximo 50 caracteres")
	private String name;
	@NotNull(message = "number no puede ser nulo")
	@Min(value = 1, message = "number valor minimo 1")
	private Short number;

}
