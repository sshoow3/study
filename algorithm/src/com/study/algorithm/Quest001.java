package com.study.algorithm;

public class Quest001 {
	
		public static void main(String[] args)
		{
			
			int result = 0;
			
			for(int num = 1 ; num<1000 ;  num++)
			{
				if(num %3 == 0  || num %5 == 0)
					result += num ;
			}

			System.out.printf("1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?\n");
			System.out.printf("정답은 : " + result);
			
		}

}
