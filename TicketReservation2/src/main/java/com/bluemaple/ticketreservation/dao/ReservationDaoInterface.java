package com.bluemaple.ticketreservation.dao;

import java.util.List;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.MovieHasTiming;

public interface ReservationDaoInterface {

	public List<MovieHasTiming> showMovieTiming(int movie_id);

	public List<MovieHasTiming> bookTiming(List<MovieHasTiming> timings);

}
