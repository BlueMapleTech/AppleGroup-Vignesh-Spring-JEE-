package com.bluemaple.ticketreservation.service;

import java.util.List;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.User;

public interface LoginServiceInterface {

	public User login(User user);

	public List<Movie> currentMovie();

}
