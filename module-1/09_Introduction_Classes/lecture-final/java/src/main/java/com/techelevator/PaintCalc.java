package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalc {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {	
		
		List<Rectangle> wallList = new ArrayList<Rectangle>();
		
		boolean done = false;
		while(done == false) {
			
			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();
			
			System.out.println();
			
			if(userChoice.equals("1")) {	
				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());
				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());
				
				Rectangle currentWall = new Rectangle(height, width);
			
				wallList.add(currentWall);
				
				System.out.println("Added wall: "+ currentWall);
				
			} else if(userChoice.equals("2")) {
				
				int counter = 1;
				int totalArea = 0;
				for (Rectangle wall : wallList) {
					System.out.println("Wall " + counter + ": " + wall);					
					counter++;
					totalArea += wall.getArea();
				}
		
				
				System.out.println("===============================");
				System.out.println("Total Area: "+totalArea+" square feet");
				
				// 1 gallon of paint covers 400 square feet
				float gallonsRequired = (float)totalArea / 400;
				System.out.println("Paint Required: "+gallonsRequired+" gallons");
				
				done = true;
			}
		}		
	}

}
