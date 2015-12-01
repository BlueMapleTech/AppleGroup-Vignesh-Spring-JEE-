package com.bluemaple.ticketreservation.service;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.ReservationStatus;
import com.bluemaple.ticketreservation.model.TicketType;
import com.bluemaple.ticketreservation.model.Timings;

public interface ListServiceInterface {

	java.util.List<Movie> movielist();

	java.util.List<Timings> timelist();

	java.util.List<TicketType> ticketCountlist();

	java.util.List<ReservationStatus> reservationStatus();

}
