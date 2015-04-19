package edu.iis.mto.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class BowlingTest {

	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void gutterGame_scoreShouldBeEqual0() {
		Bowling b = new Bowling();

		for (int i = 0; i < 20; i++)
			b.roll(0);

		assertThat(b.score(), is(0));
	}

}
