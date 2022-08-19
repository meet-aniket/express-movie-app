// Data transfer object to create communication between services
package com.movie.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.movie.entity.Movie;

public class MovieDTO {
	private Integer movieId;
	private String movieTitle;
	private LocalDate releaseDate;
	private LocalDateTime movieRunningTime;
	
	public MovieDTO() {}
	
	public MovieDTO(Integer movieId, String movieTitle, LocalDate releaseDate, LocalDateTime movieRunningTime) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.releaseDate = releaseDate;
		this.movieRunningTime = movieRunningTime;
	}

	// Getters and setters to handle Data transfer object
	public Integer getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}
	
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public LocalDateTime getMovieRunningTime() {
		return movieRunningTime;
	}
	
	public void setMovieRunningTime(LocalDateTime movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}
	
	// method to prepare Movie data transfer object.
	public static Movie prepareEntity(MovieDTO movieDTO) {
		return new Movie(movieDTO.getMovieId(), movieDTO.getMovieTitle(), movieDTO.getReleaseDate(), movieDTO.getMovieRunningTime());
	}
}