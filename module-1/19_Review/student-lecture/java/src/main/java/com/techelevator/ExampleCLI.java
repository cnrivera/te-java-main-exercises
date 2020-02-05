package com.techelevator;

import com.techelevator.view.Menu;

public class ExampleCLI {

	private static final String MAIN_MENU_OPTION_DO_SOMETHING = "I would like to do something";
	private static final String MAIN_MENU_OPTION_DO_SOMETHING_ELSE = "I would like to do something else";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DO_SOMETHING, MAIN_MENU_OPTION_DO_SOMETHING_ELSE };

	private Menu menu;

	public ExampleCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		ExampleCLI cli = new ExampleCLI(menu);
		cli.run();
	}
	
	private void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DO_SOMETHING)) {
				doSomething();
			} else if (choice.equals(MAIN_MENU_OPTION_DO_SOMETHING_ELSE)) {
				doSomethingElse();
			}
		}
	}
	
	private void doSomething() {
		System.out.println("****");
		System.out.println("Doin' something!");
		System.out.println("****");
	}
	
	private void doSomethingElse() {
		System.out.println("****");
		System.out.println("Doin' something else!");
		System.out.println("****");
	}

}
