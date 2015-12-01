package com.bluemaple.ticketreservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.ReservationStatus;
import com.bluemaple.ticketreservation.model.TicketType;
import com.bluemaple.ticketreservation.model.Timings;
@Repository
public class ListDaoImplements implements ListDaoInterface{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Movie> movieList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM movie";

		List<Movie> movie = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Movie.class));
		
	
		

	return movie;

		
	}
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Timings> timeList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM timings";

		List<Timings> time = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Timings.class));

		return time;
		
	}
	@Override
	public List<TicketType> ticketCountList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ticket_type";

		List<TicketType> ticket = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(TicketType.class));
		
		return ticket;
		
	}
	@Override
	public List<ReservationStatus> reservationStatus() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM reservation_status";
		List<ReservationStatus> status = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(ReservationStatus.class));
		
		return status;
	}

}
