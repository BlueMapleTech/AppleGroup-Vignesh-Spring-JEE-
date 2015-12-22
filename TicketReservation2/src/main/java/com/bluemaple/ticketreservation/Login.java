package com.bluemaple.ticketreservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.User;
import com.bluemaple.ticketreservation.service.LoginServiceInterface;

@Controller
public class Login {
	@Autowired
	LoginServiceInterface loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user) throws Exception {

		ModelAndView model = new ModelAndView();

		/*
		 * if(user == null){ String msg = "error username or password error";
		 * model.addObject("msg", msg); model.setViewName("Login"); }
		 */

		User user1 = loginService.login(user);

		if (user1.getUser_role() == 1) {
			List<Movie> currentMovies = loginService.currentMovie();

			/* ModelAndView model = new ModelAndView(); */
			int user_id = user1.getUser_id();

			model.addObject("user_id", user_id);
			model.addObject("currentMovies", currentMovies);
			model.setViewName("UserDashboard");

			/*
			 * return new ModelAndView("UserDashboard", "currentMovies",
			 * currentMovies);
			 */

			return model;
		} else if (user1.getUser_role() == 2) {

			return new ModelAndView("redirect:/list");

		} else {
			String msg = "error username or password error";
			model.addObject("msg", msg);
			model.setViewName("Login");
		}
		return model;

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView movie() {

		return new ModelAndView("Login");

	}
}
