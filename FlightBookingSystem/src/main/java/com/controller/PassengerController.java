package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.model.Passenger;
import com.model.PassengerDAO;

public class PassengerController {
	
	@Autowired
	PassengerDAO passengerDAO;
	
	@PostMapping("/addpassenger")
	public String addPassenger(@RequestBody Passenger p) {
		passengerDAO.save(p);
		return "passenger added";
	}
}
