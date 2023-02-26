package com.bp.cbe.domain.dto;

import com.bp.cbe.domain.dto.base.BaseEntityDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class BillboardDto extends BaseEntityDto {
    @NotNull(message = "date no puede ser nulo")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate date;
    @NotNull(message = "startTime no puede ser nulo")
    @DateTimeFormat(iso = ISO.TIME)
    private LocalTime startTime;
    @NotNull(message = "endTime no puede ser nulo")
    @DateTimeFormat(iso = ISO.TIME)
    private LocalTime endTime;
    @NotNull(message = "movie no puede ser nulo")
    private MovieDto movie;
    @NotNull(message = "room no puede ser nulo")
    private RoomDto room;
}
