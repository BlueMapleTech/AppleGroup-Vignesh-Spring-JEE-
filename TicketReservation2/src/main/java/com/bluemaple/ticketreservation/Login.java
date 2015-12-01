package com.bluemaple.ticketreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.ticketreservation.model.User;
import com.bluemaple.ticketreservation.service.LoginServiceInterface;

@Controller
public class Login {
	@Autowired
	LoginServiceInterface loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user) throws Exception {

		ModelAndView model = new ModelAndView();
		/*if(user == null){
			String msg = "error username or password error";
			model.addObject("msg", msg);
			model.setViewName("Login");
		}*/
		User user1 = loginService.login(user);

		if (user1.getUser_role() == 1) {
			String msg = "userlogin";
			model.setViewName("UserDashboard");
			model.addObject("msg", msg);
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
