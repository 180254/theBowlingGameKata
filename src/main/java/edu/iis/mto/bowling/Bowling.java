package edu.iis.mto.bowling;

public class Bowling {

	private int rolls[] = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll] = pins;
		currentRoll++;
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < rolls.length; i++)
			score += rolls[i];
		return score;
	}

}
