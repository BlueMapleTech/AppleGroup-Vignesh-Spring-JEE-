package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.dao.ReservationDaoInterface;
import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.MovieHasTiming;
import com.bluemaple.ticketreservation.model.Timings;

@Service
public class ReservationServiceImplementation implements
		ReservationServiceInterface {
	@Autowired
	ReservationDaoInterface reservationDao;

	@Override
	public List<MovieHasTiming> showMovieTiming(int movie_id) {
		// TODO Auto-generated method stub
		return reservationDao.showMovieTiming(movie_id);

	}

	@Override
	public Timings bookTiming(List<MovieHasTiming> timings) {
		// TODO Auto-generated method stub
		
		 reservationDao.bookTiming(timings);
		return null;
	}

}
