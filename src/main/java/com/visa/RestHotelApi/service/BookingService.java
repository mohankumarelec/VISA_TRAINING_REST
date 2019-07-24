package com.visa.RestHotelApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.RestHotelApi.dao.BookingDao;
import com.visa.RestHotelApi.entity.Booking;
import com.visa.RestHotelApi.entity.User;

@Service
public class BookingService {
	@Autowired
	private BookingDao bookingDao;

	@Transactional
	public void addBooking(Booking b) {
		bookingDao.save(b);
	}

	public List<Booking> getBookings() {
		return bookingDao.findAll();
	}
	public List<Booking> getBookingsByUser(User user) {
		return bookingDao.findByUser(user);
	}

}
