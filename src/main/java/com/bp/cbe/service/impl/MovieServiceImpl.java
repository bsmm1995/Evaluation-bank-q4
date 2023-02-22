package com.bp.cbe.service.impl;

import com.bp.cbe.domain.entity.Movie;
import com.bp.cbe.domain.dto.MovieDto;
import com.bp.cbe.repository.MovieRepository;
import com.bp.cbe.service.MovieService;
import com.bp.cbe.service.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> listAll() {
        return movieRepository.findAll().stream().map(movieMapper::toMovieDto).toList();
    }

    @Override
    public MovieDto findById(Integer id) {
        return movieRepository.findById(id).map(movieMapper::toMovieDto).orElseThrow(() -> new NoSuchElementException("Movie not found id " + id));
    }

    @Override
    public MovieDto create(MovieDto t) {
        Movie movie = movieMapper.toMovie(t);
        return movieMapper.toMovieDto(movieRepository.save(movie));
    }

    @Override
    public MovieDto update(MovieDto t) {
        Optional<Movie> optional = movieRepository.findById(t.getId());
        if (optional.isPresent()) {
            var entity = optional.get();
            entity.setName(t.getName());
            return movieMapper.toMovieDto(movieRepository.save(entity));
        } else {
            throw new NoSuchElementException("Movie not found id " + t.getId());
        }
    }

    @Override
    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }
}
