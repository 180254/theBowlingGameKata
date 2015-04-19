package edu.iis.mto.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	Bowling game;

	@Before
	public void setUp() throws Exception {
		game = new Bowling();
	}

	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void gutterGame_scoreShouldBeEquals0() {
		rollMany(20, 0);
		assertThat(game.score(), is(0));
	}

	@Test
	public void allOnes_scoreShouldEquals20() {
		rollMany(20, 1);
		assertThat(game.score(), is(20));
	}

	@Test
	public void oneSpare_scoreShouldTakeItIntoAccount() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);

		assertThat(game.score(), is(16));
	}

	@Test
	public void oneStrike_scoreShouldTakeItIntoAccount() {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);

		assertThat(game.score(), is(24));
	}

	@Test
	public void perfectGame_scoreShouldEquals300() {
		rollMany(12, 10);
		assertThat(game.score(), is(300));
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			game.roll(pins);
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}

	private void rollStrike() {
		game.roll(10);
	}

}
