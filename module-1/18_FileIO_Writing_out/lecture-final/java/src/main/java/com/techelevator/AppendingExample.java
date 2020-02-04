package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class AppendingExample {

	public static void main (String[] args) {
		
		File existingFile = new File("example2/my-file.txt");
		
		if (existingFile.exists()) {
			try (PrintWriter writer = new PrintWriter(new FileOutputStream(existingFile, true))){
				writer.println("Here's a line.");
			} catch (FileNotFoundException e) {
				System.out.println("Existing file was not found...weird.");
			}
		}
		
	}
}
