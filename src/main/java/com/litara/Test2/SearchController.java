package com.litara.Test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.litara.Test2.search.Formating;
import com.litara.Test2.search.ResponseBodyCategory;
import com.litara.Test2.search.ResponseBodyClass;
import com.litara.Test2.search.ResponseBodyPassenger;
import com.litara.Test2.search.ResponseBodyStation;
import com.litara.Test2.search.ResponseBodyTrain;
import com.litara.Test2.search.ResponseBodyType;
import com.litara.Test2.search.ResponseBodyWay;
import com.litara.Test2.services.CategoryService;
import com.litara.Test2.services.ClassService;
import com.litara.Test2.services.PassengerService;
import com.litara.Test2.services.StationService;
import com.litara.Test2.services.TrainService;
import com.litara.Test2.services.TypeService;
import com.litara.Test2.services.WayService;

@Controller
public class SearchController {
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
	@PostMapping("/search-admin-passenger")
	public ResponseEntity<?> searchPassenger(@RequestParam String name) {
		ResponseBodyPassenger result = new ResponseBodyPassenger();
		result.setResult(passengerService.findByNameLike(name));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
	@PostMapping("/search-admin-train")
	public ResponseEntity<?> searchTrain(@RequestParam String name) {
		ResponseBodyTrain result = new ResponseBodyTrain();
		result.setResult(Formating.formatingTrain(trainService.findByNameLike(name)));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
	@PostMapping("/search-admin-station")
	public ResponseEntity<?> searchStation(@RequestParam String name) {
		ResponseBodyStation result = new ResponseBodyStation();
		result.setResult(Formating.formatingStation(stationService.findByNameLike(name)));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
	@PostMapping("/search-admin-way")
	public ResponseEntity<?> searchWay(@RequestParam String name) {
		ResponseBodyWay result = new ResponseBodyWay();
		result.setResult(Formating.formatingWay(wayService.findByTrainName(name)));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
	@PostMapping("/search-admin-class")
	public ResponseEntity<?> searchClass(@RequestParam String name) {
		ResponseBodyClass result = new ResponseBodyClass();
		result.setResult(Formating.formatingClass(classService.findByNameLike(name)));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
	@PostMapping("/search-admin-type")
	public ResponseEntity<?> searchType(@RequestParam String name) {
		ResponseBodyType result = new ResponseBodyType();
		result.setResult(Formating.formatingType(typeService.findByNameLike(name)));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
	@PostMapping("/search-admin-category")
	public ResponseEntity<?> searchCategory(@RequestParam String name) {
		ResponseBodyCategory result = new ResponseBodyCategory();
		result.setResult(Formating.formatingCategory(categoryService.findByNameLike(name)));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
}
