package com.techelevator.regex;

public class SimpleRegexDemo {

	public static void main(String[] args) {
		
		String s = "10|20-30xxxx40";
		String[] stringArray = s.split(" |-|x+|\\|");
		
		for (String current : stringArray) {
			System.out.println(current);
		}

	}

}
