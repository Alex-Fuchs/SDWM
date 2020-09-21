package com.siltronic.diversity.data_access.dao;

public class CountryDAO {
	
	private String id;
	
	private String name;
	
	private int value;
	
	private String color;
	
	public CountryDAO(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
