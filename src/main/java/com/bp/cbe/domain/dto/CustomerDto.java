package com.bp.cbe.domain.dto;

import com.bp.cbe.domain.dto.base.BaseEntityDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerDto extends BaseEntityDto {
    @NotEmpty(message = "documentNumber no puede ser nulo o vacio")
    @Size(max = 20, min = 8, message = "documentNumber minimo 8 y maximo 20 caracteres")
    private String documentNumber;
    @NotEmpty(message = "name no puede ser nulo o vacio")
    @Size(max = 30, min = 1, message = "name minimo 1 y maximo 30 caracteres")
    private String name;
    @NotEmpty(message = "lastname no puede ser nulo o vacio")
    @Size(max = 30, min = 1, message = "lastname minimo 1 y maximo 30 caracteres")
    private String lastname;
    @NotNull(message = "age no puede ser nulo")
    @Min(value = 1, message = "age minima 1")
    private Short age;
    @Size(max = 20, min = 0, message = "phoneNumber minimo 1 y maximo 20 caracteres")
    private String phoneNumber;
    @Email(message = "ingresa un email valido")
    private String email;
}
