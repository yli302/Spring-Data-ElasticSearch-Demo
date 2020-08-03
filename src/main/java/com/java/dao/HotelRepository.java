package com.java.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.java.dto.Hotel;

public interface HotelRepository extends ElasticsearchRepository<Hotel, Integer> {
	public List<Hotel> findAll();

	public Page<Hotel> findByCity(String city, PageRequest of);

	public Page<Hotel> findByCountry(String string, PageRequest pageRequest);

	public Page<Hotel> findByHotelName(String hotelName, PageRequest of);

	public Page<Hotel> findByRoomType(String roomType, PageRequest of);

//	@Query("{\"aggs\": {\"roomFacility\": {\"terms\":{ \"field\" : \"roomFacility\"}}}}")
//	@Query("{ \"query\": { \"bool\": { \"filter\": [ { \"term\":  { \"roomFacility\": \"Dining Table\" }}]}}}")
	public Page<Hotel> termFacetOnRoomFacility(PageRequest of);

//	@Query("{\"aggs\": {\"roomType\": {\"terms\":{ \"field\" : \"roomType\"}}}}")
//	@Query("{ \"query\": { \"bool\": { \"filter\": [ { \"term\":  { \"roomType\": \"Deluxe\" }}]}}}")
	public Page<Hotel> termFacetOnRoomType(PageRequest of);

}
