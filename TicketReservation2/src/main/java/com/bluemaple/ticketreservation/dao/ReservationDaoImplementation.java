package com.bluemaple.ticketreservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.MovieHasTiming;
import com.bluemaple.ticketreservation.model.Timings;
import com.bluemaple.ticketreservation.model.User;

@Repository
public class ReservationDaoImplementation implements ReservationDaoInterface {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MovieHasTiming> showMovieTiming(int movie_id) {
		// TODO Auto-generated method stub

		String sql = "SELECT timings_id FROM movies_list_has_timings where movie_id = '"
				+ movie_id + "'";

		/*
		 * List<MovieHasTiming> timingid = getJdbcTemplate().queryForObject(sql,
		 * new Object[] { movie_id }, new TimingId());
		 */

		List<MovieHasTiming> timingid = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(MovieHasTiming.class));

		return timingid;

	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<MovieHasTiming> bookTiming(List<MovieHasTiming> timings) {
		// TODO Auto-generated method stub
		String sql = "SELECT timings FROM timings where timings_id= '"
				+ timings + "'";

		List<MovieHasTiming> timing = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Timings.class));
		
		System.out.println(timings);
		return timing;
	}
}
