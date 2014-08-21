package com.tryflysky.kaibun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class ConsolePrompt {



	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Input analyse num...");
		int analyzeNum = Integer.valueOf(sysoutPrompt());	//入力の検証は省略

		String[] strs = new String[analyzeNum];

		for(int i = 0; i < strs.length; i++) {

			System.out.println("Input string "+ (i + 1) + " ...");
			strs[i] = sysoutPrompt();
		}

		KaibunChecker checker = new KaibunChecker();

		long start = System.currentTimeMillis();

		int[] results = checker.countKaibunNum(strs);

		for(int i : results) {
			System.out.println(i);
		}

		System.out.println();
		System.out.println("done! " + (System.currentTimeMillis() - start) + "ms.");
	}





	private static String sysoutPrompt() throws IOException {

		System.out.print("->  ");

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		return input.readLine();
	}



}