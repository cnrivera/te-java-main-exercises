package com.techelevator;

import java.util.Scanner;

import com.techelevator.model.PhoneBook;
import com.techelevator.view.Menu;

public class ExampleCLI {

	private static final String MAIN_MENU_OPTION_ADD_CONTACT = "Add contact";
	private static final String MAIN_MENU_OPTION_DISPLAY_CONTACTS = "Display contacts";
	private static final String MAIN_MENU_OPTION_QUIT = "I would like to exit the program";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_ADD_CONTACT, 
														MAIN_MENU_OPTION_DISPLAY_CONTACTS,
														MAIN_MENU_OPTION_QUIT};

	private Menu menu;
	private PhoneBook phoneBook = new PhoneBook();
	
	private static Scanner userInput = new Scanner(System.in);

	public ExampleCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		ExampleCLI cli = new ExampleCLI(menu);
		cli.run();
	}
	
	private void run() {
		boolean done = false;
		while (done == false) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_ADD_CONTACT)) {
				handleAddContact();
			} else if (choice.equals(MAIN_MENU_OPTION_DISPLAY_CONTACTS)) {
				handleDisplayContacts();
			} else if (choice.equals(MAIN_MENU_OPTION_QUIT)) {
				done = true;
			}
		}
	}
	
	private void handleAddContact() {
		System.out.print("Please enter the name of the new contact: ");
		String name = userInput.nextLine();
		phoneBook.addContact(name);
		System.out.println("Added new contact.");
	}
	
	private void handleDisplayContacts() {
		System.out.println("-----CONTACT LIST-----");
		System.out.print(phoneBook.getContactNames());
		System.out.println("----------------------");
	}

}
