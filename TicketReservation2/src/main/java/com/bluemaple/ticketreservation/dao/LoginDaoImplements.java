package com.bluemaple.ticketreservation.dao;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.User;
@Repository
public class LoginDaoImplements implements LoginDaoInterface {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public User login(String name1) {
		// TODO Auto-generated method stub
		System.out.println(name1);
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM user WHERE username = ?";
		
		User user = (User) getJdbcTemplate().queryForObject(sql,
				new Object[] { name1 }, new UserLogin());

		return user;
	
	}
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
