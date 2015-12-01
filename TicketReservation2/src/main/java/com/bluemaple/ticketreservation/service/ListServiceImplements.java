package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.dao.ListDaoInterface;
import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.ReservationStatus;
import com.bluemaple.ticketreservation.model.TicketType;
import com.bluemaple.ticketreservation.model.Timings;


@Service
public class ListServiceImplements implements ListServiceInterface{
@Autowired
	ListDaoInterface ListDao;
	@Override
	public List<Movie> movielist() {
		// TODO Auto-generated method stub
		return ListDao.movieList();
	}
	@Override
	public List<Timings> timelist() {
		// TODO Auto-generated method stub
		return ListDao.timeList();
	}
	@Override
	public List<TicketType> ticketCountlist() {
		// TODO Auto-generated method stub
		return ListDao.ticketCountList();
	}
	@Override
	public List<ReservationStatus> reservationStatus() {
		// TODO Auto-generated method stub
		return ListDao.reservationStatus();
	}

}