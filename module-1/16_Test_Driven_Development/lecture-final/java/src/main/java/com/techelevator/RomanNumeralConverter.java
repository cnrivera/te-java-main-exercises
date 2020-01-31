package com.techelevator;

public class RomanNumeralConverter {

	public String convertToRoman(int input) {
		String result = "";

		result += doConversionStep(input, 1000, "M");
		input = input % 1000;
		result += doConversionStep(input, 500, "D");
		input = input % 500;
		result += doConversionStep(input, 4, "IV");
		input = input % 4;
		result += doConversionStep(input, 1, "I");

		
		return result;
	}
	
	private String doConversionStep(int input, int value, String symbol) {
		String result = "";
		while (input >= value) {
			result += symbol;
			input -= value;
		}
		return result;
	}
}
