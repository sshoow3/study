package com.study.algorithm;

import java.math.BigInteger;

public class Quest026 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
분자가 1인 분수를 단위분수라고 합니다. 분모가 2에서 10까지의 단위분수는 아래와 같습니다.

1/2  0.5
1/3  0.33333333            0.3  .3
1/4  0.25
1/5  0.2
1/6  0.166666666666        0.16.  .6
1/7  0.142857
1/8
1/9
1/10

숫자 위에 찍힌 점은 순환마디를 나타내는데, 1/6의 경우 순환마디는 "6"으로 0.166666...처럼 6이 무한히 반복됨을 뜻합니다. 같은 식으로 1/7은 6자리의 순환마디(142857)를 가집니다.

d 를 1000 이하의 정수라고 할 때, 단위분수 1/d 의 순환마디가 가장 긴 수는 무엇입니까?
*/		
//		BigInteger a = new BigInteger();
		int count = 1;
		for (double i = 1; i <= 1000; i++) {
			double sample = 1/i;
//			System.out.printf("%4d :  %.20f\n",count++ , sample);
			System.out.printf("%4d :  %.*s \n",count++,sample);
		}
		
		
	}
}
