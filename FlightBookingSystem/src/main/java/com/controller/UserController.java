package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Booking;
import com.model.BookingDAO;
import com.model.Flight;
import com.model.FlightDAO;
import com.model.Payment;
import com.model.PaymentDAO;
import com.model.User;
import com.model.UserDAO;

@RestController
public class UserController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	FlightDAO flightDAO;
	
	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	PaymentDAO paymentDAO;
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {
		userDAO.save(user);
		return "User added successfully";
	}
	
	@PatchMapping("/modifyuser")
	public String modifyUser(@RequestBody User user) {
		userDAO.save(user);
		return "user updated";
	}
	
	@DeleteMapping("/deleteuser")
	public String deleteUser(@RequestBody User user) {
		userDAO.delete(user);
		return "user deleted";
	}
	
	@GetMapping("/searchflight/{id}")
	public Optional<Flight> searchFlight(@PathVariable int id){
		return flightDAO.findById(id);
	}
	
	@GetMapping("/viewschedule")
	public Iterable<Flight> viewSchedule(){
		return flightDAO.findAll();
	}
	
	@PostMapping("/bookticket")
	public boolean bookTicket(@RequestBody Booking b) {
		bookingDAO.save(b);
		
		return true;
	}
	@PostMapping("/purchaseticket")
	public String purchaseTicket(@RequestBody Payment p) {
		paymentDAO.save(p);
		return "Ticket Purchased";
	}
	@DeleteMapping("/cancelticket")
	public String cancelTicket(@RequestBody Booking b) {
		bookingDAO.delete(b);
		return "Ticket Cancelled";
	}
}
