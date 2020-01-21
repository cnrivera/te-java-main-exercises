package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		String example = "This is a string.";
		
		System.out.println("The length is: " + example.length());
		
		System.out.println(example.substring(5));
		
		String sub = example.substring(10);	
		System.out.println(sub);
		
		sub = example.substring(0,1);
		System.out.println(sub);
		
		sub = example.substring(0,4);
		System.out.println(sub);
		
		sub = example.substring(8, example.length() - 1);
		System.out.println(sub);
		
		System.out.println("Hello".substring(1));
		
		String greeting = "Happy Martin Luther King Jr. Day!";
		
		System.out.println(greeting.indexOf("King"));
		System.out.println(greeting.indexOf("a"));
		System.out.println(greeting.lastIndexOf("a"));
		System.out.println(greeting.indexOf("a", 10));
		System.out.println(greeting.indexOf("David"));
		
		System.out.println(greeting.charAt(30));
		
		char c = greeting.charAt(30);
		if (c == 'a') {
			System.out.println("c is the character a");
		}
		
		if (greeting.contains("Steve")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		System.out.println(greeting.startsWith("Happy"));
		System.out.println(greeting.endsWith("Day"));
		
		String story = "Once upon a time there was a princess. The princess lived in a castle.";
		String otherStory = story.replace("princess", "frog");
		System.out.println(otherStory);
		System.out.println(story);
		
		String flattery = "Java is fun times!";
		System.out.println(flattery.toUpperCase());
		System.out.println(flattery.toLowerCase());
		
		String firstPart = flattery.substring(0, flattery.indexOf("fun"));
		String secondPart = flattery.substring(flattery.indexOf("fun"));
		System.out.println(firstPart + secondPart.toUpperCase());
		
		String name = "David";
		String name1 = "David";
		
		
		System.out.println(name.equals("david"));
		System.out.println(name.equalsIgnoreCase("david"));
		
		String s = "vid";
		System.out.println(name == "Da" + s); //Don't do this
		System.out.println(name.equals("Da" + s));
		
		String name2 = new String(name);
		System.out.println(name == name2); //Don't do this
		System.out.println(name.equals(name2));
		
		System.out.println(name == name1); //Because of compiler interning... just use .equals
		
		char[] letters = {'D','a','v','i','d'};
		String name3 = new String(letters);
		System.out.println(name3);
		System.out.println(name == name3); //Don't do this
		System.out.println(name.equals(name3));
	}

}
