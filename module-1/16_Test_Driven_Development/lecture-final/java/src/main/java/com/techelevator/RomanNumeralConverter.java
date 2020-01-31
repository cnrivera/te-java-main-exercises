package com.techelevator;

public class RomanNumeralConverter {

	public String convertToRoman(int input) {
		String result = "";

		while (input >= 1000) {
			result += "M";
			input -= 1000;
		}

		if (input > 0) {
			for (int i = 0; i < input; i++) {
				result += "I";
			}
		}
		return result;
	}
}
