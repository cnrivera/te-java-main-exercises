package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleCopier {

	private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the path of a file to copy: ");
		String sourcePath = userInput.nextLine();
		File sourceFile = new File(sourcePath);

		if (sourceFile.exists() && sourceFile.isFile()) {
			System.out.print("Enter the path to copy to: ");
			String destPath = userInput.nextLine();
			File destFile = new File(destPath);

			if (destFile.exists() == false) {
				try (Scanner sourceScanner = new Scanner(sourceFile)) {
					try (PrintWriter destWriter = new PrintWriter(destFile)) {
						while (sourceScanner.hasNextLine()) {
							String line = sourceScanner.nextLine();
							destWriter.println(line);
						}
					}
					System.out.println("Copy finished.");
				} catch (FileNotFoundException e) {
					System.out.println("File was not found: " + e.getMessage());
				}
			} else {
				System.out.println("That file already exists!");
			}
		} else {
			System.out.println("That's not an existing file!");
		}
	}
}
