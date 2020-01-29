package com.techelevator.farm;

public class Duck extends FarmAnimal {
	
	public Duck() {
		super("Duck", "quack!");
	}
	
	@Override
	public String getSound() {
		return "QUACK QUACK!";
	}

}
