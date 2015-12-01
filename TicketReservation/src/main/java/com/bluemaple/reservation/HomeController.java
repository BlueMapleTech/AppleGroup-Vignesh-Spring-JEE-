package com.bluemaple.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.reservation.model.Admin;
import com.bluemaple.reservation.model.Timings;
import com.bluemaple.reservation.model.User;
import com.bluemaple.reservation.service.ReservationServiceInterface;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	@Autowired
	ReservationServiceInterface service;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView value() {
		ModelAndView model = new ModelAndView("registration");
		return model;

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView value(@ModelAttribute User user) throws IOException {

		service.register(user);

		String msg = "register sucessfully";

		return new ModelAndView("home", "msg", msg);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	// public ModelAndView login(@RequestParam("username")String
	// name,@RequestParam("password")String password)throws Exception{
	public ModelAndView login(@ModelAttribute User user) throws Exception {
		// service.login(name,password);
		// System.out.println(name+password);
		ModelAndView model = new ModelAndView();
		User user1 = service.login(user);

		if (user1.getUser_role() == 1) {
			String msg = "userlogin";
			model.setViewName("userdashboard");
			model.addObject("msg", msg);
		} else if (user1.getUser_role() == 2) {
			model.setViewName("admindashboard");
			String msg = "adminlogin";
			model.addObject("msg", msg);
		} else if (user1.getUser_role() == 3) {
			String msg = null;
			model.addObject("msg", msg);
			model.setViewName("home");
		} else {
			String msg = "error username or password error";
			model.addObject("msg", msg);
			model.setViewName("home");
		}
		return model;

	}

		// admindashboard

	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public ModelAndView adminhome() {
		ModelAndView model = new ModelAndView("admindashboard");
		return model;

	}

	/*
	 * //movie link
	 * 
	 * @RequestMapping(value = "/movie", method = RequestMethod.GET) public
	 * ModelAndView movie() { ModelAndView model=new ModelAndView("addmovie");
	 * return model;
	 * 
	 * 
	 * }
	 */
	// movie updating
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public ModelAndView movies(@ModelAttribute Admin admin) throws IOException {
		System.out.println("movuie");

		service.movieregister(admin);
		System.out.println(admin.getMovie_name());
		String msg = "movie register sucessfully";

		// return new ModelAndView("admindashboard","msg",msg);
		return new ModelAndView("redirect:/movielist", "msg", msg);
	}

	// movie list
	@RequestMapping(value = "/movielist")
	public ModelAndView listusers() throws IOException {

		List<Admin> movies = service.movielist();
		
		System.out.println(movies);
		ModelAndView model = new ModelAndView();
		
		model.addObject("MovieList", movies);
		model.setViewName("movielist");
		return model;

	}

	// movie link EDIT
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView movieupdate(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Admin admin = new Admin();
		admin.setMovie_id(userId);
		ModelAndView model = new ModelAndView("addmovie", "userId", userId);
		return model;

	}
	
	// movietime link
	@RequestMapping(value = "/timing", method = RequestMethod.GET)
	public ModelAndView timing() {
		ModelAndView model = new ModelAndView("movietiming");
		return model;
	}
	
	@RequestMapping(value = "/movietime", method = RequestMethod.POST)
	public ModelAndView movietiming(@ModelAttribute Timings time)
			throws IOException {
System.out.println(time.getTimings_id());
		service.movieTiming(time);
		
		String msg = "movie time register sucessfully";

		// return new ModelAndView("admindashboard","msg",msg);
		return new ModelAndView("redirect:/timelist", "msg", msg);
	}
	@RequestMapping(value = "/timelist")
	public ModelAndView timeList() throws IOException {

		List<Timings> times = service.timelist();
		
		System.out.println(times);
		ModelAndView model = new ModelAndView();
		
		model.addObject("TimeLists", times);
		model.setViewName("timinglist");
		return model;

	}
	//timeupdatelink
	@RequestMapping(value = "/edit2", method = RequestMethod.GET)
	public ModelAndView timeupdate(HttpServletRequest request) {
		int timeId = Integer.parseInt(request.getParameter("id"));
		
		ModelAndView model = new ModelAndView("movietiming", "timeid", timeId);
		return model;

	}
	
}
