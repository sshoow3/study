package com.study.algorithm;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Quest016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
2^15 = 32768 의 각 자리수를 더하면 3 + 2 + 7 + 6 + 8 = 26 입니다.
2^1000의 각 자리수를 모두 더하면 얼마입니까?


*/		
		double result = 0.0000002;
		 
		
		
		String temps = "";
		
		
		for (int i = 2; i < 1001; i++) {
			double temp = result *2;
			BigDecimal bigDecimal = new BigDecimal(temp*10000000);
			result = temp;
			System.out.println(i + " : " +bigDecimal.toString());
			temps = bigDecimal.toString();
		}
		
		System.out.println("2^1000 result  : "+temps);
		
		int sum = 0;
		
		for (int i = 0; i < temps.length(); i++) {
			sum += Integer.parseInt(temps.substring(i,i+1));
			System.out.println(i + ": calc sum " + temps.substring(i,i+1) +"  : "+sum);
		}
		System.out.println("final result : "+sum);
	}

}
