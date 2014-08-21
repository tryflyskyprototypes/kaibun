package com.tryflysky.kaibun;

public class SampleExecutor {

	public static void main(String[] args) {
		
		KaibunChecker checker = new KaibunChecker();
		
		long start = System.currentTimeMillis();
		
		String[] values = {"abcde", "pepper", "aaaaa"};
		
		int[] results = checker.countKaibunNum(values);
		
		for(int i : results) {
			System.out.println(i);
		}

		System.out.println();
		System.out.println("done! " + (System.currentTimeMillis() - start) + "ms.");
	}

}
