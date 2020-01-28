package com.techelevator.farm;

import java.math.BigDecimal;

public class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	@Override
	public String getName( ) {
		return name;
	}
	
	@Override
	public String getSound( ) {
		return sound;
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal("10.00");
	}
	
}