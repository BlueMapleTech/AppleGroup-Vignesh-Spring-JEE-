package com.bluemaple.ticketreservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bluemaple.ticketreservation.model.User;



public class UserLogin implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		// TODO Auto-generated method stub
		User user=new User();
		user.setUserName(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setUser_role(rs.getInt("user_role"));
		
		return user;
	}
}
