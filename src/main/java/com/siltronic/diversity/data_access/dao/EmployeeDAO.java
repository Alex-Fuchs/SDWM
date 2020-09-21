package com.siltronic.diversity.data_access.dao;

public class EmployeeDAO {

	private int id;
	private String firstName;
	private String secondName;
	private String birthPlace;
	
	public EmployeeDAO(int id, String firstName, String secondName, String birthPlace) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthPlace = birthPlace;
	}
	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getBirthPlace() {
		return birthPlace;
	}
}
