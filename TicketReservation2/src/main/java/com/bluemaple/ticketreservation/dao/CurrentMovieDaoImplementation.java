package com.bluemaple.ticketreservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Movie;

@Repository
public class CurrentMovieDaoImplementation implements CurrentMovieDaoInterface {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Movie> currentMovies() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM movie where release_date >= curdate() ";

		List<Movie> movie = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Movie.class));

		return movie;
	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
