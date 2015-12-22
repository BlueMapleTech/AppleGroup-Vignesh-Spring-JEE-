package com.bluemaple.ticketreservation.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Movie;

@Repository
public class TicketRateDaoImplmplementation implements TicketRateDaoInterface {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Movie movie) {

		String sql = "INSERT INTO ticket_rate"
				+ "(ticket_rate,created_date,updated_date,movie_id,ticket_type,created_by,updated_by) VALUES (?, ?, ?, ?,?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(
				sql,
				new Object[] { movie.getTicket_rate(), movie.getDate(),
						movie.getDate(), movie.getMovie_id(),
						movie.getTicketTypeId(), movie.getCreated_by(),
						movie.getUpdated_by() });

	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
