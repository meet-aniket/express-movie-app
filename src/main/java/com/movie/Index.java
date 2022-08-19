package com.movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.movie.dto.DirectorDTO;
import com.movie.dto.MovieDTO;
import com.movie.services.MovieServiceImplementation;

import ch.qos.logback.core.Context;


@SpringBootApplication
public class Index implements CommandLineRunner {
	@Autowired
	AbstractApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(Index.class, args);
	}
	
	@Override
	public void run(String...args) {
		MovieServiceImplementation movieService = (MovieServiceImplementation) context.getBean("movieService");
		
		// Insert Operation in the movie application
		MovieDTO movieDTO = new MovieDTO(001, "Marvel", LocalDate.now(), LocalDateTime.now());
		List<DirectorDTO> directorList = Arrays.asList(
					new DirectorDTO(001, "SanjayLeel", "Bhanshali", "Mombai",9876543210L, "sanjay@infosys.com"),
					new DirectorDTO(002, "S.S", "Rajamauli", "Delhi",8720807065L, "raja@infosys.com")
					);
		// Uncomment below code to add new entries
		// movieService.addMovie(movieDTO, directorList);
		
		// Get All the from movie name
		movieService.getDirectorsList("Marvel");
		
		// Get All movies from the table
		movieService.getAllMovies();
		
		// Delete movie by title
		movieService.deleteMovieByTitle("Marvel");
	}
}