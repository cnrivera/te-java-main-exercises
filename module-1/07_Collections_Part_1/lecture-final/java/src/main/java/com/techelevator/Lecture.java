package com.techelevator;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> names = new ArrayList<String>();
		
		names.add("Matt");
		names.add("Drew");
		names.add("Evan");
		names.add("Rebecca");
	
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		System.out.println(names.get(1));
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Matt");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		names.add(2, "Ben");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println(names);

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		names.remove(1);
		names.remove("Matt");
		System.out.println(names);
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean inList = names.contains("Evan");
		System.out.println("Evan is in the list of names: " + inList);
		inList = names.contains("Maggie");
		System.out.println("Maggie is in the list of names: " + inList);
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] namesArray = names.toArray(new String[names.size()]);
		for (int i = 0; i < namesArray.length; i++) {
			System.out.println(namesArray[i]);
		}
		
		List<String> immutableList = Arrays.asList(namesArray);
		System.out.println(immutableList);
		
		List<String> mutableList = new ArrayList<String>(immutableList);

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		
		List<Integer> intList;
		List<Double> doubleList;
		
		int count = 25;
		Integer quantity = new Integer(25);
		Integer piecesOfCake = new Integer("8");
		
		int sum = quantity + piecesOfCake;
		
		System.out.println(sum);
		
		Integer studentCount = 19;
		System.out.println(studentCount);
		
		int num; //0
		Integer number; //null
		

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		for(String name : names) {
			System.out.println(name);
		}
		
		for(String name : namesArray) {
			System.out.println(name);
		}

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		Queue<String> priorities;
		priorities = new LinkedList<String>();
		
		priorities.offer("Clean the dishes");
		priorities.offer("Wash the counter");
		priorities.offer("Sweep the floor");
		priorities.offer("Scrub the bathtub");
	
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		
		while (priorities.size() > 0) {
			String nextPriority = priorities.poll();
			System.out.println("Next priority: " + nextPriority);
		}
		
		System.out.println(priorities.poll());
	
		priorities.offer("Walk the dog");
		
		String nextPriority;
		while ((nextPriority = priorities.poll()) != null) {
			System.out.println("Next priority: " + nextPriority);
		}

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();
		
		Stack<String> browserStack = new Stack<String>();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		
		browserStack.push("https://www.google.com");
		browserStack.push("https://www.techelevator.com");
		browserStack.push("https://www.stackoverflow.com");
		

		////////////////////
		// POPPING THE STACK
		////////////////////
		
		while (browserStack.size() > 0) {
			String previousUrl = browserStack.pop();
			System.out.println("Previous URL: " + previousUrl);
		}

	}
}
