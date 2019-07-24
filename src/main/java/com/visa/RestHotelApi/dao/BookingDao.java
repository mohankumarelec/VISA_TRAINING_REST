package com.visa.RestHotelApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.RestHotelApi.entity.Booking;
import com.visa.RestHotelApi.entity.User;

public interface BookingDao extends JpaRepository<Booking, Integer> {
	List<Booking> findByUser(User user);
}
