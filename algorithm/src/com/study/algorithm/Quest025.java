package com.study.algorithm;

import java.math.BigInteger;

public class Quest025 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
피보나치 수열은 아래와 같은 점화식으로 정의됩니다.

Fn = Fn-1 + Fn-2  (단, F1 = 1, F2 = 1).
이에 따라 수열을 12번째 항까지 차례대로 계산하면 다음과 같습니다.

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
수열의 값은 F12에서 처음으로 3자리가 됩니다.

피보나치 수열에서 값이 처음으로 1000자리가 되는 것은 몇번째 항입니까?
*/		
//		BigInteger temp = new BigInteger("0");
//		BigInteger temp1 = new BigInteger("1");
//		
//		String a = "0";
//		String b = "1";
//		
//		int count = 2;
//		String length = "";
////		while (length.length()<1000) {
//		while (count < 20) {
//			BigInteger temp2 = new BigInteger("0");
////			temp2.add( temp1 ) ;
//			temp2.add(BigInteger.valueOf(Integer.parseInt(a)));
////			temp2.add( temp ) ;
//			temp2.add(BigInteger.valueOf(Integer.parseInt(b)));
//			System.out.println(temp2);
//			
//			temp = temp1;
//			temp1 = temp2;
//			length = temp2+"";
//			System.out.println("F"+(count++) + " : " +temp2 );
//		}
		
		BigInteger temp ,temp1 ,temp2;
		
		temp = new BigInteger("0");
		temp1 = new BigInteger("1");

		int count = 2;
		String length = "";
		while (length.length()<1000) {
//		while (count < 20) {
			temp2 = new BigInteger("0");
//			temp2.add( temp1 ) ;
			temp2 = temp1.add(temp);
//			temp2.add( temp ) ;
//			temp2.add(temp1);
//			System.out.println(temp + " : " + temp1 + " : " +temp2);
			
			temp = temp1;
			temp1 = temp2;
			length = temp2+"";
			System.out.println("F"+(count++) + " : " +temp2 );
			
//			F4782 : 1070066266382758936764980584457396885083683896632151665013235203375314520604694040621889147582489792657804694888177591957484336466672569959512996030461262748092482186144069433051234774442750273781753087579391666192149259186759553966422837148943113074699503439547001985432609723067290192870526447243726117715821825548491120525013201478612965931381792235559657452039506137551467837543229119602129934048260706175397706847068202895486902666185435124521900369480641357447470911707619766945691070098024393439617474103736912503231365532164773697023167755051595173518460579954919410967778373229665796581646513903488154256310184224190259846088000110186255550245493937113651657039447629584714548523425950428582425306083544435428212611008992863795048006894330309773217834864543113205765659868456288616808718693835297350643986297640660000723562917905207051164077614812491885830945940566688339109350944456576357666151619317753792891661581327159616877487983821820492520348473874384736771934512787029218636250627816

		}
		
	}
}
