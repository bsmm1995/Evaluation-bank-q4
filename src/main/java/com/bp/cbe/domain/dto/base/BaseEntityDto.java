package com.bp.cbe.domain.dto.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
public class BaseEntityDto {
    private Integer id;
    @NotNull(message = "state no puede ser nulo")
    private Boolean status;
}
