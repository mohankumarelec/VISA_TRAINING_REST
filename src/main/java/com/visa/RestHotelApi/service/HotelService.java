package com.visa.RestHotelApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.RestHotelApi.dao.HotelDao;
import com.visa.RestHotelApi.entity.Hotel;

@Service
public class HotelService {
	@Autowired
	private HotelDao hotelDao;

	@Transactional
	public void addHotel(Hotel o) {
		hotelDao.save(o);
	}

	@Transactional
	public List<Hotel> getHotels() {
		return hotelDao.findAll();
	}

	public List<Hotel> getHotelByCriteria(String category) {
		return hotelDao.getHotelByCriteria(category);
	}
	
}
