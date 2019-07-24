package com.visa.RestHotelApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.RestHotelApi.dao.UserDao;
import com.visa.RestHotelApi.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Transactional
	public void addUser(User u) {
		userDao.save(u);
	}

	@Transactional
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Transactional
	public List<User> getUsersById(String email) {
		return userDao.findByEmail(email);
	}

}
