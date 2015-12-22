package com.bluemaple.ticketreservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.MovieHasTiming;
import com.bluemaple.ticketreservation.model.Timings;
import com.bluemaple.ticketreservation.service.ReservationServiceInterface;

@Controller
public class ReservationController {
	@Autowired
	ReservationServiceInterface reservationService;

	@RequestMapping(value = "/Book", method = RequestMethod.GET)
	public ModelAndView book(@RequestParam("movie_id") int movie_id,
			@RequestParam("user_id") int user_id) {
		List<MovieHasTiming> Timings = reservationService
				.showMovieTiming(movie_id);
		for(MovieHasTiming time : Timings){
		Timings timing=	reservationService.bookTiming(Timings);
		System.out.println("Time"+timing);
			
		}
		
		System.out.println(Timings);
		ModelAndView model = new ModelAndView();

		model.addObject("user_id", user_id);
		model.addObject("movie_id", movie_id);
		model.setViewName("BookTiming");
		return model;

	}

}
