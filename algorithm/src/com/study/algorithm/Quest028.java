package com.study.algorithm;

public class Quest028 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
숫자 1부터 시작해서 우측으로부터 시계방향으로 감아 5×5 행렬을 만들면 아래와 같이 됩니다.

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

여기서 대각선상의 숫자를 모두 더한 값은 101 입니다.

같은 방식으로 1001×1001 행렬을 만들었을 때, 대각선상의 숫자를 더하면 얼마가 됩니까?
*/		
//		1 중앙
//		2 중앙 +가로1 || 중앙 +가로1+세로1 
//		중앙+세로1 중앙+세로1-가로1 
//		중앙-가로1 중앙-가로1-세로1 
//		중앙-세로1 중앙-세로1+가로1
		
//		x,y     x+i,y		>
//		x+i,y   x+i,y+i		▽
//		x+i,y+i,x-i,y+i		<
//		x-i,y+i,x-i,y-i		△
//		x-i,y-i,x+i,y-i		>
		
		int temp[][] = new int[1001][1001];
		temp[500][500] = 1;
		int count =2;
		
		long start = System.currentTimeMillis();
		
		
		while (true) {
			
			for (int i = 1; i <= 500; i++) {
//				x,y     x+i,y		>
				temp[500+i][500-i+1] = count++;
//				System.out.println((500+i) + " : " + (500) + " i " +i + "     | count |" +(count-1));

//				x+i,y   x+i,y+i		▽			
				for (int j = 1; j <= (i*2)-1; j++) {
					temp[500+i][500+j-i+1] = count++;
//					System.out.println((500+i) + " : " + (500+j) + " i " +i +" j " + j + " | count |" +(count-1));

				}
//				x+i,y+i,x-i,y+i		<
				for (int j = 1; j <= i*2 ; j++) {
					temp[500+i-j][500+i] = count++;
//					System.out.println((500+i-j) + " : " + (500+i) + " i " +i +" j " + j + " | count |" +(count-1));

				}
//				x-i,y+i,x-i,y-i		△
				for (int j = 1; j <= i*2 ; j++) {
					temp[500-i][500+i-j] = count++;
//					System.out.println((500-i) + " : " + (500+i-j) + " i " +i +" j "  + j + " | count |" +(count-1));

				}
//				x-i,y-i,x+i,y-i		>
				for (int j = 1; j <= i*2 ; j++) {
					temp[500-i+j][500-i] = count++;
//					System.out.println((500-i+j) + " : " + (500-i) + " i " +i +" j " + j + " | count |" +(count-1));

				}
				
			}
			
			
			
			break;
			
			
			
		}
		
		int sum = 0;
		
		for (int i = 495; i <= 505; i++) {
			for (int j = 495; j <= 505; j++) {
				System.out.printf("%3d " ,temp[j][i]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (i==j) {
					System.out.println("["+i+"]["+j+"] : " +temp[i][j] );
					sum+=temp[i][j];
				}
//				else if (i-(1001-j)==0) {
				else if (i+j==1000) {
					System.out.println("["+i+"]["+j+"] : " +temp[i][j] );
					sum+=temp[i][j];
				}
			}
		}
//
		System.out.println(temp[1000][0]);
		System.out.println(temp[0][1000]);
		System.out.println(temp[0][0]);
		System.out.println(temp[1000][1000]);
		System.out.println(temp[500][500]);
		System.out.println(temp[501][501]);
		
//		for (int i = 1; i <= 500; i++) {
//			System.out.println(temp[500][500+i]);
//		}
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

//		439002253
//		669171000
		
//		for (int i = 0; i < 1001; i++) {
//			for (int j = 0; j < 1001; j++) {
//				if (i==j) {
//					System.out.println(temp[i][j] + " ");
////					sum+=temp[i][j];
//				}
////				else if (i-(1001-j)==0) {
//				else if (i+j==1001) {
//					System.out.println(temp[i][j] + " ");
////					sum+=temp[i][j];
//				}
//				else {
//					System.out.println(" ");
//				}
//			}
		// }

	}

}
