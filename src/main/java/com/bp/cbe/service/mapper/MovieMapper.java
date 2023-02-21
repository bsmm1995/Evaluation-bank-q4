package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Movie;
import com.bp.cbe.domain.dto.MovieDto;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	 Movie toMovie(MovieDto movieDto);

	 MovieDto toMovieDto(Movie movie);
}
