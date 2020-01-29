package com.techelevator.farm;

import java.math.BigDecimal;

public final class Chicken extends FarmAnimal {
	
	public Chicken() {
		super("Chicken", "cluck!");
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	@Override
	public String eat() {
		return "Peck peck!";
	}
	
	@Override
	public BigDecimal getPrice() {
		return new BigDecimal("12.50");
	}

}