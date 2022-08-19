package com.movie.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "movie")
public class Movie {
	@Id
	@Column(name = "movie_id")
	private Integer movieId;
	
	@Column(name = "movie_title")
	private String movieTitle;
	
	@Column(name = "release_date", updatable = false)
	private LocalDate releaseDate;
	
	@Column(name = "running_time", updatable = false)
	private LocalDateTime movieRunningTime;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE })  // OR:  cascade = CascadeType.ALL
	@JoinTable(name = "movie_director", 
			joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "movie_id"),
			inverseJoinColumns = @JoinColumn(name="director_id", referencedColumnName = "director_id")
		)
	private List<Director> directors;
	
	public Movie() {}
	
	public Movie(Integer movieId, String movieTitle, LocalDate releaseDate, LocalDateTime movieRunningTime) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.releaseDate = releaseDate;
		this.movieRunningTime = movieRunningTime;
	}

	// getters and setters to handle private properties related to Entity.
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
	
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	
	public List<Director> getDirectors() {
		return directors;
	}
}
