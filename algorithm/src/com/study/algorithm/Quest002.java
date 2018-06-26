package com.study.algorithm;

public class Quest002 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.

		1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
		짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?
*/
		int num = 0;
		
		int num1 = 1 ;
		int num2 = 2 ;
		
		int result = num2;
		

		System.out.printf("1항 " + num1 + "\n" );
		System.out.printf("2항 : " + num2  + "\n" );
		
		int count = 2;
		
		
		while (num2 < 4000000) {
			
			

			num = num1 ;
			num1 = num2 ;
			num2 = num + num1;
			
			System.out.printf("%d항 : " + num2 + "\n"  ,++count);
			
			if(num2 < 4000000 && num2%2 == 0)
				result += num2;
			
		}
		
		System.out.printf("결과는 : " + result );

	}

}