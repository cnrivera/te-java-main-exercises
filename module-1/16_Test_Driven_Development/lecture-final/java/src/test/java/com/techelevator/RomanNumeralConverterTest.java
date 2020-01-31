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
	
	@Test
	public void converting_3000_returns_MMM() {
		String result = converter.convertToRoman(3000); //Act
		Assert.assertEquals("MMM", result);
	}
	
	@Test
	public void converting_1000_and_2000_return_expected_values() {
		String result = converter.convertToRoman(1000); //Act
		Assert.assertEquals("M", result);
		result = converter.convertToRoman(2000); //Act
		Assert.assertEquals("MM", result);
	}
	
	@Test
	public void converting_1001_returns_MI() {
		String result = converter.convertToRoman(1001); //Act
		Assert.assertEquals("MI", result);
	}
	
	@Test
	public void converting_1002_and_3003_return_expected_values() {
		String result = converter.convertToRoman(1002); //Act
		Assert.assertEquals("MII", result);
		result = converter.convertToRoman(3003); //Act
		Assert.assertEquals("MMMIII", result);
	}
	
	@Test
	public void converting_4_returns_IV() {
		String result = converter.convertToRoman(4); //Act
		Assert.assertEquals("IV", result);
	}
	
	@Test
	public void converting_1500_returns_MD() {
		String result = converter.convertToRoman(1500); //Act
		Assert.assertEquals("MD", result);
	}
	
	@Test
	public void converting_159_returns_CLIX() {
		String result = converter.convertToRoman(159); //Act
		Assert.assertEquals("CLIX", result);
	}
	
	@Test
	public void converting_6_returns_VI() {
		String result = converter.convertToRoman(6); //Act
		Assert.assertEquals("VI", result);
	}
	
	@Test
	public void converting_990_returns_CMXC() {
		String result = converter.convertToRoman(990); //Act
		Assert.assertEquals("CMXC", result);
	}
	
	
}
