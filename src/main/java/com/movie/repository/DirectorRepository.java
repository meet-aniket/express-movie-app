package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.entity.Movie;

public interface DirectorRepository extends JpaRepository<Movie, Integer>{
	// TODO: add methods which are not available in JpaRepository to manipulate dataBase.
}
