package com.litara.Test2;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.litara.Test2.model.Passenger;
import com.litara.Test2.model.Station;
import com.litara.Test2.model.Timetable;
import com.litara.Test2.model.Train;
import com.litara.Test2.model.Way;
import com.litara.Test2.services.PassengerService;
import com.litara.Test2.services.StationService;
import com.litara.Test2.services.TimetableService;
import com.litara.Test2.services.TrainService;

@Controller
public class MainController {
	@Autowired
	private PassengerService passengerService;
	@Autowired
	private StationService stationService;
	@Autowired
	private TimetableService timetableService;
	@Autowired
	private TrainService trainService;
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
	@PostMapping("/search")
	public ModelAndView search(@RequestParam String stationStart, @RequestParam String stationEnd, @RequestParam String date) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		List<Timetable> timetable=timetableService.outputAll();
		List<Timetable> timetableResult=new ArrayList<Timetable>();
		Timestamp timestamp = new Timestamp(1502041448453l);
		LocalDate localDateTime = timestamp.toLocalDateTime().toLocalDate();
		LocalDate now = LocalDate.now();
		if(date=="") date=now.toString();
		for(Timetable i: timetable) {
			try {
				if(i.getDate().compareTo(format.parse(date))==0) {
					timetableResult.add(i);
					System.out.println("true");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Station stationBegin = stationService.findByName(stationStart);
		Station stationStop = stationService.findByName(stationEnd);
		List<Way> wayResultStart=new ArrayList<Way>();
		List<Way> wayResultStop=new ArrayList<Way>();
		for(Timetable i: timetableResult) {
			if(i.getWay().getStation().getId()==stationBegin.getId()) {
				System.out.println("start:" +i.getWay().getStation().getName());
				wayResultStart.add(i.getWay());
			}
			if(i.getWay().getStation().getId()==stationStop.getId()) {
				System.out.println("stop: "+i.getWay().getStation().getName());
				wayResultStop.add(i.getWay());
			}
		}
		List<Train> trainResult = new ArrayList<Train>();
		for(Way i: wayResultStart) {
			for(Way j: wayResultStop) {
				if(i.getTrain().getId()==j.getTrain().getId()) {
					System.out.println(i.getStationTrain());
					trainResult.add(i.getTrain());
				}
			}
		}
		modelAndView.addObject("date",date);
		modelAndView.addObject("wayStart",wayResultStart);
		modelAndView.addObject("wayStop",wayResultStop);
		modelAndView.addObject("trainResult",trainResult);
		if(passenger!=null) {
			modelAndView.addObject(passenger);
		}
		modelAndView.setViewName("main");
		modelAndView.addObject("search",true);
		return modelAndView;
	}
	@PostMapping("/more")
	public ModelAndView moreAboutTrain(@RequestParam String train_id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Train train=trainService.findById(Long.valueOf(train_id));
		modelAndView.addObject("train",train);
		Set<Way> usortedways=train.getSetWay();
		Set<Way> sortedways=new TreeSet<Way>(Way.COMPARE_BY_START_TIME);
		sortedways.addAll(usortedways);
		modelAndView.addObject("ways",sortedways);
		if(passenger!=null) {
			modelAndView.addObject(passenger);
		}
		modelAndView.setViewName("more");
		modelAndView.addObject("search",true);
		return modelAndView;
	}
}
