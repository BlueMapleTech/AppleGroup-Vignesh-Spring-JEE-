package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.MovieHasTiming;
import com.bluemaple.ticketreservation.model.Timings;

public interface ReservationServiceInterface {

	public List<MovieHasTiming> showMovieTiming(int movie_id);

	public Timings bookTiming(List<MovieHasTiming> timings);

}
