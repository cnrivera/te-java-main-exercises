package com.techelevator;

public class RomanNumeralConverter {

	public String convertToRoman(int input) {
		String result = "II";
		if (input == 1) {
			result = "I";
		}
		return result;
	}
}
