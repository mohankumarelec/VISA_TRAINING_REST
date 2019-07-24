package com.visa.RestHotelApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.RestHotelApi.entity.User;
import com.visa.RestHotelApi.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping
	public @ResponseBody List<User> getHotelss() {
		return service.getUsers();
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User u) {
		service.addUser(u);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}

}
