package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {
		
		Chicken chickenLittle = new Chicken();
		Duck daffy = new Duck();
				
		Singable[] songThings = new Singable[] { new Cow(), chickenLittle, daffy, new Tractor() };
		
		chickenLittle.sleep();
		daffy.sleep();
		
		for(Singable songThing : songThings) {
			String name = songThing.getName();
			String sound = songThing.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			System.out.println();
		}
		
		List<Sellable> merchandise = new ArrayList<>();
		merchandise.add(new Duck());
		merchandise.add(new Cow());
		merchandise.add(new Egg());
		
		for(Sellable product : merchandise) {
			System.out.println("You can buy the " + product.getName() + " for just $" + product.getPrice());
		}
		
		Sellable thing = new Chicken();
		System.out.println(thing.getName());
		((Chicken) thing).layEgg();
		
		if (thing instanceof Singable) {   //Don't do this very often--usually a code smell.
			System.out.println("Yes it is!");
		} else {
			System.out.println("No it isn't!");
		}
		
		System.out.println(FarmAnimal.TEST);
		
	}
}