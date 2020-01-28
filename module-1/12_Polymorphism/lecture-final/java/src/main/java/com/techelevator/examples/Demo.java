package com.techelevator.examples;

import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		Random rand = new Random();
		
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt(10)); //0-9
		System.out.println(rand.nextInt(10) + 1); //1-10
		System.out.println(rand.nextDouble());
		
		
		System.out.format("%15f|%15d|%15s\n", rand.nextDouble(), rand.nextInt(), "Blah blah");
		System.out.format("%15f|%15d|%15s\n", rand.nextDouble(), rand.nextInt(), "Blah blah");
		

	}

}
