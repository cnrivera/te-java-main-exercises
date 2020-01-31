package com.techelevator;

import org.junit.Test;

import org.junit.Assert;

public class RomanNumeralConverterTest {

	
	@Test
	public void converting_1_returns_I() {
		RomanNumeralConverter converter = new RomanNumeralConverter(); //Arrange
		String result = converter.convertToRoman(1); //Act
		Assert.assertEquals("I", result);
		
	}
	
}
