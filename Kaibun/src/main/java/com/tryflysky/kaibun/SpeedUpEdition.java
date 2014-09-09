package com.tryflysky.kaibun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SpeedUpEdition {


	public final static int KAIBUN = 1;			//回文だ！
	public final static int NOT_KAIBUN = 0;		//回文じゃないぞ！
	private final static int ALLOW_ODD_MAX = 1;	//奇数が何個までなら回文と判定できるか




	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();

		InputStream is = SpeedUpEdition.class.getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		int lineNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < lineNum; i++) {

			System.out.println(analyze(br.readLine()));
		}

		System.out.println();
		System.out.println("done! " + (System.currentTimeMillis() - start) + "ms.");
	}





	private static int analyze(String str) {

		int kaibunNum = 0;

		for(int i = 0; i < str.length(); i++) {

			kaibunNum += countKaibun(i, str);
		}

		return kaibunNum;
	}






	/**
	 * beginIndexから最後までの間で１文字ずつ配列に追加し、都度、回文の数を数える
	 *
	 * begenIndex : 2
	 * str        : pepper
	 *              012345  -> pper
	 *
	 * charNums[p] += 1  ->  count kaibun num
	 * charNums[p] += 1  ->  count kaibun num
	 * charNums[e] += 1  ->  count kaibun num
	 * charNums[r] += 1  ->  count kaibun num
	 *
	 * @param beginIndex
	 * @param str
	 * @return
	 */
	private static int countKaibun(int beginIndex, String str) {

		int kaibunNum = 0;
		int[] charNums = new int[26];	//対象は英小文字26文字のみであることを想定

		for(int i = beginIndex; i < str.length(); i++) {

			char c = str.charAt(i);

			charNums[c - 'a'] += 1;

			kaibunNum += isKaibun(charNums);
		}

		return kaibunNum;
	}





	/**
	 * charNumsは英小文字26文字が、解析した文字列に何個入っているかを保持している
	 * この配列の中の奇数が[1個以下]であればその文字列は回文と判定
	 *
	 * @param charNums
	 * @return
	 */
	private static int isKaibun(int[] charNums) {

		int oddNum = 0;

		for(int num : charNums) {

			oddNum += num % 2;	//奇数なら「1」増える

			if(oddNum > ALLOW_ODD_MAX) {	//回文でないとわかった時点で終了
				return NOT_KAIBUN;
			}
		}

		return KAIBUN;
	}









	/*
	 ○内容：
	アナグラム回文数算出プログラムの作成

	○評価方法：
	今回は速度を最重要項目として評価します。

	------ 以下、コンテストのお題の詳細です。------

	回文とは「たけやぶやけた」のような上から読んでも下から読んでも（左から読
	んでも右から読んでも）同じ文となる文です。

	僕の造語ですが、アナグラム回文とは、「たけややぶけた」のように並べ替える
	と回文になる文とします。

	さて、本題ですが、今回は、文字列が与えられたときに、その文字列にいくつの
	アナグラム回文が部分文字列として含まれているかを数えるプログラムを作成し
	てもらいたいです。

	１つ具体的に考えてみます。
	入力された文字列が「pepper」だったとします。
	このとき
	p, e, p, p, e, r,
	pe, ep, pp, pe, er,
	pep, epp, ppe, per,
	pepp, eppe, pper
	peppe, epper,
	pepper
	という21個の部分文字列が存在します。

	このうち、
	p, e, p, p, e, r, pp, pep, epp, ppe, eppe, peppe, epper
	という13個が、アナグラム回文となっているため、「13」が解となります。


	また、今回は標準入力から情報を読み出し、結果を標準出力に書き出してください。

	○入力
	先頭行にいくつの文字列をチェックするか、２行目以降は、１行に１つずつアナ
	グラム回文を計測する文字列が指定されます。

	例：
	3
	abcde
	pepper
	aaaaa

	○出力
	各行に１つの計測結果を順に出力してください。

	例：（さきほどの入力の例）
	5
	13
	15
	 */
}
