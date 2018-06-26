package com.study.algorithm;

import java.math.BigInteger;

public class Quest015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*아래와 같은 2 × 2 격자의 왼쪽 위 모서리에서 출발하여 오른쪽 아래 모서리까지 도달하는 길은 모두 6가지가 있습니다 (거슬러 가지는 않기로 합니다).
 *  _ _
 * |_|_|
 * | | |
 *  - -
 *  1 2 3 2 1
 *  2 2 2 1   4 가지
 *  2 2 1 1   2 가지
 *  _ _ _ 
 * |_|_|_|
 * |_|_|_|
 * |_|_|_|
 *  
 *  1 2 3 4 3 2 1
 *  
 *  2 , (1,2,1) , (1,2,2,1) ,(2,2,2) , (2,2) 1
 *  
 *  
 *  2 2 2 2 1  8
 *  2 2 2 1 1  4
 *  2 2 1 1 1  2
그러면 20 × 20 격자에는 모두 몇 개의 경로가 있습니까?*/
		
		
		
//		40
		
//		▽ 20번 ▷ 20번
//		2x2 = 6가지
//		3x3 = 20가지
		
//		aaabbb   bbbaaa
		
//		aababb   bbabaa
//		aabbab   bbaaba
//		aabbba   bbaaab
		
//		abaabb   babbaa
//		ababab   bababa
//		ababba   babaab
		
//		abbaab   baabba		
//		abbaba   baabab
//		abbbaa   baaabb
		
		for (int i = 2; i <= 20; i++) {
			
			BigInteger temp = new BigInteger("1");
			
			for (int j = 1; j <= i*2; j++) {
				temp = temp.multiply(new BigInteger(j+"")) ;
			}
			
			for (int j = i; j > 1; j--) {
				temp = temp.divide(new BigInteger(j+""));
			}
			for (int j = i; j > 1; j--) {
				temp = temp.divide(new BigInteger(j+""));
			}
			System.out.println("["+i + "] : [" + i +"] =" +temp );
		}
		
		
		
		
	}

}
