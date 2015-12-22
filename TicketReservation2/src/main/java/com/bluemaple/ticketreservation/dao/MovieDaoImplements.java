package com.bluemaple.ticketreservation.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.User;
import com.mysql.jdbc.Connection;

@Repository
public class MovieDaoImplements implements MovieDaoInterface {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public Movie movieregister(Movie movie) {
		// TODO Auto-generated method stub
		int id = movie.getMovie_id();

		if (id == 0) {
			jdbcTemplate = new JdbcTemplate(dataSource);
			String sql = "INSERT INTO movie"
					+ "(movie_name,release_date,no_of_shows,created_date,updated_date,active,created_by,updated_by) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

			jdbcTemplate.update(
					sql,
					new Object[] { movie.getMovie_name(),
							movie.getRelease_date(), movie.getNo_of_shows(),
							movie.getDate(), movie.getDate(),
							movie.getActive(), movie.getCreated_by(),
							movie.getUpdated_by() });
		} else {

			JdbcTemplate delete = new JdbcTemplate(dataSource);
			delete.update(
					"DELETE from movies_list_has_timings where movie_id=?",
					new Object[] { movie.getMovie_id() });

			String sql = "update movie set movie_name=?,release_date=?,no_of_shows=?,updated_date=?,active=?,created_by=?,updated_by=? where movie_id=?";

			jdbcTemplate = new JdbcTemplate(dataSource);

			System.out.println(movie.getMovie_id());
			jdbcTemplate.update(
					sql,
					new Object[] { movie.getMovie_name(),
							movie.getRelease_date(), movie.getNo_of_shows(),
							movie.getDate(), movie.getActive(),
							movie.getCreated_by(), movie.getUpdated_by(),
							movie.getMovie_id() });

		}
		return movie;

	}

	/*
	 * @Override public List<Movie> movielist() { // TODO Auto-generated method
	 * stub String sql = "SELECT * FROM movie";
	 * 
	 * List<Movie> movie = getJdbcTemplate().query(sql, new
	 * BeanPropertyRowMapper(Movie.class));
	 * 
	 * 
	 * 
	 * 
	 * return movie;
	 * 
	 * }
	 */

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Movie movieName(String movie_name) {
		// TODO Auto-generated method stub

		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM movie WHERE movie_name = ?";

		Movie movie = (Movie) getJdbcTemplate().queryForObject(sql,
				new Object[] { movie_name }, new MovieId());

		return movie;

	}

}
