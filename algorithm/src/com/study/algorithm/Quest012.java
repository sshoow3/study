package com.study.algorithm;

public class Quest012 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
1부터 n까지의 자연수를 차례로 더하여 구해진 값을 삼각수라고 합니다.
예를 들어 7번째 삼각수는 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28이 됩니다.
이런 식으로 삼각수를 구해 나가면 다음과 같습니다.

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
이 삼각수들의 약수를 구해봅시다.

 1: 1
 3: 1, 3
 6: 1, 2, 3, 6
10: 1, 2, 5, 10
15: 1, 3, 5, 15
21: 1, 3, 7, 21
28: 1, 2, 4, 7, 14, 28
위에서 보듯이, 5개 이상의 약수를 갖는 첫번째 삼각수는 28입니다.

그러면 500개 이상의 약수를 갖는 가장 작은 삼각수는 얼마입니까?
*/
		// 100 1 2 4 5 10 20 25
		
		
		boolean resultb = true;
		int result = 1;
//		String results = "";
		int sum = 0;
		int max = 0;
		while (resultb) {
			
			

			int count = 0;
			
			
			sum=result*(result+1)/2;
			/*
			
			i = 1부터 N의 제곱근까지 1씩 증가한다.
			N이 i로 나눠지면, 약수의 개수를 +2 증가시킨다.
			N이 완전 제곱수인 경우라면 약수 1개(제곱근)를 중복으로 센 것이기 때문에 1을 빼준다.*/

			
			
			
			System.out.print(sum +" : ");
//			for (int i = 1; i <= sum; i++) {
//				if (sum % i == 0) 
//				{
//					count++;
////					results += i+"";
////					System.out.print(i + "  ");
//				}
//			}
			/*F(n) = n(n+1)/2
			즉. F(n)의 약수는... 1,F(n), (n 또는 n/2), ((n+1) 또는 (n+1)/2),
			그리고 (n 또는 n/2), ((n+1) 또는 (n+1)/2)의 약수들과 그 약수들의 곱.
			이 중... 1은 모든 수의 약수이므로 중복.. F(n)은 (n 또는 n/2) * ((n+1) 또는 (n+1)/2) 이므로 제외....
			그러므로 F(n)의 약수는 (n 또는 n/2), ((n+1) 또는 (n+1)/2)의 약수들의 곱
			# 이 후 (n 또는 n/2) = X, ((n+1) 또는 (n+1)/2) = Y로 표기.
			서로 겹치지 않는 두 숫자군 M,L에서 양쪽에서 서로 하나씩의 수를 뽑아내 만들 수 있는 수의 수는 count(M) * count(L).
			연속한 두 수의 서로 약수들은 겹치는 수가 없겠지?? 1을 제외한 그 어떤수가 자연수와의 곱에서 1차이나는 두 수를 만들 수 는 없으니....
			4에 이어서... 연속한 두 수중 짝수를 2로 나눈 수의 약수들은 2로 나누기 전 약수로 이루어졌으므로 나누지 않은 다른 수와 1외에 약수가 겹치는 일은 없을 것....
			1~5까지의 결론으로 F(n)의 약수들의 수 = [X의 약수의 수 - 1] * [Y의 약수의 수 - 1] + [X의 약수 수 - 1] + [Y의 약수 수 - 1] + 1
			x * y + x + y + 1 = xy + x + y + 1 = x(y+1) + y+1 = (x+1) * (y+1)
			6,7번에 의해.. F(n)의 약수들의 수 = [X의 약수의 수] * [Y의 약수의 수]
			마찬가지로 어떤 수 T의 약수의 수는.. 곱해서 T가 나오는 두 수를 구해 위 8번 공식 대입.*/			
			int temp = (int) Math.sqrt(sum);
			
			for (int i = 1; i <=temp; i++) {
				
				if (sum%i==0) {
					System.out.print(i +" " + sum/i +" ");
					count++;
				}
			}
			
			count = count *2 - 1;
			
			//76576500

			System.out.println(max + ":"+count);
			

			if (count >= 500) {
				resultb = false;
			}else {
				result++;
//				if (max<count) {
//					max = count;
//				}
			}

			
		}
		System.out.println(sum);
		
	}

}
