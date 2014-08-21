package com.tryflysky.kaibun;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PartStringGeneratorTest {

	@Test
	public void test() {

		PartStringGenerator generator = new PartStringGenerator();

		String[] expects = {
				"p",
				"e",
				"p",
				"p",
				"e",
				"r",

				"pe",
				"ep",
				"pp",
				"pe",
				"er",

				"pep",
				"epp",
				"ppe",
				"per",

				"pepp",
				"eppe",
				"pper",

				"peppe",
				"epper",

				"pepper",
		};


		List<String> actuals = generator.generate("pepper");

		assertTrue(expects.length == actuals.size());

		//generate()はArrayListで返すので、あまり安全なテストではない
		for(int i = 0; i < expects.length; i++) {

			assertEquals(expects[i], actuals.get(i));
		}
	}

}
