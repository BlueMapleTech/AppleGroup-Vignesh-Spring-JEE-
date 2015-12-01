package com.bluemaple.ticketreservation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.bluemaple.ticketreservation.model.User;
import com.bluemaple.ticketreservation.service.UserServiceInterface;


@Controller
public class UserController {
	@Autowired
UserServiceInterface userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView value() {
		ModelAndView model = new ModelAndView("UserRegistration");
		return model;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView userregister(@ModelAttribute User user) throws IOException {

		userService.register(user);

		String msg = "register sucessfully";

		return new ModelAndView("Login", "msg", msg);

	}
}
