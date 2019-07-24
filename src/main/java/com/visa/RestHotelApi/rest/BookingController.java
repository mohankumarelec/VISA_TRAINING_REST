package com.visa.RestHotelApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.RestHotelApi.entity.Booking;
import com.visa.RestHotelApi.service.BookingService;
import com.visa.RestHotelApi.service.UserService;

@RestController
@RequestMapping("booking")
public class BookingController {
	@Autowired
	private BookingService service;

	@Autowired
	private UserService userservice;

	@GetMapping
	public @ResponseBody List<Booking> getBookings(@RequestParam(name = "user", required = false) String email) {
		if (email == null) {
			return service.getBookings();
		} else {
			return service.getBookingsByUser(userservice.getUsersById(email).get(0));
		}
	}

	@PostMapping
	public ResponseEntity<Booking> addHotel(@RequestBody Booking b) {
		service.addBooking(b);
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}
}
