package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.dao.UserDaoInterface;
import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.User;

@Service
public class UserServiceImplementation implements UserServiceInterface {
	@Autowired
	UserDaoInterface userDao;

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return userDao.registeration(user);
	}

}
