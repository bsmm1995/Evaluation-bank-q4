package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.entity.MovieEntity;
import com.bp.cbe.domain.dto.MovieDto;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	 MovieEntity toMovie(MovieDto movieDto);

	 MovieDto toMovieDto(MovieEntity movie);
}
