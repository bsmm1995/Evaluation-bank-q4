package com.bp.cbe.domain.dto;

import com.bp.cbe.domain.enums.MovieGenreEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class MovieGenreAndDateRequestDto {
    @NotNull(message = "genre can't be null")
    private MovieGenreEnum genre;
    @NotNull(message = "startDate can't be null")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime startDate;
    @NotNull(message = "endDate can't be null")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime endDate;
}
