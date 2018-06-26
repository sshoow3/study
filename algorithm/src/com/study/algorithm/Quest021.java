package com.study.algorithm;

public class Quest021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
n의 약수들 중에서 자신을 제외한 것의 합을 d(n)으로 정의했을 때,
서로 다른 두 정수 a, b에 대하여 d(a) = b 이고 d(b) = a 이면 
a, b는 친화쌍이라 하고 a와 b를 각각 친화수(우애수)라고 합니다.

예를 들어 220의 약수는 자신을 제외하면 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 이므로 그 합은 d(220) = 284 입니다.
또 284의 약수는 자신을 제외하면 1, 2, 4, 71, 142 이므로 d(284) = 220 입니다.
따라서 220과 284는 친화쌍이 됩니다.

10000 이하의 친화수들을 모두 찾아서 그 합을 구하세요.
*/		
		int a = 220;
		String b = "";
		int temp = 0;
		for (int i = 1; i < a; i++) {
			if (a%i == 0) {
				b += " "+i;
				temp += i;
			}
		}
		
		System.out.println(temp);
		
		String results = "";
		int result = 0;
		
		for (int i = 2; i < 10000; i++) {
			int sum =0;
			for (int j = 1; j < i; j++) {
				if (i%j==0) {
					sum+=j;
				}
			}
			
			if (sum <10000) {
				int sample = 0;
				for (int j = 1; j < sum; j++) {
					if (sum% j ==0) {
						sample += j;
					}
				}
				if (sample == i && sum != sample) {
					results += i + " : " + sum + "\n"  ;
					result += i;
				}
				
			}
			
		}

		System.out.println(results);
		System.out.println(result);
	}

}
