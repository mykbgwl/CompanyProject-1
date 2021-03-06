package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.LocationNotFoundException;
import com.model.Location;
import com.model.LocationDAO;


@RestController
public class LocationController {
	@Autowired
	LocationDAO locationDAO;
	@PostMapping("/addlocation")
	public String addLocation(@RequestBody Location l) {
		locationDAO.save(l);
		return "location added";
	}
	@DeleteMapping("/deletelocation/{id}")
	public String deleteLocation(@PathVariable int id) {
		locationDAO.deleteById(id);
		return "Location deleted.";
	}
	@PatchMapping("/modifylocation")
	public String modifyLocation(@RequestBody Location l) {
		Optional<Location> opt=locationDAO.findById(l.getId());
		if(!opt.isPresent()) {
			throw new LocationNotFoundException();
		}
		locationDAO.save(l);
		return "location modified";
	}


}