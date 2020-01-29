package com.techelevator.doubletrouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.techelevator.game.Game;

public class DoubleTrouble extends Game {
	
	public static final int WINNING_SCORE = 50;

	private Random rand;
	private List<Player> playerList;
	private int lastScore;
	private int roundCounter;
	
	public DoubleTrouble(int numberOfPlayers) {
		super(numberOfPlayers);
		rand = new Random();
		playerList = new ArrayList<Player>();
		lastScore = 0;
		roundCounter = 1;
	}

	@Override
	protected void setup(int numberOfPlayers) {
		for (int i = 0; i < numberOfPlayers; i++) {
			playerList.add(new Player(i));
		}
		System.out.println("Starting a game with " + numberOfPlayers + " players!");
	}
	
	private int rollSixSidedDie() {
		return rand.nextInt(6) + 1;
	}

	@Override
	protected void takeTurn(int player) {
		if (player == 1) {
			System.out.println("Starting Round " + roundCounter++);
		}
		Player currentPlayer = playerList.get(player-1);
		System.out.println(currentPlayer + " is about to roll the dice...");
		int die1Value = rollSixSidedDie();
		int die2Value = rollSixSidedDie();
		System.out.println(currentPlayer + " rolled " + die1Value + " and " + die2Value);
		if (die1Value == die2Value) {
			System.out.println("Oh no! " + currentPlayer + " loses all their points.");
			currentPlayer.setCurrentScore(0);
		} else {
			int sum = die1Value + die2Value;
			currentPlayer.setCurrentScore(currentPlayer.getCurrentScore() + sum);
			System.out.println(currentPlayer + " scores " + sum + " points.");
			System.out.println(currentPlayer + " has a total of " + currentPlayer.getCurrentScore() + " points.");
		}
		lastScore = currentPlayer.getCurrentScore();
	}

	@Override
	protected boolean isGameOver() {
		return lastScore >= WINNING_SCORE;
	}

	@Override
	protected void finishGame() {
		Player winner = playerList.get(0);
		for (Player p : playerList) {
			if (p.getCurrentScore() > winner.getCurrentScore()) {
				winner = p;
			}
		}
		System.out.println("The WINNER is " + winner + "!");
	}

}
