package com.bluemaple.ticketreservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bluemaple.ticketreservation.model.Movie;

public class MovieId implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Movie movie = new Movie();
		movie.setMovie_id(rs.getInt("movie_id"));

		return movie;
	}

}
