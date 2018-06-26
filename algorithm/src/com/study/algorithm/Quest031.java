package com.study.algorithm;

public class Quest031 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
영국의 화폐 단위는 파운드(£)와 펜스(p)이고, 동전의 종류는 아래와 같습니다.

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), £2 (200p)
이 동전들을 가지고 2파운드를 만드는 방법은 다양할 것입니다. 예를 하나 들면 이렇습니다.

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
2파운드를 만드는 서로 다른 방법은 모두 몇가지나 있습니까?
*/		
		int temp[] = {100,50,20,10,5,2,1};
		int nums[] = new int[7];
		int maxs[] = {2,4,10,20,40,100,200};
		int num100,num50,num20,num10,num5,num2,num1 = 0;
		int count =0;
		
//		7가지
//		200/100 
//		2개였을 경우 1가지 
//		1개였을 경우 100 / 50
//		0개였을 경우 
		
//		200- (a&j) == j
//		
		
//		for (int i = 1; i < 200; i++) {
//			if (200%i==0) {
//				System.out.println(i);
//			}
//		}
		int sample = 200;
		int a = 2;
		while (true) {
			
			if (sample % a == 0 ) {
				sample = sample/a;
				System.out.print(a + " " );
				a=2;
			}
			else {
				a++;
			}
			
			if (sample<2) {
				break;
			}
			
		}
		
		
//		for (int i = 0; i < 7; i++) {
//			
////			count += 200/temp[i];
//			count++;
//			
//			
//			for (int j = 200/temp[i]-1; j >= 0; j--) {
//				int sample = 200 - (j*temp[i]);
//
//				int a = i+1;
//				while (true) {
//					count += sample/temp[a];
//					
//					if (sample/temp[a] > 1) {
//						
//					}
//					
//					if (a == 6) {
//						count += sample/a;
//						break;
//					}else {
//						a++;
//					}
//					
//				}
//				
//			}
//			
//			
//		}
		
//		200/50 = 4가지
		
//		for (int i = 0; i < temp.length; i++) {
//			for (int j = 0; j < nums.length; j++) {
//				nums[j] =0;
//			}
//			
//			for (int j = 0; j < maxs[i]; j++) {
//				nums[i]=j;
//				if (nums[i]*temp[i]==200) {
//					count++;
//				}else {
//					
//				}
//			}
//		}
		
//		
		
		
	}

}
