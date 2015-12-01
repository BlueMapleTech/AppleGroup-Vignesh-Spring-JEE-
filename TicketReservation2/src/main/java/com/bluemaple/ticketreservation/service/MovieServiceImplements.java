package com.bluemaple.ticketreservation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.dao.MovieDaoInterface;
import com.bluemaple.ticketreservation.model.Movie;

@Service
public class MovieServiceImplements implements MovieServiceInterface {
	@Autowired
MovieDaoInterface movieDao;
	@Override
	public Movie movieregister(Movie movie) {
		// TODO Auto-generated method stub
		 return movieDao.movieregister(movie);
	}
	/*@Override
	public List<Movie> movielist() {
		// TODO Auto-generated method stub
		return movieDao.movielist();
		
	}*/
}
