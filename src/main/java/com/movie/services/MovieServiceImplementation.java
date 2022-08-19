package com.movie.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.dto.DirectorDTO;
import com.movie.dto.MovieDTO;
import com.movie.entity.Director;
import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;

@Transactional
@Service("movieService")
public class MovieServiceImplementation implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public void addMovie(MovieDTO movieDTO, List<DirectorDTO> directorDTO) {
		try {
			System.out.println("Insertion execution started");
			
			// checking if movie exist with same Id or not
			Optional<Movie> movie = movieRepository.findById(movieDTO.getMovieId());
			if(!movie.isEmpty()) {
				throw new Exception("Movie is alrady exist with same Id in database");
			}
			
			// prepare the movieEntity
			Movie movieEntity = MovieDTO.prepareEntity(movieDTO);
			
			List<Director> directors = (List<Director>) directorDTO.stream().map(director -> {
				Director directorInMap = DirectorDTO.prepareEntity(director);
				return directorInMap; }).collect(Collectors.toList());
			
			// Mapping the directors with movie
			movieEntity.setDirectors(directors);
			
			movieRepository.saveAndFlush(movieEntity);
			System.out.println("Movie and Directors are added successfully");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// movieRepository.saveAndFlush(MovieDTO.prepareEntity(movieDTO));
	}
	
	@Override
	public void getDirectorsList(String movieName) {
		try {
			System.out.println(movieName);
			Optional<Movie> movie = movieRepository.findByMovieTitle(movieName);
			if(movie.isEmpty()) {
				throw new Exception("Movie does not exist with this Name");
			}
			System.out.println("Directors List");
			movie.get().getDirectors().stream().forEach(director -> System.out.println(director.getFirst_name() + director.getLast_name()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void getAllMovies() {
		List<Movie> movies =  movieRepository.findAll();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieTitle()));
	}
	
	@Override
	public void deleteMovieByTitle(String movieName) {
		try {
			System.out.println(movieName);
			Optional<Movie> movie = movieRepository.findByMovieTitle(movieName);
			if(movie.isEmpty()) {
				throw new Exception("Movie does not exist with this Name");
			}
			Integer movieStatus = movieRepository.deleteByTitle(movieName);
			if(movieStatus != null)
				System.out.println("Movie deleted successfully");
			else 
				System.out.println("Movie can not be deleted");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
