package com.techelevator.farm;

import java.math.BigDecimal;

public class Duck extends FarmAnimal {
	
	public Duck() {
		super("Duck", "QUACK QUACK!");
	}
	
	@Override
	public String eat() {
		return "Nibble nibble!";
	}
	
	@Override
	public BigDecimal getPrice() {
		return new BigDecimal("14.75");
	}

}
