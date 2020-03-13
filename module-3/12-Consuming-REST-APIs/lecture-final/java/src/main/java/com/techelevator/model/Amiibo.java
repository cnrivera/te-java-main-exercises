package com.techelevator.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Amiibo {

	private String name;
	private String character;
	private Map<String, String> release;
	
	private String head;
	private String tail;
	
	@JsonAnySetter
	private Map<String, String> otherInfo = new HashMap<>();
	
	@JsonProperty("image")
	private String imagePath;
	
	public String getId() {
		return head + tail;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Map<String, String> getRelease() {
		return release;
	}

	public void setRelease(Map<String, String> release) {
		this.release = release;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	public Map<String, String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(Map<String, String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Amiibo) {
			Amiibo otherAmiibo = (Amiibo) other;
			result = getId().equals(otherAmiibo.getId());
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}
	
	
	
}
