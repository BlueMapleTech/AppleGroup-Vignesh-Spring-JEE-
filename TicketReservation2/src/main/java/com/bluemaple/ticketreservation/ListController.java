package com.bluemaple.ticketreservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.ReservationStatus;
import com.bluemaple.ticketreservation.model.TicketType;
import com.bluemaple.ticketreservation.model.Timings;
import com.bluemaple.ticketreservation.service.ListServiceInterface;

@Controller
public class ListController {
	@Autowired
	ListServiceInterface List;

	@RequestMapping(value = "/list")
	public ModelAndView list() throws IOException {

		List<Movie> movies = List.movielist();
		List<Timings> times = List.timelist();
		List<TicketType> tickets = List.ticketCountlist();
		List<ReservationStatus> status = List.reservationStatus();
		Map<String, Object> myModel = new HashMap<String, Object>();
		List<Map> data = new ArrayList<Map>();
		Map testdata = new HashMap();
		testdata.put("movies", movies);
		testdata.put("times", times);
		testdata.put("tickets", tickets);
		testdata.put("status", status);
		data.add(testdata);
		myModel.put("data", data);

		return new ModelAndView("AdminDasboard", "List", myModel);

	}
}
