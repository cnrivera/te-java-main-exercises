package com.techelevator;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {
	
	private static final Map<Integer, String> SYMBOLS = new LinkedHashMap<>();
	static {
		SYMBOLS.put(1000, "M");
		SYMBOLS.put(500, "D");
		SYMBOLS.put(4, "IV");
		SYMBOLS.put(1, "I");
	}

	public String convertToRoman(int input) {
		String result = "";

		for(int i : SYMBOLS.keySet()) {
			result += doConversionStep(input, i, SYMBOLS.get(i));
			input = input % i;
		}

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
