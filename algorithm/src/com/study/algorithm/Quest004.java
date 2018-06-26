package com.study.algorithm;

import java.lang.Character.Subset;

public class Quest004 {

	public static void main(String[] args) {
		/*앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부릅니다.

		두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 입니다.

		세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?*/

		int result = 0;
		
			
		for (int i = 999; i > 333; i--) {
			for (int j =999; j > 333; j--) {
				int temp =i * j; 
				
				String equ = ""+temp ;

//				System.out.println(equ.substring(0,1) + ":" + equ.substring(equ.length()-1,equ.length()));
//				System.out.println(equ.substring(1,2) + ":" + equ.substring(equ.length()-2,equ.length()-1));
//				System.out.println(equ.substring(2,3) + ":" + equ.substring(equ.length()-3,equ.length()-2));
				
				
				
				if (equ.length() %2 ==0) {
					if(equ.substring(0,1).equals(equ.substring(equ.length()-1,equ.length()))
							&& equ.substring(1,2).equals(equ.substring(equ.length()-2,equ.length()-1))
							&& equ.substring(2,3).equals(equ.substring(equ.length()-3,equ.length()-2))
							)
					{
						if(temp > result)
							result = temp;
					}
					
				}
				else {
					if(equ.substring(0,1).equals(equ.substring(equ.length()-1,equ.length()))
							&&equ.substring(1,2).equals(equ.substring(equ.length()-2,equ.length()-1))
							&&equ.substring(2,3).equals(equ.substring(equ.length()-3,equ.length()-2))
							)
					{
						if(temp > result)
							result = temp;
					}
				}
			}
		}
		
		System.out.println(result);
		
	}

}
