package com.litara.Test2;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.litara.Test2.model.Category;
import com.litara.Test2.model.Class;
import com.litara.Test2.model.Coach;
import com.litara.Test2.model.Consist;
import com.litara.Test2.model.Passenger;
import com.litara.Test2.model.Place;
import com.litara.Test2.model.Station;
import com.litara.Test2.model.Timetable;
import com.litara.Test2.model.Train;
import com.litara.Test2.model.Type;
import com.litara.Test2.model.Way;
import com.litara.Test2.services.CategoryService;
import com.litara.Test2.services.ClassService;
import com.litara.Test2.services.CoachService;
import com.litara.Test2.services.ConsistService;
import com.litara.Test2.services.PassengerService;
import com.litara.Test2.services.PlaceService;
import com.litara.Test2.services.StationService;
import com.litara.Test2.services.TimetableService;
import com.litara.Test2.services.TrainService;
import com.litara.Test2.services.TypeService;
import com.litara.Test2.services.WayService;

@Controller

public class AdminController {
	@Autowired
	PassengerService passengerService;
	@Autowired
	TrainService trainService;
	@Autowired
	StationService stationService;
	@Autowired
	WayService wayService;
	@Autowired
	ClassService classService;
	@Autowired
	TypeService typeService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CoachService coachService;
	@Autowired
	TimetableService timetableService;
	@Autowired
	ConsistService consistService;
	@Autowired
	PlaceService placeService;
	@GetMapping("/admin")
	public ModelAndView adminMain() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-passenger")
		public ModelAndView passengerAdmin() {
			ModelAndView modelAndView = new ModelAndView();
			List<Passenger> passengers = passengerService.outputAll(); 
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Passenger passenger = passengerService.findByEmail(auth.getName());
			modelAndView.addObject("nameOfTable", "Passenger");
			modelAndView.addObject(passenger);
			modelAndView.addObject("tablePassenger", passengers);
			modelAndView.setViewName("admin");
			return modelAndView;
		}
	@PostMapping("/admin-passenger-del")
	public ModelAndView passengerAdminDel(@RequestParam String id) {
		ModelAndView modelAndView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		passengerService.del(Long.valueOf(id));
		List<Passenger> passengers = passengerService.outputAll(); 
		modelAndView.addObject("nameOfTable", "Passenger");
		modelAndView.addObject("tablePassenger",passengers);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-passenger-update")
	public ModelAndView passengerAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Passenger> passengers = passengerService.outputAll(); 
		modelAndView.addObject("nameOfTable", "Passenger");
		modelAndView.addObject("update",true);
		modelAndView.addObject("passengerUpdate",passengerService.findById(Long.valueOf(id)));
		modelAndView.addObject("tablePassenger",passengers);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;	
	}
	@PostMapping("/admin-passenger-update-true")
	public ModelAndView passengerAdminUpdateTrue(@RequestParam String id, @RequestParam String email,@RequestParam String password, @RequestParam String name, @RequestParam String surname, @RequestParam String middle_name, @RequestParam String active, @RequestParam String role) {
		ModelAndView modelAndView=new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Passenger> passengers = passengerService.outputAll(); 
		Passenger passengerUpdate = new Passenger();
		passengerUpdate.setEmail(email);
		passengerUpdate.setPassword(password);
		passengerUpdate.setRole(role);
		passengerUpdate.setId(Long.valueOf(id));
		passengerUpdate.setMiddle_name(middle_name);
		passengerUpdate.setName(name);
		passengerUpdate.setSurname(surname);
		passengerUpdate.setActive(1);
		passengerService.update(passengerUpdate);
		modelAndView.addObject("nameOfTable", "Passenger");
		modelAndView.addObject("tablePassenger",passengers);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-passenger-create")
	public ModelAndView createPassenger(@RequestParam String email, @RequestParam String password, @RequestParam String name, @RequestParam String surname, @RequestParam String middle_name) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Passenger passengerCreate = new Passenger();
		passengerCreate.setEmail(email);
		passengerCreate.setPassword(password);
		passengerCreate.setMiddle_name(middle_name);
		passengerCreate.setName(name);
		passengerCreate.setSurname(surname);
		passengerService.saveUser(passengerCreate);
		List<Passenger> passengers = passengerService.outputAll(); 
		modelAndView.addObject("nameOfTable", "Passenger");
		modelAndView.addObject("tablePassenger",passengers);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-train")
	public ModelAndView trainAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Train> trains = trainService.outputAll();
		modelAndView.addObject("nameOfTable","Train");
		modelAndView.addObject("tableTrain", trains);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-train-create")
	public ModelAndView createTrain(@RequestParam String name, @RequestParam String date_start, @RequestParam String date_stop) {
		ModelAndView modelAndView = new ModelAndView();
		Train train=new Train();
		train.setName(name);
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		try {
			train.setDate_start(format.parse(date_start));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			train.setDate_stop(format.parse(date_stop));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trainService.saveTrain(train);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Train> trains = trainService.outputAll();
		modelAndView.addObject("nameOfTable","Train");
		modelAndView.addObject("tableTrain", trains);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-train-del")
	public ModelAndView trainAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		trainService.del(Long.valueOf(id));
		List<Train> trains = trainService.outputAll();
		modelAndView.addObject("nameOfTable","Train");
		modelAndView.addObject("tableTrain", trains);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-train-update")
	public ModelAndView trainAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		modelAndView.addObject("trainUpdate", trainService.findById(Long.valueOf(id)));
		List<Train> trains = trainService.outputAll();
		modelAndView.addObject("update", true);
		modelAndView.addObject("nameOfTable","Train");
		modelAndView.addObject("tableTrain", trains);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-train-update-true")
	public ModelAndView trainAdminUpdateTrue(@RequestParam String id, @RequestParam String name, @RequestParam String date_start,@RequestParam String date_stop) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Train trainUpdate= new Train();
		List<Train> trains = trainService.outputAll();
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		trainUpdate.setId(Long.valueOf(id));
		trainUpdate.setName(name);
		try {
			trainUpdate.setDate_start(format.parse(date_start));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			trainUpdate.setDate_stop(format.parse(date_stop));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trainService.saveTrain(trainUpdate);
		modelAndView.addObject("nameOfTable","Train");
		modelAndView.addObject("tableTrain", trains);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-station")
	public ModelAndView stationAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Station> stations = stationService.outputAll();
		modelAndView.addObject("nameOfTable","Station");
		modelAndView.addObject("tableStation", stations);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-station-create")
	public ModelAndView stationAdminCreate(@RequestParam String name, @RequestParam String country, @RequestParam String region) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Station stationCreate = new Station();
		stationCreate.setName(name);
		stationCreate.setCountry(country);
		stationCreate.setRegion(region);
		stationService.saveStation(stationCreate);
		List<Station> stations = stationService.outputAll(); 
		modelAndView.addObject("nameOfTable", "Station");
		modelAndView.addObject("tableStation",stations);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-station-del")
	public ModelAndView stationAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		stationService.del(Long.valueOf(id));
		List<Station> stations = stationService.outputAll();
		modelAndView.addObject("nameOfTable","Station");
		modelAndView.addObject("tableStation", stations);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-station-update")
	public ModelAndView stationAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Station> stations = stationService.outputAll();
		Station stationUpdate = stationService.findById(Long.valueOf(id));
		modelAndView.addObject("stationUpdate",stationUpdate);
		modelAndView.addObject("update",true);
		modelAndView.addObject("nameOfTable","Station");
		modelAndView.addObject("tableStation", stations);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-station-update-true")
	public ModelAndView stationAdminUpdateTrue(@RequestParam String id, @RequestParam String name, @RequestParam String country, @RequestParam String region) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Station stationUpdate = new Station();
		stationUpdate.setId(Long.valueOf(id));
		stationUpdate.setName(name);
		stationUpdate.setCountry(country);
		stationUpdate.setRegion(region);
		stationService.saveStation(stationUpdate);
		List<Station> stations = stationService.outputAll();
		modelAndView.addObject("nameOfTable","Station");
		modelAndView.addObject("tableStation", stations);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-way")
	public ModelAndView wayAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Way> ways = wayService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listTrain",trains);
		modelAndView.addObject("nameOfTable","Way");
		modelAndView.addObject("tableWay", ways);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-way-create")
	public ModelAndView wayAdminCreate(@RequestParam String station_id, @RequestParam String train_id, @RequestParam String start_time, @RequestParam String end_time) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Way wayCreate=new Way();
		wayCreate.setStation(stationService.findById(Long.valueOf(station_id)));
		wayCreate.setTrain(trainService.findById(Long.valueOf(train_id)));
		
		wayCreate.setStart_time(Time.valueOf(start_time+":00"));
		wayCreate.setEnd_time(Time.valueOf(end_time+":00"));
		wayService.saveWay(wayCreate);
		List<Way> ways = wayService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listTrain",trains);
		modelAndView.addObject("nameOfTable","Way");
		modelAndView.addObject("tableWay", ways);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-way-del")
	public ModelAndView wayAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		wayService.del(Long.valueOf(id));
		List<Way> ways = wayService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listTrain",trains);
		modelAndView.addObject("nameOfTable","Way");
		modelAndView.addObject("tableWay", ways);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-way-update")
	public ModelAndView wayAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Way wayUpdate = wayService.findById(Long.valueOf(id));
		List<Way> ways = wayService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("update", true);
		modelAndView.addObject("wayUpdate", wayUpdate);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listTrain",trains);
		modelAndView.addObject("nameOfTable","Way");
		modelAndView.addObject("tableWay", ways);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-way-update-true")
	public ModelAndView wayAdminUpdateTrue(@RequestParam String id, @RequestParam String station_id, @RequestParam String train_id,@RequestParam String start_time,@RequestParam String end_time) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Way wayUpdate = new Way();
		wayUpdate.setId(Long.valueOf(id));
		wayUpdate.setStation(stationService.findById(Long.valueOf(station_id)));
		wayUpdate.setTrain(trainService.findById(Long.valueOf(train_id)));
		wayUpdate.setStart_time(Time.valueOf(start_time));
		wayUpdate.setEnd_time(Time.valueOf(end_time));
		wayService.saveWay(wayUpdate);
		List<Way> ways = wayService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listTrain",trains);
		modelAndView.addObject("nameOfTable","Way");
		modelAndView.addObject("tableWay", ways);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-category")
	public ModelAndView categoryAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Category> categories = categoryService.outputAll();
		modelAndView.addObject("nameOfTable","Category");
		modelAndView.addObject("tableCategory", categories);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-category-create")
	public ModelAndView categoryAdminCreate(@RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Category categoryCreate = new Category();
		categoryCreate.setName(name);
		categoryService.saveCategory(categoryCreate);
		List<Category> categories = categoryService.outputAll();
		modelAndView.addObject("nameOfTable","Category");
		modelAndView.addObject("tableCategory", categories);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-category-del")
	public ModelAndView categoryAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		categoryService.del(Long.valueOf(id));
		List<Category> categories = categoryService.outputAll();
		modelAndView.addObject("nameOfTable","Category");
		modelAndView.addObject("tableCategory", categories);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-category-update")
	public ModelAndView categoryAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Category categoryUpdate = categoryService.findById(Long.valueOf(id));
		List<Category> categories = categoryService.outputAll();
		modelAndView.addObject("categoryUpdate", categoryUpdate);
		modelAndView.addObject("update",true);
		modelAndView.addObject("nameOfTable","Category");
		modelAndView.addObject("tableCategory", categories);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-category-update-true")
	public ModelAndView categoryAdminUpdateTrue(@RequestParam String id, @RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Category categoryUpdate = new Category();
		categoryUpdate.setId(Long.valueOf(id));
		categoryUpdate.setName(name);
		categoryService.saveCategory(categoryUpdate);
		List<Category> categories = categoryService.outputAll();
		modelAndView.addObject("nameOfTable","Category");
		modelAndView.addObject("tableCategory", categories);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-class")
	public ModelAndView classAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<com.litara.Test2.model.Class> classes = classService.outputAll();
		modelAndView.addObject("nameOfTable","Class");
		modelAndView.addObject("tableClass", classes);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-class-create")
	public ModelAndView classAdminCreate(@RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Class classCreate = new Class();
		classCreate.setName(name);
		classService.saveClass(classCreate);
		List<com.litara.Test2.model.Class> classes = classService.outputAll();
		modelAndView.addObject("nameOfTable","Class");
		modelAndView.addObject("tableClass", classes);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-class-del")
	public ModelAndView classAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		classService.del(Long.valueOf(id));
		List<com.litara.Test2.model.Class> classes = classService.outputAll();
		modelAndView.addObject("nameOfTable","Class");
		modelAndView.addObject("tableClass", classes);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-class-update")
	public ModelAndView classAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Class classUpdate = classService.findById(Long.valueOf(id));
		List<com.litara.Test2.model.Class> classes = classService.outputAll();
		modelAndView.addObject("classUpdate", classUpdate);
		modelAndView.addObject("update",true);
		modelAndView.addObject("nameOfTable","Class");
		modelAndView.addObject("tableClass", classes);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-class-update-true")
	public ModelAndView classAdminUpdateTrue(@RequestParam String id, @RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Class classUpdate = new Class();
		classUpdate.setId(Long.valueOf(id));
		classUpdate.setName(name);
		classService.saveClass(classUpdate);
		List<com.litara.Test2.model.Class> classes = classService.outputAll();
		modelAndView.addObject("nameOfTable","Class");
		modelAndView.addObject("tableClass", classes);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-type")
	public ModelAndView typeAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Type> types = typeService.outputAll();
		modelAndView.addObject("nameOfTable","Type");
		modelAndView.addObject("tableType", types);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-type-create")
	public ModelAndView typeAdminCreate(@RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Type typeCreate = new Type();
		typeCreate.setName(name);
		typeService.saveType(typeCreate);
		List<Type> types = typeService.outputAll();
		modelAndView.addObject("nameOfTable","Type");
		modelAndView.addObject("tableType", types);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-type-del")
	public ModelAndView typeAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		typeService.del(Long.valueOf(id));
		List<Type> types = typeService.outputAll();
		modelAndView.addObject("nameOfTable","Type");
		modelAndView.addObject("tableType", types);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-type-update")
	public ModelAndView typeAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Type typeUpdate = typeService.findById(Long.valueOf(id));
		List<Type> types = typeService.outputAll();
		modelAndView.addObject("typeUpdate", typeUpdate);
		modelAndView.addObject("update",true);
		modelAndView.addObject("nameOfTable","Type");
		modelAndView.addObject("tableType", types);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-type-update-true")
	public ModelAndView typeAdminUpdateTrue(@RequestParam String id, @RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Type typeUpdate = new Type();
		typeUpdate.setId(Long.valueOf(id));
		typeUpdate.setName(name);
		typeService.saveType(typeUpdate);
		List<Type> types = typeService.outputAll();
		modelAndView.addObject("nameOfTable","Type");
		modelAndView.addObject("tableType", types);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-coach")
	public ModelAndView coachAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Coach> coachs = coachService.outputAll();
		List<Type> types = typeService.outputAll();
		List<Class> classes=classService.outputAll();
		List<Category> categories=categoryService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listType", types);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listCategory", categories);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listClass", classes);
		modelAndView.addObject("nameOfTable","Coach");
		modelAndView.addObject("tableCoach", coachs);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-coach-create")
	public ModelAndView coachAdminCreate(@RequestParam String type_coach_id, @RequestParam String category_coach_id, @RequestParam String class_coach_id, @RequestParam String station_id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Coach coachCreate = new Coach();
		coachCreate.setCategory(categoryService.findById(Long.valueOf(category_coach_id)));
		coachCreate.setType(typeService.findById(Long.valueOf(type_coach_id)));
		coachCreate.setClassCoach(classService.findById(Long.valueOf(class_coach_id)));
		coachCreate.setStationOrder(stationService.findById(Long.valueOf(station_id)));
		coachService.saveCoach(coachCreate);
		List<Coach> coachs = coachService.outputAll();
		List<Type> types = typeService.outputAll();
		List<Class> classes=classService.outputAll();
		List<Category> categories=categoryService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listType", types);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listCategory", categories);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listClass", classes);
		modelAndView.addObject("nameOfTable","Coach");
		modelAndView.addObject("tableCoach", coachs);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-coach-del")
	public ModelAndView coachAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		coachService.del(Long.valueOf(id));
		List<Coach> coachs = coachService.outputAll();
		List<Type> types = typeService.outputAll();
		List<Class> classes=classService.outputAll();
		List<Category> categories=categoryService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listType", types);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listCategory", categories);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listClass", classes);
		modelAndView.addObject("nameOfTable","Coach");
		modelAndView.addObject("tableCoach", coachs);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-coach-update")
	public ModelAndView coachAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Coach coachUpdate = coachService.findById(Long.valueOf(id));
		List<Coach> coachs = coachService.outputAll();
		List<Type> types = typeService.outputAll();
		List<Class> classes=classService.outputAll();
		List<Category> categories=categoryService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("coachUpdate", coachUpdate);
		modelAndView.addObject("update", true);
		modelAndView.addObject("listType", types);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listCategory", categories);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listClass", classes);
		modelAndView.addObject("nameOfTable","Coach");
		modelAndView.addObject("tableCoach", coachs);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-coach-update-true")
	public ModelAndView coachAdminUpdateTrue(@RequestParam String id, @RequestParam String type_coach_id, @RequestParam String class_coach_id, @RequestParam String category_coach_id, @RequestParam String station_id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Coach coachUpdate = new Coach();
		coachUpdate.setId(Long.valueOf(id));
		coachUpdate.setType(typeService.findById(Long.valueOf(type_coach_id)));
		coachUpdate.setCategory(categoryService.findById(Long.valueOf(category_coach_id)));
		coachUpdate.setClassCoach(classService.findById(Long.valueOf(class_coach_id)));
		coachUpdate.setStationOrder(stationService.findById(Long.valueOf(station_id)));
		coachService.saveCoach(coachUpdate);
		List<Coach> coachs = coachService.outputAll();
		List<Type> types = typeService.outputAll();
		List<Class> classes=classService.outputAll();
		List<Category> categories=categoryService.outputAll();
		List<Station> stations=stationService.outputAll();
		modelAndView.addObject("listType", types);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listCategory", categories);
		modelAndView.addObject("listStation", stations);
		modelAndView.addObject("listClass", classes);
		modelAndView.addObject("nameOfTable","Coach");
		modelAndView.addObject("tableCoach", coachs);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-timetable")
	public ModelAndView timetableAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Way> ways = wayService.outputAll();
		List<Timetable> timetables = timetableService.outputAll();
		modelAndView.addObject("listWay", ways);
		modelAndView.addObject("nameOfTable","Timetable");
		modelAndView.addObject("tableTimetable", timetables);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-timetable-create")
	public ModelAndView timetableAdminCreate(@RequestParam String way_id, @RequestParam String date) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		Timetable timetableCreate = new Timetable();
		try {
			timetableCreate.setDate(format.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timetableCreate.setWay(wayService.findById(Long.valueOf(way_id)));
		timetableService.saveTimetable(timetableCreate);
		List<Way> ways = wayService.outputAll();
		List<Timetable> timetables = timetableService.outputAll();
		modelAndView.addObject("listWay", ways);
		modelAndView.addObject("nameOfTable","Timetable");
		modelAndView.addObject("tableTimetable", timetables);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-timetable-del")
	public ModelAndView timetableAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		timetableService.del(Long.valueOf(id));
		List<Way> ways = wayService.outputAll();
		List<Timetable> timetables = timetableService.outputAll();
		modelAndView.addObject("listWay", ways);
		modelAndView.addObject("nameOfTable","Timetable");
		modelAndView.addObject("tableTimetable", timetables);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-timetable-update")
	public ModelAndView timetableAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Timetable timetableUpdate = timetableService.findById(Long.valueOf(id));
		List<Way> ways = wayService.outputAll();
		List<Timetable> timetables = timetableService.outputAll();
		modelAndView.addObject("update",true);
		modelAndView.addObject("timetableUpdate", timetableUpdate);
		modelAndView.addObject("listWay", ways);
		modelAndView.addObject("nameOfTable","Timetable");
		modelAndView.addObject("tableTimetable", timetables);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-timetable-update-true")
	public ModelAndView timetableAdminUpdateTrue(@RequestParam String id, @RequestParam String way_id, @RequestParam String date) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Timetable timetableUpdate = new Timetable();
		timetableUpdate.setId(Long.valueOf(id));
		timetableUpdate.setWay(wayService.findById(Long.valueOf(way_id)));
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		try {
			timetableUpdate.setDate(format.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timetableService.saveTimetable(timetableUpdate);
		List<Way> ways = wayService.outputAll();
		List<Timetable> timetables = timetableService.outputAll();
		modelAndView.addObject("listWay", ways);
		modelAndView.addObject("nameOfTable","Timetable");
		modelAndView.addObject("tableTimetable", timetables);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-consist")
	public ModelAndView consistAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Station> stations = stationService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Consist> consists = consistService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listTrain", trains);
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("listStationStart", stations);
		modelAndView.addObject("listStationEnd", stations);
		modelAndView.addObject("nameOfTable","Consist");
		modelAndView.addObject("tableConsist", consists);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-consist-create")
	public ModelAndView consistAdminCreate(@RequestParam String train_id, @RequestParam String coach_id, @RequestParam String number_in_consist, @RequestParam String station_id_start, @RequestParam String station_id_end) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Consist consistCreate = new Consist();
		consistCreate.setNumber_in_consist(Integer.valueOf(number_in_consist));
		consistCreate.setCoachConsist(coachService.findById(Long.valueOf(coach_id)));
		consistCreate.setTrainConsist(trainService.findById(Long.valueOf(train_id)));
		consistCreate.setStationConsistStart(stationService.findById(Long.valueOf(station_id_start)));
		consistCreate.setStationConsistEnd(stationService.findById(Long.valueOf(station_id_end)));
		consistService.saveConsist(consistCreate);
		List<Station> stations = stationService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Consist> consists = consistService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listTrain", trains);
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("listStationStart", stations);
		modelAndView.addObject("listStationEnd", stations);
		modelAndView.addObject("nameOfTable","Consist");
		modelAndView.addObject("tableConsist", consists);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-consist-del")
	public ModelAndView consistAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		consistService.del(Long.valueOf(id));
		List<Station> stations = stationService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Consist> consists = consistService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listTrain", trains);
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("listStationStart", stations);
		modelAndView.addObject("listStationEnd", stations);
		modelAndView.addObject("nameOfTable","Consist");
		modelAndView.addObject("tableConsist", consists);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-consist-update")
	public ModelAndView consistAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Consist consistUpdate = consistService.findById(Long.valueOf(id));
		List<Station> stations = stationService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Consist> consists = consistService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("update", true);
		modelAndView.addObject("consistUpdate", consistUpdate);
		modelAndView.addObject("listTrain", trains);
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("listStationStart", stations);
		modelAndView.addObject("listStationEnd", stations);
		modelAndView.addObject("nameOfTable","Consist");
		modelAndView.addObject("tableConsist", consists);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-consist-update-true")
	public ModelAndView consistAdminUpdateTrue(@RequestParam String id, @RequestParam String train_id, @RequestParam String coach_id, @RequestParam String number_in_consist, @RequestParam String station_id_start, @RequestParam String station_id_end) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Consist consistUpdate = consistService.findById(Long.valueOf(id));
		consistUpdate.setNumber_in_consist(Integer.valueOf(number_in_consist));
		consistUpdate.setCoachConsist(coachService.findById(Long.valueOf(coach_id)));
		consistUpdate.setTrainConsist(trainService.findById(Long.valueOf(train_id)));
		consistUpdate.setStationConsistStart(stationService.findById(Long.valueOf(station_id_start)));
		consistUpdate.setStationConsistEnd(stationService.findById(Long.valueOf(station_id_end)));
		consistService.saveConsist(consistUpdate);
		List<Station> stations = stationService.outputAll();
		List<Train> trains = trainService.outputAll();
		List<Consist> consists = consistService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listTrain", trains);
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("listStationStart", stations);
		modelAndView.addObject("listStationEnd", stations);
		modelAndView.addObject("nameOfTable","Consist");
		modelAndView.addObject("tableConsist", consists);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@GetMapping("/admin-place")
	public ModelAndView placeAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		List<Place> places=placeService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("nameOfTable","Place");
		modelAndView.addObject("tablePlace", places);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-place-create")
	public ModelAndView placeAdminCreate(@RequestParam String coach_id, @RequestParam String number, @RequestParam String type) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Place placeCreate = new Place();
		placeCreate.setCoachPlace(coachService.findById(Long.valueOf(coach_id)));
		placeCreate.setNumber(Integer.valueOf(number));
		placeCreate.setType(type);
		placeService.savePlace(placeCreate);
		List<Place> places=placeService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("nameOfTable","Place");
		modelAndView.addObject("tablePlace", places);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-place-del")
	public ModelAndView placeAdminDel(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		placeService.del(Long.valueOf(id));
		List<Place> places=placeService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("nameOfTable","Place");
		modelAndView.addObject("tablePlace", places);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-place-update")
	public ModelAndView placeAdminUpdate(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Place placeUpdate = placeService.findById(Long.valueOf(id));
		List<Place> places=placeService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("update", true);
		modelAndView.addObject("placeUpdate", placeUpdate);
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("nameOfTable","Place");
		modelAndView.addObject("tablePlace", places);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	@PostMapping("/admin-place-update-true")
	public ModelAndView placeAdminUpdateTrue(@RequestParam String id, @RequestParam String coach_id, @RequestParam String number, @RequestParam String type) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Passenger passenger = passengerService.findByEmail(auth.getName());
		Place placeCreate = new Place();
		placeCreate.setId(Long.valueOf(id));
		placeCreate.setCoachPlace(coachService.findById(Long.valueOf(coach_id)));
		placeCreate.setNumber(Integer.valueOf(number));
		placeCreate.setType(type);
		placeService.savePlace(placeCreate);
		List<Place> places=placeService.outputAll();
		List<Coach> coachs=coachService.outputAll();
		modelAndView.addObject("listCoach", coachs);
		modelAndView.addObject("nameOfTable","Place");
		modelAndView.addObject("tablePlace", places);
		modelAndView.addObject(passenger);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
}
