package com.bluemaple.ticketreservation.dao;

import java.util.List;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.ReservationStatus;
import com.bluemaple.ticketreservation.model.TicketType;
import com.bluemaple.ticketreservation.model.Timings;

public interface ListDaoInterface {

	List<Movie> movieList();

	List<Timings> timeList();

	List<TicketType> ticketCountList();

	List<ReservationStatus> reservationStatus();

}
