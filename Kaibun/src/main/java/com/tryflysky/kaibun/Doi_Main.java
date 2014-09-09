package com.tryflysky.kaibun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Doi_Main {
	
	public static void main(String[] argv) {
		DromicpalinSubstringCounter dromicpalinSubstringCounter = new DromicpalinSubstringCounter();

		long start = System.currentTimeMillis();
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		InputStream is = SpeedUpEdition.class.getResourceAsStream("input.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			int count = Integer.parseInt(reader.readLine());
			for (int i = 0; i < count; ++i) {
				String string = reader.readLine();
				int numberOfDromicpalinSubstring = dromicpalinSubstringCounter.count(string);
				System.out.println(numberOfDromicpalinSubstring); 
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		System.out.println();
		System.out.println("done! " + (System.currentTimeMillis() - start) + "ms.");
	}
}

class DromicpalinSubstringCounter {

	public static class CharacterCounter {
		private int[] numOfCharacters = new int[26];
		public void append(char c) {
			++numOfCharacters[c - 'a'];
		}
		public boolean isDromicpalin() {
			int numOfOdd = 0;
			for (int i = 0; i < numOfCharacters.length; ++i) {
				if (numOfCharacters[i] % 2 == 1) {
					++numOfOdd;
					if (numOfOdd > 1) {
						return false;
					}
				}
			}
			return true;
		}
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < numOfCharacters.length; ++i) {
				if (numOfCharacters[i] > 0) {
					String item = Character.toString((char)i) + ":" + numOfCharacters[i];
					buffer.append(item);
				}
			}
			return buffer.toString();
		}
	}
	
	public int count(String string) {
		int count = 0;
		for (int i = 0; i < string.length(); ++i) {
			count += countDromicpalin(string.substring(i));
		}
		return count;
	}
	
	public int countDromicpalin(String string) {
		CharacterCounter counter = new CharacterCounter();
		counter.append(string.charAt(0));
		int count = 1;
		for (int i = 1; i < string.length(); ++i) {
			counter.append(string.charAt(i));
			if (counter.isDromicpalin()) {
				++count;
			}
		}
		return count;
	}
	
	public boolean isDromicpalin(String string) {
		Map<String, Integer> map = countCharacters(string);
		
		int oddNumber = 0;
		Set<String> keys = map.keySet();
		Iterator<String> itr = keys.iterator();
		while (oddNumber <= 1 && itr.hasNext()) {
			String key = itr.next();
			int count = map.get(key).intValue();
			if ((count % 2) == 1) {
				++oddNumber;
			}
		}
		return oddNumber <= 1;
	}
	
	public List<String> makeSubstringList(String string) {
		List<String> list = new LinkedList<String>();
		for (int i = 1; i <= string.length(); ++i) {
			List<String> subList = makeSubstringOfSpecifiedLengthList(string, i);
			list.addAll(subList);
		}
		return list;
	}
	
	private List<String> makeSubstringOfSpecifiedLengthList(String string, int length) {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i + length <= string.length(); ++i) {
			list.add(string.substring(i, i + length));
		}
		return list;
	}
	
	private Map<String, Integer> countCharacters(String string) {
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		for (int i = 0; i < string.length(); ++i) {
			String character = string.substring(i, i + 1);
			if (!map.containsKey(character)) {
				map.put(character, 0);
			}
			Integer count = map.get(character);
			map.remove(character);
			map.put(character, count.intValue() + 1);
		}
		return map;
	}

}
