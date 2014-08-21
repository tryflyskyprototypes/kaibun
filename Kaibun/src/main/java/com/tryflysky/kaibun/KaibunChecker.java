package com.tryflysky.kaibun;



/**
 *
 *
 * @author admin
 *
 */
public class KaibunChecker {

	PartStringGenerator partStringGenerator = new PartStringGenerator();
	CharCounter charCounter = new CharCounter();

	public final int KAIBUN = 1;		//回文だ！
	public final int NOT_KAIBUN = 0;	//回文じゃないぞ！

	private final int ALLOW_ODD_MAX = 1;	//奇数が何個までなら回文と判定できるか


	public int[] countKaibunNum(String[] values) {

		int[] results = new int[values.length];

		for(int i = 0; i < results.length; i++) {

			results[i] = countKaibunNum(values[i]);
		}

		return results;
	}





	public int countKaibunNum(String str) {

		int kaibunNum = 0;

		for(String part : partStringGenerator.generate(str)) {

			kaibunNum += isKaibun(part);	//booleanで判定してから数を増やすのも無駄なので
		}

		return kaibunNum;
	}





	/**
	 * 文字列に含まれる各文字が奇数であるものが１つ以下なら回文と判定
	 *
	 * pepper
	 *   p * 3
	 *   e * 2
	 *   r * 1
	 *   -> 奇数が２つあるので回文ではない
	 *
	 * peper
	 *   p * 2
	 *   e * 2
	 *   r * 1
	 *   -> 奇数が１つなので回文 -> "perep" or "eprpe"
	 *
	 * @param str
	 * @return
	 */
	public int isKaibun(String str) {

		int oddNum = 0;

		for(int charNum : charCounter.count(str)) {

			oddNum += charNum % 2;	//奇数なら「1」増える

			if(oddNum > ALLOW_ODD_MAX) {	//回文でないとわかった時点で終了（文字列が長くなる程この方が効率いいはず）
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
