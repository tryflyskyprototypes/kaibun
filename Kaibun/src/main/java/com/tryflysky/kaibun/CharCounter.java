package com.tryflysky.kaibun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharCounter {





	public List<Integer> count(String str) {

		Set<Character> set = new HashSet<Character>();
		for(char c : str.toCharArray()) {

			set.add(c);
		}

		List<Integer> list = new ArrayList<Integer>();
		for(char c : set) {

			list.add(count(str, c));
		}

		return list;
	}




	/**
	 * 第一引数の文字列に含まれる第二引数の文字数を返す
	 *
	 * 第一引数  "pepper"
	 * 第二引数  'p'
	 * 戻り値    3
	 *
	 * @param original
	 * @param c
	 * @return
	 */
	//TODO util化
	private int count(String original, char c) {

//		String removed = str.replace(c, '\u0000');		//この書き方だと、置換した「空文字」が見えない１文字として残り長さが変わらない
		String removed = original.replaceAll(String.valueOf(c), "");

		return original.length() - removed.length();
	}





}
