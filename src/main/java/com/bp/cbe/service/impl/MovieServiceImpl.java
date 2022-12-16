package com.bp.cbe.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bp.cbe.repository.MovieRepository;
import com.bp.cbe.service.MovieService;
import com.bp.cbe.service.dto.MovieDto;
import com.bp.cbe.service.mapper.MovieMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;
	private MovieMapper movieMapper;
	
	@Override
	public List<MovieDto> listAll() throws Exception {
		return movieRepository.findAll().stream().map(movie -> movieMapper.toMovieDto(movie)).toList();
	}

	@Override
	public MovieDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieDto create(MovieDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieDto edit(MovieDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

}
