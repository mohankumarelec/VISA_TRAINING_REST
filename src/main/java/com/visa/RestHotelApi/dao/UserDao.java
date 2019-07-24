package com.visa.RestHotelApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.RestHotelApi.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);
	
}
