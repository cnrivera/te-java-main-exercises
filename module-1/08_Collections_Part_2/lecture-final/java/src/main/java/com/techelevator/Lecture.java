package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();
		
		Set<String> fruits = new HashSet<String>();
		//Set<String> fruits = new LinkedHashSet<String>();
		//Set<String> fruits = new TreeSet<String>();
		
		System.out.println("Apple".hashCode());
		
		fruits.add("Apple");
		fruits.add("Pear");
		fruits.add("Banana");
		fruits.add("Cherry");
		fruits.add("Mango");
		fruits.add("3 Grapes");
		
		
		System.out.println(fruits);
		

		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();
		
		fruits.add("Mango");
		
		System.out.println(fruits);


		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();

		fruits.add("Kiwi");
		
		System.out.println(fruits);
		
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
		
		fruits.remove("Cherry");
		
		System.out.println(fruits);
		
		List<String> desserts = new ArrayList<String>();
		desserts.add("cake");
		desserts.add("pie");
		desserts.add("cake");
		desserts.add("cookies");
		desserts.add("cake");
		
		System.out.println(desserts);
		
		Set<String> dietSet = new HashSet<String>(desserts);
		System.out.println(dietSet);
		

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();
		
		/* Map is an interface and HashMap is a class that implements Map */
		
		Map<String, String> namesToZipCodes = new HashMap<String, String>();

		/* The "put" method is used to add elements to a Map */
		
		namesToZipCodes.put("David", "45208");
		namesToZipCodes.put("Evan", "45458");
		namesToZipCodes.put("Joe", "45244");
	

		/* The "get" method is used to retrieve elements from a Map */
		
		String evansZip = namesToZipCodes.get("Evan");
		System.out.println("Evan lives in zip code: " + evansZip);
		
		System.out.println("Joe lives in zip code: " + namesToZipCodes.get("Joe"));
		
		
		Map<String, Integer> starWarsRating = new HashMap<String, Integer>();
		starWarsRating.put("A New Hope", 5);
		starWarsRating.put("The Phantom Menace", 1);
		starWarsRating.put("The Rise of Skywalker", 4);
		starWarsRating.put("The Empire Strikes Back", 5);
		
	
		/* keySet returns a Set of all of the keys in the Map */
		
		Set<String> keys = starWarsRating.keySet();
		System.out.println(keys);
		
		for (String title : keys) {
			System.out.println(title + " has a rating of " + starWarsRating.get(title));
		}
		
		Set<Entry<String, Integer>> entries = starWarsRating.entrySet();
		
		for (Entry entry : entries) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		/* If the key already exists, put will overwrite the existing value with the new value */
		
		starWarsRating.put("The Rise of Skywalker", 2);
		
		for (String title : keys) {
			System.out.println(title + " has a rating of " + starWarsRating.get(title));
		}
		
		System.out.println(starWarsRating.containsKey("Return of the Jedi"));
		System.out.println(starWarsRating.containsValue(5));
		
		System.out.println(starWarsRating.get("Return of the Jedi"));
		
		starWarsRating.put("Return of the Jedi", null);
		
		System.out.println(starWarsRating.get("Return of the Jedi"));
		
		System.out.println(starWarsRating.containsKey("Return of the Jedi"));
		
		
		
	}

}
