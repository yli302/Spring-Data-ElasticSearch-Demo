package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.java.config.SpringConfig;
import com.java.dao.HotelRepository;
import com.java.dto.Hotel;

public class HotelMain {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// eager.
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		HotelRepository hrep = ctx.getBean(HotelRepository.class);

		addNewHotel(hrep);

//		findAll(hrep);

//		findByCity(hrep, "city a");

//		findByCountry(hrep, "country a");

//		findByHotelName(hrep, "aaa");

//		findByRoomType(hrep, "Deluxe");

//		facetingOnRoomFacility(hrep, "");

//		facetingOnRoomType(hrep, "");
	}

	static void addNewHotel(HotelRepository hrep) {
		Hotel h1 = new Hotel(4, "aaa", "city a", "state a", "country a", Arrays.asList("bar", "board room"),
				Arrays.asList("Dining Table", "Free Internet"), Arrays.asList("Standard", "Deluxe"), 100, 5.0);
		Hotel h2 = new Hotel(3, "bbb", "city b", "state b", "country a", Arrays.asList("bar", "board room"),
				Arrays.asList("Dining Table"), Arrays.asList("Standard"), 100, 5.0);
		Hotel h3 = new Hotel(2, "ccc", "city c", "state c", "country a", Arrays.asList("bar", "board room"),
				Arrays.asList("Free Internet"), Arrays.asList("Deluxe"), 100, 5.0);
		Hotel h4 = new Hotel(1, "ddd", "city d", "state d", "country a", Arrays.asList("bar", "board room"),
				Arrays.asList("Dining Table"), Arrays.asList("Deluxe"), 100, 5.0);
		hrep.save(h1);
		hrep.save(h2);
		hrep.save(h3);
		hrep.save(h4);
	}

	static void findAll(HotelRepository hrep) {
		List<Hotel> list = hrep.findAll();
		for (Hotel h : list) {
			System.out.println(h);
		}
	}

	static void findByCity(HotelRepository hrep, String city) {
		Page<Hotel> hotelByCity = hrep.findByCity(city, PageRequest.of(0, 10, Sort.by("city")));
		for (Hotel h : hotelByCity)
			System.out.println(h);
	}

	static void findByCountry(HotelRepository hrep, String country) {
		Page<Hotel> hotelByCountry = hrep.findByCountry(country, PageRequest.of(0, 2, Sort.by("city")));
		for (Hotel h : hotelByCountry)
			System.out.println(h);
	}

	static void facetingOnRoomFacility(HotelRepository hrep, String facility) {
		Page<Hotel> hotelByCountry = hrep.termFacetOnRoomFacility(PageRequest.of(0, 2, Sort.by("city")));
		for (Hotel h : hotelByCountry)
			System.out.println(h);
	}

	static void facetingOnRoomType(HotelRepository hrep, String roomType) {
		Page<Hotel> hotelByCountry = hrep.termFacetOnRoomType(PageRequest.of(0, 2, Sort.by("city")));
		for (Hotel h : hotelByCountry)
			System.out.println(h);
	}

	static void findByHotelName(HotelRepository hrep, String hotelName) {
		Page<Hotel> hotelByCountry = hrep.findByHotelName(hotelName, PageRequest.of(0, 10, Sort.by("city")));
		for (Hotel h : hotelByCountry)
			System.out.println(h);
	}

	static void findByRoomType(HotelRepository hrep, String roomType) {
		Page<Hotel> hotelByCountry = hrep.findByRoomType(roomType, PageRequest.of(0, 10, Sort.by("city")));
		for (Hotel h : hotelByCountry)
			System.out.println(h);
	}
}
