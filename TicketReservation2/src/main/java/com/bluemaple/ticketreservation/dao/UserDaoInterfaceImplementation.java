package com.bluemaple.ticketreservation.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.User;

@Repository
public class UserDaoInterfaceImplementation implements UserDaoInterface {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public User registeration(User user) {
		// TODO Auto-generated method stub

		System.out.println(user.toString());
		String sql = "INSERT INTO user "
				+ "(username,password,firstname,lastname,email,address,created_date,updated_date,user_role) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
		System.out.println("query");

		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(
				sql,
				new Object[] { user.getUserName(), user.getPassword(),
						user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getAddress(), user.getDate(),
						user.getDate(), user.getUser_role() });

		return user;
	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
