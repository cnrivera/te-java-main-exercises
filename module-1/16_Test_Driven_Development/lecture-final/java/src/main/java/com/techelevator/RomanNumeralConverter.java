package com.techelevator;

public class RomanNumeralConverter {

	public String convertToRoman(int input) {
		String result = "";

		if (input >= 1000) {
			for (int i = 0; i < input; i += 1000) {
				result += "M";
			}
		} else {
			for (int i = 0; i < input; i++) {
				result += "I";
			}
		}
		return result;
	}
}
