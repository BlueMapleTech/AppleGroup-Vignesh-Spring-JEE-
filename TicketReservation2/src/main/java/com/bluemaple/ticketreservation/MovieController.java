package com.bluemaple.ticketreservation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.Timings;
import com.bluemaple.ticketreservation.service.MovieServiceInterface;

@Controller
public class MovieController {
	@Autowired
	MovieServiceInterface movieService;

	// movie add link

	@RequestMapping(value = "/MovieRegister", method = RequestMethod.GET)
	public ModelAndView movie() {

		int moveId = 0;
		return new ModelAndView("AddMovie", "userId", moveId);

	}

	// movie updating and inserting
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	public ModelAndView movies(HttpServletRequest request) throws IOException,
			ParseException {
		Movie movie = new Movie();
		String movie_name = request.getParameter("movie_name");

		String startDateStr = request.getParameter("release_date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date release_date = sdf.parse(startDateStr);

		int no_of_shows = Integer.parseInt(request.getParameter("no_of_shows"));
		int movie_id = Integer.parseInt(request.getParameter("movie_id"));
		movie.setMovie_id(movie_id);
		movie.setMovie_name(movie_name);
		movie.setRelease_date(release_date);
		movie.setNo_of_shows(no_of_shows);

		Float ticket_rate = Float.parseFloat(request
				.getParameter("ticket_rate"));
		Float ticket_rate1 = Float.parseFloat(request
				.getParameter("ticket_rate1"));
		movie.setTicket_rate(ticket_rate);
		movie.setTicket_rate1(ticket_rate1);
		System.out.println(movie.toString());

		String a[] = request.getParameterValues("count");
		movieService.movieregister(movie, a);

		String msg = "movie register sucessfully";

		return new ModelAndView("redirect:/list", "msg", msg);
	}

	// movie link EDIT
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView movieupdate(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Movie movie = new Movie();
		movie.setMovie_id(userId);
		ModelAndView model = new ModelAndView("AddMovie", "userId", userId);
		return model;

	}
}
