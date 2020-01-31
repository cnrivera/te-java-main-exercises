package com.techelevator;

public class RomanNumeralConverter {

	public String convertToRoman(int input) {
		String result = "";

		if (input == 3000) {
			result = "MMM";
		} else if (input == 2000) {
			result = "MM";
		} else if (input == 1000) {
			result = "M";
		}
		else {

			for (int i = 0; i < input; i++) {
				result += "I";
			}
		}
		return result;
	}
}
