package com.bp.cbe.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseEntityDto {

	private Integer id;
	@NotNull(message = "state no puede ser nulo")
	private Boolean status;
}
