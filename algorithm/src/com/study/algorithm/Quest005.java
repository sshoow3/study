package com.study.algorithm;

import java.util.Map;

public class Quest005 {
	public static void main(String[] args) {
		/*
		 * 1 ~ 10 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520입니다.
		 * 
		 * 그러면 1 ~ 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 얼마입니까?
		 */

		// 나중에 다시 생각

		String[] sample = new String[21];

		for (int i = 0; i < sample.length; i++) {
			sample[i] = i + " : ";
		}

		for (int i = 2; i < 21; i++) {

			int temp = 0;
			int cal = i;

			int a = 0;

			for (int j = 2; j <= i; j++) {

				if (cal == j) {
					temp++;
					cal = cal / j;

					sample[i] = sample[i] + "|" + j;

				} else if (cal % j == 0) {

					temp++;
					cal = cal / j;

					sample[i] = sample[i] + "|" + j;
					j--;
				}
			}

		}

		int result = 1;

		for (int i = 0; i < sample.length; i++) {
			System.out.println(sample[i]);
		}
		
		result = 16*9*5*7*11*13*17*19;

		System.out.println("result : " + result);

	}
}
