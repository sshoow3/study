package com.study.algorithm;

public class Quest027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 오일러는 다음과 같은 멋진 2차식을 제시했습니다.
		 * 
		 * n2 + n + 41 이 식의 n에다 0부터 39 사이의 숫자를 넣으면, 그 결과는 모두 소수가 됩니다. 하지만 n =
		 * 40일 때의 값 402 + 40 + 41 은 40×(40 + 1) + 41 이므로 41로 나누어지고, n = 41일 때 역시
		 * 412 + 41 + 41 이므로 소수가 아닙니다.
		 * 
		 * 컴퓨터의 발전에 힘입어 n2 − 79n + 1601 이라는 엄청난 2차식이 발견되었는데, 이것은 n이 0에서 79 사이일 때
		 * 모두 80개의 소수를 만들어냅니다. 이 식의 계수의 곱은 -79 × 1601 = -126479가 됩니다.
		 * 
		 * 아래와 같은 모양의 2차식이 있다고 가정했을 때,
		 * 
		 * n2 + an + b (단 | a | < 1000, | b | < 1000) 0부터 시작하는 연속된 n에 대해 가장 많은
		 * 소수를 만들어내는 2차식을 찾아서, 그 계수 a와 b의 곱을 구하세요.
		 */

		long start = System.currentTimeMillis();
		int temp[][] = new int[2000][2000];
		boolean[][] result = new boolean[2000][2000];

		for (int i = -999; i < 1000; i++) {

			for (int j = -999; j < 1000; j++) {

				// temp[i+1000][j+1000]

				boolean check = true;
				int n = 0;
				while (check) {

					
					int oiler = (n * (n + i)) + j;

					if (oiler < 2) {
						temp[i + 1000][j + 1000] = 0;
						check = false;
						break;
					} else if (oiler == 2) {
						temp[i + 1000][j + 1000] = 1;
						check = false;
						break;
					} else {
						for (int k = 2; k < oiler; k++) {
							if (oiler % k == 0) {
								temp[i + 1000][j + 1000] = n;
								check = false;
								n=0;
								break;
							}
						}
						
						if (check)
						{
//							System.out.println(check + " : " + n);
							temp[i + 1000][j + 1000] = n++;
						}
							

					}
					
				}
			}
		}
		// System.out.println(i);

		int big = 0;
		int result1 = 0;
		int result2 = 0;

		for (int i = 0; i < 2000; i++) {
			for (int j = 0; j < 2000; j++) {
				if (big < temp[i][j]) {
					big = temp[i][j];
					result1 = i;
					result2 = j;
				}
			}
		}

		System.out.println(big);
		System.out.println(result1-1000);
		System.out.println(result2-1000);
		System.out.println((result1-1000) * (result2-1000));
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

		
//		71
//		-61
//		971
//		-59231

	}

}
