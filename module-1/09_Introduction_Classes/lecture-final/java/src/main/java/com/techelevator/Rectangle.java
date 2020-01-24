package com.techelevator;

public class Rectangle {
	
	private int height;
	private int width;
	
	public Rectangle() {
		height = 1;
		width = 1;		
	}
	
	public Rectangle(int height, int width) {
		this.setHeight(height);
		this.setWidth(width);
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		if (height > 0) {
			this.height = height;
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		if (width > 0) {
			this.width = width;
		}
	}
	
	public int getArea() {
		return height * width;
	}
	
	@Override
	public String toString() {
		return getHeight() + "x" + getWidth() + " - " + getArea() + " square feet";
	}

}
