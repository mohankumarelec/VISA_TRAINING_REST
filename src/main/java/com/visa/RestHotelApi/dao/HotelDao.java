package com.visa.RestHotelApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.RestHotelApi.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {
	
	@Query("from Hotel where name like %:crit% or city like %:crit%")
	List<Hotel> getHotelByCriteria(@Param("crit") String criteria);

}
