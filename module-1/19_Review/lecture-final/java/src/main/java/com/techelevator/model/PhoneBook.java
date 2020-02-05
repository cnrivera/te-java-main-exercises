package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

	private List<Person> contacts = new ArrayList<>();
	
	public void addContact(String name) {
		contacts.add(new Person(name));
	}
	
	public String getContactNames() {
		String result = "";
		for (Person contact : contacts) {
			result += contact.getName() +"\n";
		}
		return result;
	}
}
