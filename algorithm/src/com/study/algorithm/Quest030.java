package com.study.algorithm;

import java.util.ArrayList;

public class Quest030 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 각 자리의 숫자를 4제곱해서 더했을 때 자기 자신이 되는 수는 놀랍게도 단 세 개밖에 없습니다.
		 * 
		 * 1634 = 1^4 + 6^4 + 3^4 + 4^4 8208 = 8^4 + 2^4 + 0^4 + 8^4 9474 = 9^4
		 * + 4^4 + 7^4 + 4^4 (1 = 1^4의 경우는 엄밀히 말해 합이 아니므로 제외합니다)
		 * 
		 * 위의 세 숫자를 모두 더하면 1634 + 8208 + 9474 = 19316 입니다.
		 * 
		 * 그렇다면, 각 자리 숫자를 5제곱해서 더했을 때 자기 자신이 되는 수들의 합은 얼마입니까?
		 */
		long start = System.currentTimeMillis();
		int count = 0;
		int a = 10;
		ArrayList<String> result = new ArrayList<String>();
		while (a<=194979) {
			
//			System.out.println(a);
			
			ArrayList<String> sample = new ArrayList<String>();
			
			int length = (int)(Math.log10(a)+1);
			String aa = a+"";
			
			for (int i = 0; i < length; i++) {
				
				sample.add(aa.substring(i,i+1));
			}
			
			int sum = 0;
			
			for (int i = 0; i < sample.size(); i++) {
				int x = Integer.parseInt(sample.get(i));
//				System.out.println(a + " : " + x);
				sum += (x*x*x*x*x);
//				System.out.println(a + " : " + sum);
				if (a<sum) {
					break;
				}
			}
			
			if (a==sum) {
				System.out.println(a);
				result.add(a+"");
				count++;
				a++;
			}else {
				a++;
			}
			
			
		}
		int sum = 0;
		for (int i = 0; i <result.size(); i++) {
			System.out.println(result.get(i));
			sum += Integer.parseInt(result.get(i));
		}
		System.out.println(sum);
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

//		4150
//		4151
//		54748
//		92727
//		93084
//		194979
		
	}

}
