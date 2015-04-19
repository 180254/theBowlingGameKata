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

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			game.roll(pins);
	}

}
