package com.bp.cbe.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusyAndAvaliableSeatsRequestDto {
    @NotNull(message = "Room no puede ser nulo")
    @Min(value = 1)
    private Integer idRoom;
    @NotNull(message = "billboardDate no puede ser nulo")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate billboardDate;
}
