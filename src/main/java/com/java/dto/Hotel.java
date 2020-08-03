package com.java.dto;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(indexName = "hotel")
public class Hotel {
	@Id
	private int id;
	private String hotelName;
//	fielddata=true, don't know how to set at here, manually set on postman by Put map api
	@Field(fielddata = true)
	private String city;
	private String state;
	private String country;
	@Field(fielddata = true)
	private List<String> hotelFacilities;
	@Field(fielddata = true)
	private List<String> roomFacility;
	private List<String> roomType;
	private int reviewCount;
	private double reviewScore;
}
