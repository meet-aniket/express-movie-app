package com.movie.repository;

import com.movie.entity.Movie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	@Query("from movie m where m.movieTitle=?1")
	  public Optional<Movie> findByMovieTitle(String title);

	@Modifying
	@Query("delete from movie m where m.movieTitle=?1")
	public Integer deleteByTitle(String title);
}
