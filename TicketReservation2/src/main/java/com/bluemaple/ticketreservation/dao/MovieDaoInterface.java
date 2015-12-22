package com.bluemaple.ticketreservation.dao;

import java.util.List;

import com.bluemaple.ticketreservation.model.Movie;

public interface MovieDaoInterface {

	public Movie movieregister(Movie movie);

	public Movie movieName(String movie_name);

	// public List<Movie> movielist();

}
