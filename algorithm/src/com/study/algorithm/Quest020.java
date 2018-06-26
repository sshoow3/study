package com.study.algorithm;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Quest020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*

n! 이라는 표기법은 n × (n − 1) × ... × 3 × 2 × 1을 뜻합니다.

예를 들자면 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800 이 되는데,
여기서 10!의 각 자리수를 더해 보면 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 입니다.
100! = 
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
100! 의 자리수를 모두 더하면 얼마입니까?
*/		
	
		double temp = 0.000001;
		String temps = "";

		BigInteger tem = BigInteger.ONE;
		for (int i = 100; i > 0; i--) {
			tem = tem.multiply(BigInteger.valueOf(i));
//			temp = temp * i;
//			BigDecimal bigDecimal = new BigDecimal(temp*1000000);
//			System.out.println(i + "  : " + bigDecimal.toString());
//			temps = bigDecimal.toString();

			System.out.println(tem);
		}
		
		int result = 0;
		
		
//		for (int i = 0; i < temps.length(); i++) {
//			result += Integer.parseInt(temps.substring(i,i+1));
//			System.out.println(temps.substring(i,i+1) + ":" + result);
//		}
//		
//		System.out.println(result);
		temps = tem +"";
		System.out.println();
		System.out.println(tem);
		System.out.println(temps);
		for (int i = 0; i < temps.length(); i++) {
			result += Integer.parseInt(temps.substring(i,i+1));
			System.out.println(temps.substring(i,i+1) + ":" + result);
		}
		
		System.out.println(result);
		//648
		
	}

}
