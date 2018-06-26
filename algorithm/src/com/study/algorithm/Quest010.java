package com.study.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Quest010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 10 이하의 소수를 모두 더하면 2 + 3 + 5 + 7 = 17 이 됩니다.
	
	이백만(2,000,000) 이하 소수의 합은 얼마입니까?
*/		
		long start = System.currentTimeMillis();
		
		boolean[] not = new boolean[2000001];
		Arrays.fill(not, true);
		String aa = "";



		long result = 0;
		for (int i = 2; i < 2000000; i++) {
			
			if (not[i]) {
				for (int j = 2; j <= i; j++) {
					
					if (i%j == 0 && i != j) {
						break;
					}
					else if(i%j == 0 && i == j){
						result += i;
						aa += i+" ";
						
						int a = 1;
						while (a*i<=2000000) {
							not[(a++)*i] = false;
							
						}
//						System.out.println(i+":"+result);
					}
					
				}
			}
		}
		

		System.out.println(result);
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
//		142913828922
//		실행 시간 : 736.135
		
//		142913828922
//		실행 시간 : 879.343
		
	}

}
