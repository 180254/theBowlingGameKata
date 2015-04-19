package edu.iis.mto.bowling;

public class Bowling {

	private final static int MAX_ROLLS = 21;
	private final static int MAX_FRAME_PINS = 10;
	private final static int NO_OF_FRAMES = 10;

	private int rolls[] = new int[MAX_ROLLS];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll] = pins;
		currentRoll++;
	}

	public int score() {
		int score = 0;
		int frameIndex = 0;

		for (int frame = 0; frame < NO_OF_FRAMES; frame++) {
			if (isStrike(frameIndex)) {
				score += MAX_FRAME_PINS + strikeBonus(frameIndex);
				frameIndex += 1;

			} else if (isSpare(frameIndex)) {
				score += MAX_FRAME_PINS + spareBonus(frameIndex);
				frameIndex += 2;

			} else {
				score += sumOfBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}

		return score;
	}

	private int sumOfBallsInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1] == MAX_FRAME_PINS;
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex + 2];
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == MAX_FRAME_PINS;
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex + 1] + rolls[frameIndex + 2];
	}

}
