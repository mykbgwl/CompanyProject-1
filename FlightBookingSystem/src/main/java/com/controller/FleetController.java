package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Fleet;
import com.model.FleetDAO;

@RestController
public class FleetController {
	@Autowired
	FleetDAO fleetDAO;
	@PostMapping("/addfleet")
	public String addFleet(@RequestBody Fleet f) {
		fleetDAO.save(f);
		return "flight added";
	}
	@DeleteMapping("/deletefleet")
	public String deleteFleet(@RequestBody Fleet f) {
		fleetDAO.delete(f);
		return "flight cancelled.";
	}
	@PatchMapping("/modifyfleet")
	public String modifyFleet(@RequestBody Fleet f) {
		fleetDAO.save(f);
		return "fleet modified";
	}

}