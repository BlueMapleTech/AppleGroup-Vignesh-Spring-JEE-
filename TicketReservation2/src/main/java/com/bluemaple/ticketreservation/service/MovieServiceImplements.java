package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.dao.MovieDaoInterface;
import com.bluemaple.ticketreservation.dao.TicketRateDaoInterface;
import com.bluemaple.ticketreservation.dao.TimeMovieDaoInterface;
import com.bluemaple.ticketreservation.model.Movie;

@Service
public class MovieServiceImplements implements MovieServiceInterface {
	@Autowired
	MovieDaoInterface movieDao;

	@Autowired
	TimeMovieDaoInterface timeMovieDao;
	@Autowired
	TicketRateDaoInterface ticketRateDao;

	@Override
	public Movie movieregister(Movie movie, String[] a) {
		String movie_name = movie.getMovie_name();
		Float ticket_rate = movie.getTicket_rate();
		Float ticket_rate1 = movie.getTicket_rate1();

		movieDao.movieregister(movie);
		Movie movie2 = movieDao.movieName(movie_name);
		int movie_id = movie2.getMovie_id();
		for (int i = 0; i < a.length; i++) {
			int id = Integer.parseInt(a[i]);

			timeMovieDao.timeMovieId(id, movie_id);
		}

		movie.setMovie_id(movie_id);
		movie.setTicket_rate(ticket_rate);
		movie.setTicketTypeId(1);
		ticketRateDao.insert(movie);

		movie.setMovie_id(movie_id);
		movie.setTicket_rate(ticket_rate1);
		movie.setTicketTypeId(2);
		ticketRateDao.insert(movie);
		return movie;

	}
	/*
	 * @Override public List<Movie> movielist() { // TODO Auto-generated method
	 * stub return movieDao.movielist();
	 * 
	 * }
	 */

}
