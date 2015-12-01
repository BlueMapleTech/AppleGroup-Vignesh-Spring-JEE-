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



import com.bluemaple.ticketreservation.model.Movie;
import com.bluemaple.ticketreservation.model.Timings;
import com.bluemaple.ticketreservation.service.MovieServiceInterface;


@Controller
public class MovieController {
    @Autowired
	MovieServiceInterface movieService;
    
    //movie add link
	  
	  @RequestMapping(value = "/MovieRegister", method = RequestMethod.GET) 
	  public ModelAndView movie() {
		  
	  int moveId=0;
	  return new ModelAndView("AddMovie","userId",moveId) ;
	  
	  
	  }
    
	// movie updating and inserting
		@RequestMapping(value = "/movies", method = RequestMethod.POST)
		public ModelAndView movies(@ModelAttribute Movie movie) throws IOException {
			
			movieService.movieregister(movie);
			
			String msg = "movie register sucessfully";

			
			return new ModelAndView("redirect:/list", "msg", msg);
		}
		/*// movie list
		@RequestMapping(value = "/movielist")
		public ModelAndView listusers() throws IOException {

			List<Movie> movies = movieService.movielist();
			
			System.out.println(movies);
			
			
			ModelAndView model = new ModelAndView();
			
			model.addObject("MovieList", movies);
			model.setViewName("AdminDasboard");
			return model;

		}*/
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
