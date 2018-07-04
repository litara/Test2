package com.litara.Test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.litara.Test2.search.ResponseBodyPassenger;
import com.litara.Test2.services.PassengerService;

@Controller
public class SearchController {
	@Autowired
	PassengerService passengerService;
	@PostMapping("/search-admin")
	public ResponseEntity<?> searchPassenger(@RequestParam String name) {
		ResponseBodyPassenger result = new ResponseBodyPassenger();
		result.setResult(passengerService.findByNameLike(name));
		if(result.getResult().isEmpty()) {
			result.setMsg("Error, not passenger found");
		}
		result.setMsg("Success");
		return ResponseEntity.ok(result);
	}
}
