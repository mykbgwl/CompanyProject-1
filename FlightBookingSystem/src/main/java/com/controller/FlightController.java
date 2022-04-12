package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.UserNotFoundException;
import com.model.Flight;
import com.model.FlightDAO;
import com.model.User;

@RestController
public class FlightController {
	@Autowired
	FlightDAO flightDAO;
	@PostMapping("/addflight")
	public String addFlight(@RequestBody Flight f) {
		flightDAO.save(f);
		return "flight added";
	}
	@DeleteMapping("/deleteflight/{id}")
	public String deleteFlight(@PathVariable int id) {
		flightDAO.deleteById(id);
		return "flight cancelled";
		
	}
	@PatchMapping("/modifyflight")
	public String modifyFlight(@RequestBody Flight f) {
		flightDAO.save(f);
		return "flight modified";
	}

}