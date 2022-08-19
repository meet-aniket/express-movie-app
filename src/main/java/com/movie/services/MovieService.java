package com.movie.services;

import java.util.List;

import com.movie.dto.DirectorDTO;
import com.movie.dto.MovieDTO;

public interface MovieService {
	// Method to add movie in dataBase
	abstract void addMovie(MovieDTO movieDTO, List<DirectorDTO> directorDTO);
	abstract void getDirectorsList(String movieName);
	abstract void getAllMovies();
	abstract void deleteMovieByTitle(String movieName);
}
