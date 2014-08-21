package com.tryflysky.kaibun;

import static org.junit.Assert.*;

import org.junit.Test;

public class KaibunCheckerTest {

	KaibunChecker kaibunChecker = new KaibunChecker();



	@Test
	public void test() {


		String kaibun = String.valueOf(kaibunChecker.KAIBUN);
		String not_kaibun = String.valueOf(kaibunChecker.NOT_KAIBUN);

		String[][] expects = {

				{"p", kaibun},
				{"e", kaibun},
				{"pe", not_kaibun},
				{"ep", not_kaibun},
				{"pp", kaibun},
				{"er", not_kaibun},
				{"pep", kaibun},
				{"epp", kaibun},
				{"ppe", kaibun},
				{"per", not_kaibun},
				{"pepp", not_kaibun},
				{"eppe", kaibun},
				{"pper", not_kaibun},
				{"peppe", kaibun},
				{"epper", kaibun},
				{"pepper", not_kaibun},
		};


		for(String[] expect : expects) {

			assertEquals(expect[1], String.valueOf(kaibunChecker.isKaibun(expect[0])));
		}
	}




	@Test
	public void countTest() {

		String[][] expects = {

				{"abcde", "5"},
				{"pepper", "13"},
				{"aaaaa", "15"},
		};


		for(String[] expect : expects) {

			int num = kaibunChecker.countKaibunNum(expect[0]);

			assertEquals(expect[1], String.valueOf(num));
		}



	}
}
