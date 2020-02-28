package com.techelevator;

public class EnumDemo {
	
	public enum Season {SPRING, SUMMER, FALL, WINTER}
	
	public enum PhoneType {
		ANDROID("Google"), IPHONE("Apple"), WINDOWSPHONE;
		
		private String maker;
		
		private PhoneType(String maker) {
			this.maker = maker;
		}
		
		private PhoneType() {
			this.maker = "Nobody";
		}
		
		public String sayHello() {
			return "Hello! " + maker + " is listening.";
		}
	}
	
	public static void main(String[] args) {
		
		Season s;
		
		s = Season.SUMMER;
		
		if (s == Season.SUMMER) {
			System.out.println("It's summertime!");
		}
		
		System.out.println(Season.WINTER);
		
		System.out.println(PhoneType.WINDOWSPHONE.sayHello());
	}

}
