package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal {
	public static final String TEST = "MOO";

	public Cow() {
		super("Cow", "moo!");
	}
	
	@Override
	public BigDecimal getPrice() {
		return new BigDecimal("100.00");
	}
	
	@Override
	public String eat() {
		return "Munch munch!";
	}

}