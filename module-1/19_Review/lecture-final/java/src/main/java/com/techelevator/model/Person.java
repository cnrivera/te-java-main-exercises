package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	private List<PhoneNumber> phoneNumbers = new ArrayList<>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addPhone(String description, String number) {
		phoneNumbers.add(new PhoneNumber(number, description));
	}
	
	
}
