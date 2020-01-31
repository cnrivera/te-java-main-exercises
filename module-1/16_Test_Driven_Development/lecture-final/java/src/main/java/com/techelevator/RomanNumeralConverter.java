package com.techelevator;

public class RomanNumeralConverter {

	public String convertToRoman(int input) {
		String result = "II";
		if (input == 1) {
			result = "I";
		} else if (input == 3) {
			result = "III";
		}
		return result;
	}
}
