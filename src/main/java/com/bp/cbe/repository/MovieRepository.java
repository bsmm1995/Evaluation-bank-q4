package com.bp.cbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bp.cbe.domain.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
