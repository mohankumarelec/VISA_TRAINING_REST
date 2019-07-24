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

import com.visa.RestHotelApi.entity.Hotel;
import com.visa.RestHotelApi.service.HotelService;

@RestController
@RequestMapping("hotel")
public class HotelController {
	@Autowired
	private HotelService service;


	@GetMapping
	public @ResponseBody List<Hotel> getHotels(@RequestParam(name = "category", required = false) String category) {
		if (category == null) {
			return service.getHotels();
		} else {
			return service.getHotelByCriteria(category);
		}
	}

	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel o) {
		service.addHotel(o);
		return new ResponseEntity<>(o, HttpStatus.CREATED);
	}
}
