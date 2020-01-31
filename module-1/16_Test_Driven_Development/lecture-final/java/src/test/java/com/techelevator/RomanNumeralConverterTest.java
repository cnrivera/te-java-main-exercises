package com.techelevator;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

public class RomanNumeralConverterTest {

	private RomanNumeralConverter converter;
	
	@Before
	public void setup() {
		converter = new RomanNumeralConverter(); //Arrange
	}
	
	@Test
	public void converting_1_returns_I() {
		String result = converter.convertToRoman(1); //Act
		Assert.assertEquals("I", result);
	}
	
	@Test
	public void converting_2_returns_II() {
		String result = converter.convertToRoman(2); //Act
		Assert.assertEquals("II", result);
	}
	
	@Test
	public void converting_3_returns_III() {
		String result = converter.convertToRoman(3); //Act
		Assert.assertEquals("III", result);
	}
	
	
	
}
