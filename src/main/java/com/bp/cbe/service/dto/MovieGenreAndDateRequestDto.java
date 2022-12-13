package com.bp.cbe.service.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bp.cbe.domain.enums.MovieGenreEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
