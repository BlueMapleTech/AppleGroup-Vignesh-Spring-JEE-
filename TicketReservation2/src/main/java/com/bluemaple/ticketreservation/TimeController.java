package com.bluemaple.ticketreservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.ticketreservation.model.Timings;
import com.bluemaple.ticketreservation.service.TimingsServiceInterface;




@Controller
public class TimeController {
	@Autowired
	TimingsServiceInterface timingService;
	@RequestMapping(value = "/movietime", method = RequestMethod.POST)
	public ModelAndView movietiming(@ModelAttribute Timings time)
			throws IOException {

		timingService.movieTiming(time);
		
		String msg = "movie time register sucessfully";

		
		return new ModelAndView("redirect:/list", "msg", msg);
	}
	/*@RequestMapping(value = "/timelist")
	public ModelAndView timeList() throws IOException {

		List<Timings> times = timingService.timelist();
		
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("TimeLists", times);
		model.setViewName("AdminDasboard");
		return model;

	}*/
	//timeupdatelink
	@RequestMapping(value = "/edit2", method = RequestMethod.GET)
	public ModelAndView timeupdate(HttpServletRequest request) {
		int timeId = Integer.parseInt(request.getParameter("id"));
		
		ModelAndView model = new ModelAndView("movietiming", "timeid", timeId);
		return model;

	}
	//time insert link
	@RequestMapping(value = "/addingTime", method = RequestMethod.GET)
	public ModelAndView timeinsert() {
		int timeId = 0;
		
		ModelAndView model = new ModelAndView("movietiming", "timeid", timeId);
		return model;

	}
	
}
