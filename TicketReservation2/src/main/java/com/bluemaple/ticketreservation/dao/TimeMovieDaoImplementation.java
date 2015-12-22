package com.bluemaple.ticketreservation.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Movie;

@Repository
public class TimeMovieDaoImplementation implements TimeMovieDaoInterface {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void timeMovieId(int id, int movie_id) {
		System.out.println("values" + id + movie_id);

		Movie movie = new Movie();
		movie.setTimings_id(id);
		movie.setMovie_id(movie_id);
		String sql = "INSERT INTO movies_list_has_timings"
				+ "(movie_id,timings_id) VALUES (?, ?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,
				new Object[] { movie.getMovie_id(), movie.getTimings_id() });
	}

}
