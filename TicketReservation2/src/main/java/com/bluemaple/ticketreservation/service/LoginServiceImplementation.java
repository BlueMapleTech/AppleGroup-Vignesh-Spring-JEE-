package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.ticketreservation.dao.CurrentMovieDaoInterface;
import com.bluemaple.ticketreservation.dao.LoginDaoInterface;
import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.User;

@Service
public class LoginServiceImplementation implements LoginServiceInterface {
	@Autowired
	LoginDaoInterface LoginDao;
	@Autowired
	CurrentMovieDaoInterface currentMovieDao;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String name1 = user.getUserName();
		String password1 = user.getPassword();
		System.out.println(name1 + password1);
		User newuser = LoginDao.login(name1);

		int user_id = newuser.getUser_id();
		String name2 = newuser.getUserName();
		String password2 = newuser.getPassword();
		int user_role1 = newuser.getUser_role();
		System.out.println("Service: " + name2 + "" + password2 + user_role1);
		ModelAndView model = new ModelAndView();

		if ((user_role1 == 1) && (name1.equals(name2))
				&& (password1.equals(password2))) {
			newuser.setUser_role(1);
			newuser.setUser_id(user_id);

		} else if ((user_role1 == 2) && (name1.equals(name2))
				&& (password1.equals(password2))) {
			newuser.setUser_role(2);

		} else {
			newuser.setUser_role(3);
		}
		return newuser;

	}

	@Override
	public List<Movie> currentMovie() {
		// TODO Auto-generated method stub
		return currentMovieDao.currentMovies();
	}

}
