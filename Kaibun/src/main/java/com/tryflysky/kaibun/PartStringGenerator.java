package com.tryflysky.kaibun;

import java.util.ArrayList;
import java.util.List;

public class PartStringGenerator {




	public List<String> generate(String str) {

		List<String> parts = new ArrayList<String>();

		int length_original = str.length();
		int length_substr = 1;

		while(length_substr <= length_original) {

			int beginindex = 0;

			while((beginindex + length_substr) <= length_original) {

				parts.add(str.substring(beginindex, (beginindex + length_substr)));
				beginindex++;
			}

			length_substr++;
		}

		return parts;
	}

}
