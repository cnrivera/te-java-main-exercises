package com.techelevator;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {
	
	private static final Map<Integer, String> SYMBOLS = new LinkedHashMap<>();
	static {
		SYMBOLS.put(1000, "M");
		SYMBOLS.put(900, "CM");
		SYMBOLS.put(500, "D");
		SYMBOLS.put(400, "CD");
		SYMBOLS.put(100, "C");
		SYMBOLS.put(90, "XC");
		SYMBOLS.put(50, "L");
		SYMBOLS.put(40, "XL");
		SYMBOLS.put(10, "X");
		SYMBOLS.put(9, "IX");
		SYMBOLS.put(5, "V");
		SYMBOLS.put(4, "IV");
		SYMBOLS.put(1, "I");
	}

	public String convertToRoman(int input) {
		String result = "";
		for(int i : SYMBOLS.keySet()) {
			while (input >= i) {
				result += SYMBOLS.get(i);
				input -= i;
			}
		}
		return result;
	}
	
}
