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

import com.bluemaple.ticketreservation.model.TicketType;
import com.bluemaple.ticketreservation.service.TicketTypeServiceInterface;

@Controller
public class TicketTypeController {
	@Autowired
TicketTypeServiceInterface ticketType;
	
	 
	  
	  @RequestMapping(value = "/tickettype", method = RequestMethod.GET) 
	  public ModelAndView ticket() {
		  
	  int ticket_type_id=0;
	  return new ModelAndView("TicketTypes","ticket_type_id",ticket_type_id) ;
	  
	  
	  }
  
	
		@RequestMapping(value = "/addticket", method = RequestMethod.POST)
		public ModelAndView ticketAndCount(@ModelAttribute TicketType ticket) throws IOException {
			
			System.out.println("Controller"+ticket);
			 ticketType.ticketType(ticket);
			
			String msg = " register sucessfully";

			
			return new ModelAndView("redirect:/list", "msg", msg);
		}

		/*@RequestMapping(value = "/ticketlist")
		public ModelAndView listusers() throws IOException {

			List<TicketType> tickets = ticketType.ticketCountlist();
			
			
			
			
			ModelAndView model = new ModelAndView();
			
			model.addObject("tickets", tickets);
			model.setViewName("AdminDasboard");
			return model;

		}*/
		
		@RequestMapping(value = "/edit3", method = RequestMethod.GET)
		public ModelAndView ticketupdate(HttpServletRequest request) {
			int ticket_type_id = Integer.parseInt(request.getParameter("id"));
			
			ModelAndView model = new ModelAndView("TicketTypes", "ticket_type_id", ticket_type_id);
			return model;

		}
}
