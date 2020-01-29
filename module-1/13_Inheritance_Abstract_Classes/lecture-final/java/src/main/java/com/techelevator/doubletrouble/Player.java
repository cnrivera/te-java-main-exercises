package com.techelevator.doubletrouble;

public class Player {
	private int playerNumber;
	private int currentScore;
	
	public Player(int playerNumber) {
		this.playerNumber = playerNumber + 1;
		this.currentScore = 0;
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

	public int getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	
	@Override
	public String toString() {
		return "Player " + playerNumber;
	}
}
