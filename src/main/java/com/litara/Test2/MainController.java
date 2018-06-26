package com.litara.Test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.litara.Test2.model.Passenger;
import com.litara.Test2.services.PassengerService;

@Controller
public class MainController {
	@Autowired
	private PassengerService passengerService;
	@PostMapping(path="/login")
	public ModelAndView login(@RequestParam String email, @RequestParam String password) {
		ModelAndView modelAndView = new ModelAndView();
		Passenger passenger = passengerService.findByEmailAndPassword(email, password);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("main");
		return modelAndView;
	}
	@GetMapping(path="/registration")
	public ModelAndView registrationGet() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}
	@PostMapping(path="/registration")
	public ModelAndView registrationPost(@RequestParam String name, @RequestParam String surname, @RequestParam String middle_name, @RequestParam String email, @RequestParam String password) {
		Passenger passenger = new Passenger();
		passenger.setName(name);
		passenger.setSurname(surname);
		passenger.setMiddle_name(middle_name);
		passenger.setEmail(email);
		passenger.setPassword(password);
		passengerService.saveUser(passenger);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(passenger);
		modelAndView.setViewName("main");
		return modelAndView;
	}
	@GetMapping(path= {"/main","/"})
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		if(passenger == null) {
			modelAndView.setViewName("main");
			return modelAndView;
		}
		modelAndView.addObject(passenger);
		modelAndView.setViewName("main");
		return modelAndView;
	}
}
