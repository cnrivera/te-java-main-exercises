package com.techelevator.farm;

import java.math.BigDecimal;

public abstract class FarmAnimal implements Singable, Sellable {
	public static final String TEST = "testing";
	
	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		this.asleep = false;
	}
	
	@Override
	public String getName( ) {
		return name;
	}
	
	@Override
	public final String getSound( ) {
		String result = "Zzzz...";
		if (!asleep) {
			result = sound;
		}
		return result;
	}

	@Override
	public abstract BigDecimal getPrice();
	
	public void sleep() {
		asleep = true;
	}
	
	public void wake() {
		asleep = false;
	}
	
	public abstract String eat();
	
}