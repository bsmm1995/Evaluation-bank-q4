package com.bp.cbe.service.mapper;

import org.mapstruct.Mapper;

import com.bp.cbe.domain.Movie;
import com.bp.cbe.service.dto.MovieDto;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	public Movie toMovie(MovieDto movieDto);

	public MovieDto toMovieDto(Movie movie);

}
