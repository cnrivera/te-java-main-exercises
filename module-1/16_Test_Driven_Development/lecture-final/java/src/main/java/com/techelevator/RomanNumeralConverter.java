package com.techelevator;

public class RomanNumeralConverter {

	public String convertToRoman(int input) {
		String result = "";
		for (int i = 0; i < input; i++) {
			result += "I";
		}
		return result;
	}
}
