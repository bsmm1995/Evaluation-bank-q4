package com.bp.cbe.domain.dto;

import com.bp.cbe.domain.dto.base.BaseEntityDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class SeatDto extends BaseEntityDto {
    @NotNull(message = "number no puede ser nulo")
    @Min(value = 1, message = "number valor minimo 1")
    private Short number;
    @NotNull(message = "rowNumber no puede ser nulo")
    @Min(value = 1, message = "rowNumber valor minimo 1")
    private Short rowNumber;
    @NotNull(message = "room no puede ser nulo")
    private RoomDto room;
}
