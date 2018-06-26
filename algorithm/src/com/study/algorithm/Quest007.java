package com.study.algorithm;

public class Quest007 {
	public static void main(String[] args) {
		/*
		소수를 크기 순으로 나열하면 2, 3, 5, 7, 11, 13, ... 과 같이 됩니다.

		이 때 10,001번째의 소수를 구하세요.
		*/
		
		long result = 0;
		
		long count =0;
		
		
//		for (long i = 2; i < args.length; i++) {
//			for (long j = 2; j < args.length; j++) {
//				if (i%j==0 && i != j ) {
//					break;
//				}
//				else if (i%j==0 && i == j) {
//					count++;
//				}
//			}
//		}
		long i = 2;
		while (true) {
			
			
			for (long j = 2; j <= i; j++) {
				if (i%j == 0 && i != j ) {
					break;
				}
				else if (i%j==0 && i == j) {
					count++;
					System.out.println(count + " : " + i + " : " + j);
				}
			}
			i++;
			
			if (count ==10001) {

				System.out.println(result = i);
				break;
			}
			
			
			
		}
		
		
	}
}
