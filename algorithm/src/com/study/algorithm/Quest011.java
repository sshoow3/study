package com.study.algorithm;

public class Quest011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
아래와 같은 20×20 격자가 있습니다.

08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
위에서 대각선 방향으로 연속된 붉은 숫자 네 개의 곱은 26 × 63 × 78 × 14 = 1788696 입니다.

그러면 수평, 수직, 또는 대각선 방향으로 연속된 숫자 네 개의 곱 중 최대값은 얼마입니까?
*/		

		int [][] sample = new int[20][20];
		sample [ 0][ 0] = 8 ;  sample [ 0][ 1] = 2 ;  sample [ 0][ 2] =22 ;  sample [ 0][ 3] =97 ;  sample [ 0][ 4] =38 ;  sample [ 0][ 5] =15 ;  sample [ 0][ 6] =0  ;  sample [ 0][ 7] =40 ;  sample [ 0][ 8] =0  ;  sample [ 0][ 9] =75 ;  sample [ 0][10] =4  ;  sample [ 0][11] =5  ;  sample [ 0][12] =7  ;  sample [ 0][13] =78 ;  sample [ 0][14] = 52 ;  sample [ 0][15] =12;  sample [ 0][16] = 50 ;  sample [ 0][17] =77 ;  sample [ 0][18] =91 ;  sample [ 0][19] =8  ;  
		sample [ 1][ 0] = 49;  sample [ 1][ 1] = 49;  sample [ 1][ 2] =99 ;  sample [ 1][ 3] =40 ;  sample [ 1][ 4] =17 ;  sample [ 1][ 5] =81 ;  sample [ 1][ 6] =18 ;  sample [ 1][ 7] =57 ;  sample [ 1][ 8] =60 ;  sample [ 1][ 9] =87 ;  sample [ 1][10] =17 ;  sample [ 1][11] =40 ;  sample [ 1][12] =98 ;  sample [ 1][13] =43 ;  sample [ 1][14] = 69 ;  sample [ 1][15] =48;  sample [ 1][16] = 4  ;  sample [ 1][17] =56 ;  sample [ 1][18] =62 ;  sample [ 1][19] =0  ;  
		sample [ 2][ 0] = 81;  sample [ 2][ 1] = 49;  sample [ 2][ 2] =31 ;  sample [ 2][ 3] =73 ;  sample [ 2][ 4] =55 ;  sample [ 2][ 5] =79 ;  sample [ 2][ 6] =14 ;  sample [ 2][ 7] =29 ;  sample [ 2][ 8] =93 ;  sample [ 2][ 9] =71 ;  sample [ 2][10] =40 ;  sample [ 2][11] =67 ;  sample [ 2][12] =53 ;  sample [ 2][13] =88 ;  sample [ 2][14] = 30 ;  sample [ 2][15] =3 ;  sample [ 2][16] = 49 ;  sample [ 2][17] =13 ;  sample [ 2][18] =36 ;  sample [ 2][19] =65 ;  
		sample [ 3][ 0] = 52;  sample [ 3][ 1] = 70;  sample [ 3][ 2] =95 ;  sample [ 3][ 3] =23 ;  sample [ 3][ 4] =4  ;  sample [ 3][ 5] =60 ;  sample [ 3][ 6] =11 ;  sample [ 3][ 7] =42 ;  sample [ 3][ 8] =69 ;  sample [ 3][ 9] =24 ;  sample [ 3][10] =68 ;  sample [ 3][11] =56 ;  sample [ 3][12] =1  ;  sample [ 3][13] =32 ;  sample [ 3][14] = 56 ;  sample [ 3][15] =71;  sample [ 3][16] = 37 ;  sample [ 3][17] =2  ;  sample [ 3][18] =36 ;  sample [ 3][19] =91 ;  
		sample [ 4][ 0] = 22;  sample [ 4][ 1] = 31;  sample [ 4][ 2] =16 ;  sample [ 4][ 3] =71 ;  sample [ 4][ 4] =51 ;  sample [ 4][ 5] =67 ;  sample [ 4][ 6] =63 ;  sample [ 4][ 7] =89 ;  sample [ 4][ 8] =41 ;  sample [ 4][ 9] =92 ;  sample [ 4][10] =36 ;  sample [ 4][11] =54 ;  sample [ 4][12] =22 ;  sample [ 4][13] =40 ;  sample [ 4][14] = 40 ;  sample [ 4][15] =28;  sample [ 4][16] = 66 ;  sample [ 4][17] =33 ;  sample [ 4][18] =13 ;  sample [ 4][19] =80 ;  
		sample [ 5][ 0] = 24;  sample [ 5][ 1] = 47;  sample [ 5][ 2] =32 ;  sample [ 5][ 3] =60 ;  sample [ 5][ 4] =99 ;  sample [ 5][ 5] =3  ;  sample [ 5][ 6] =45 ;  sample [ 5][ 7] =2  ;  sample [ 5][ 8] =44 ;  sample [ 5][ 9] =75 ;  sample [ 5][10] =33 ;  sample [ 5][11] =53 ;  sample [ 5][12] =78 ;  sample [ 5][13] =36 ;  sample [ 5][14] = 84 ;  sample [ 5][15] =20;  sample [ 5][16] = 35 ;  sample [ 5][17] =17 ;  sample [ 5][18] =12 ;  sample [ 5][19] =50 ;  
		sample [ 6][ 0] = 32;  sample [ 6][ 1] = 98;  sample [ 6][ 2] =81 ;  sample [ 6][ 3] =28 ;  sample [ 6][ 4] =64 ;  sample [ 6][ 5] =23 ;  sample [ 6][ 6] =67 ;  sample [ 6][ 7] =10 ;  sample [ 6][ 8] =26 ;  sample [ 6][ 9] =38 ;  sample [ 6][10] =40 ;  sample [ 6][11] =67 ;  sample [ 6][12] =59 ;  sample [ 6][13] =54 ;  sample [ 6][14] = 70 ;  sample [ 6][15] =66;  sample [ 6][16] = 18 ;  sample [ 6][17] =38 ;  sample [ 6][18] =64 ;  sample [ 6][19] =70 ;  
		sample [ 7][ 0] = 67;  sample [ 7][ 1] = 26;  sample [ 7][ 2] =20 ;  sample [ 7][ 3] =68 ;  sample [ 7][ 4] =2  ;  sample [ 7][ 5] =62 ;  sample [ 7][ 6] =12 ;  sample [ 7][ 7] =20 ;  sample [ 7][ 8] =95 ;  sample [ 7][ 9] =63 ;  sample [ 7][10] =94 ;  sample [ 7][11] =39 ;  sample [ 7][12] =63 ;  sample [ 7][13] =8  ;  sample [ 7][14] = 40 ;  sample [ 7][15] =91;  sample [ 7][16] = 66 ;  sample [ 7][17] =49 ;  sample [ 7][18] =94 ;  sample [ 7][19] =21 ;  
		sample [ 8][ 0] = 24;  sample [ 8][ 1] = 55;  sample [ 8][ 2] =58 ;  sample [ 8][ 3] =5  ;  sample [ 8][ 4] =66 ;  sample [ 8][ 5] =73 ;  sample [ 8][ 6] =99 ;  sample [ 8][ 7] =26 ;  sample [ 8][ 8] =97 ;  sample [ 8][ 9] =17 ;  sample [ 8][10] =78 ;  sample [ 8][11] =78 ;  sample [ 8][12] =96 ;  sample [ 8][13] =83 ;  sample [ 8][14] = 14 ;  sample [ 8][15] =88;  sample [ 8][16] = 34 ;  sample [ 8][17] =89 ;  sample [ 8][18] =63 ;  sample [ 8][19] =72 ;  
		sample [ 9][ 0] = 21;  sample [ 9][ 1] = 36;  sample [ 9][ 2] =23 ;  sample [ 9][ 3] =9  ;  sample [ 9][ 4] =75 ;  sample [ 9][ 5] =0  ;  sample [ 9][ 6] =76 ;  sample [ 9][ 7] =44 ;  sample [ 9][ 8] =20 ;  sample [ 9][ 9] =45 ;  sample [ 9][10] =35 ;  sample [ 9][11] =14 ;  sample [ 9][12] =0  ;  sample [ 9][13] =61 ;  sample [ 9][14] = 33 ;  sample [ 9][15] =97;  sample [ 9][16] = 34 ;  sample [ 9][17] =31 ;  sample [ 9][18] =33 ;  sample [ 9][19] =95 ;  
		sample [10][ 0] = 78;  sample [10][ 1] = 17;  sample [10][ 2] =53 ;  sample [10][ 3] =28 ;  sample [10][ 4] =22 ;  sample [10][ 5] =75 ;  sample [10][ 6] =31 ;  sample [10][ 7] =67 ;  sample [10][ 8] =15 ;  sample [10][ 9] =94 ;  sample [10][10] =3  ;  sample [10][11] =80 ;  sample [10][12] =4  ;  sample [10][13] =62 ;  sample [10][14] = 16 ;  sample [10][15] =14;  sample [10][16] = 9  ;  sample [10][17] =53 ;  sample [10][18] =56 ;  sample [10][19] =92 ;  
		sample [11][ 0] = 16;  sample [11][ 1] = 39;  sample [11][ 2] =5  ;  sample [11][ 3] =42 ;  sample [11][ 4] =96 ;  sample [11][ 5] =35 ;  sample [11][ 6] =31 ;  sample [11][ 7] =47 ;  sample [11][ 8] =55 ;  sample [11][ 9] =58 ;  sample [11][10] =88 ;  sample [11][11] =24 ;  sample [11][12] =0  ;  sample [11][13] =17 ;  sample [11][14] = 54 ;  sample [11][15] =24;  sample [11][16] = 36 ;  sample [11][17] =29 ;  sample [11][18] =85 ;  sample [11][19] =57 ;  
		sample [12][ 0] = 86;  sample [12][ 1] = 56;  sample [12][ 2] =0  ;  sample [12][ 3] =48 ;  sample [12][ 4] =35 ;  sample [12][ 5] =71 ;  sample [12][ 6] =89 ;  sample [12][ 7] =7  ;  sample [12][ 8] =5  ;  sample [12][ 9] =44 ;  sample [12][10] =44 ;  sample [12][11] =37 ;  sample [12][12] =44 ;  sample [12][13] =60 ;  sample [12][14] = 21 ;  sample [12][15] =58;  sample [12][16] = 51 ;  sample [12][17] =54 ;  sample [12][18] =17 ;  sample [12][19] =58 ;  
		sample [13][ 0] = 19;  sample [13][ 1] = 80;  sample [13][ 2] =81 ;  sample [13][ 3] =68 ;  sample [13][ 4] =5  ;  sample [13][ 5] =94 ;  sample [13][ 6] =47 ;  sample [13][ 7] =69 ;  sample [13][ 8] =28 ;  sample [13][ 9] =73 ;  sample [13][10] =92 ;  sample [13][11] =13 ;  sample [13][12] =86 ;  sample [13][13] =52 ;  sample [13][14] = 17 ;  sample [13][15] =77;  sample [13][16] = 4  ;  sample [13][17] =89 ;  sample [13][18] =55 ;  sample [13][19] =40 ;  
		sample [14][ 0] = 4 ;  sample [14][ 1] = 52;  sample [14][ 2] =8  ;  sample [14][ 3] =83 ;  sample [14][ 4] =97 ;  sample [14][ 5] =35 ;  sample [14][ 6] =99 ;  sample [14][ 7] =16 ;  sample [14][ 8] =7  ;  sample [14][ 9] =97 ;  sample [14][10] =57 ;  sample [14][11] =32 ;  sample [14][12] =16 ;  sample [14][13] =26 ;  sample [14][14] = 26 ;  sample [14][15] =79;  sample [14][16] = 33 ;  sample [14][17] =27 ;  sample [14][18] =98 ;  sample [14][19] =66 ;  
		sample [15][ 0] = 88;  sample [15][ 1] = 36;  sample [15][ 2] =68 ;  sample [15][ 3] =87 ;  sample [15][ 4] =57 ;  sample [15][ 5] =62 ;  sample [15][ 6] =20 ;  sample [15][ 7] =72 ;  sample [15][ 8] =3  ;  sample [15][ 9] =46 ;  sample [15][10] =33 ;  sample [15][11] =67 ;  sample [15][12] =46 ;  sample [15][13] =55 ;  sample [15][14] = 12 ;  sample [15][15] =32;  sample [15][16] = 63 ;  sample [15][17] =93 ;  sample [15][18] =53 ;  sample [15][19] =69 ;  
		sample [16][ 0] = 4 ;  sample [16][ 1] = 42;  sample [16][ 2] =16 ;  sample [16][ 3] =73 ;  sample [16][ 4] =38 ;  sample [16][ 5] =25 ;  sample [16][ 6] =39 ;  sample [16][ 7] =11 ;  sample [16][ 8] =24 ;  sample [16][ 9] =94 ;  sample [16][10] =72 ;  sample [16][11] =18 ;  sample [16][12] =8  ;  sample [16][13] =46 ;  sample [16][14] = 29 ;  sample [16][15] =32;  sample [16][16] = 40 ;  sample [16][17] =62 ;  sample [16][18] =76 ;  sample [16][19] =36 ;  
		sample [17][ 0] = 20;  sample [17][ 1] = 69;  sample [17][ 2] =36 ;  sample [17][ 3] =41 ;  sample [17][ 4] =72 ;  sample [17][ 5] =30 ;  sample [17][ 6] =23 ;  sample [17][ 7] =88 ;  sample [17][ 8] =34 ;  sample [17][ 9] =62 ;  sample [17][10] =99 ;  sample [17][11] =69 ;  sample [17][12] =82 ;  sample [17][13] =67 ;  sample [17][14] = 59 ;  sample [17][15] =85;  sample [17][16] = 74 ;  sample [17][17] =4  ;  sample [17][18] =36 ;  sample [17][19] =16 ;  
		sample [18][ 0] = 20;  sample [18][ 1] = 73;  sample [18][ 2] =35 ;  sample [18][ 3] =29 ;  sample [18][ 4] =78 ;  sample [18][ 5] =31 ;  sample [18][ 6] =90 ;  sample [18][ 7] =1  ;  sample [18][ 8] =74 ;  sample [18][ 9] =31 ;  sample [18][10] =49 ;  sample [18][11] =71 ;  sample [18][12] =48 ;  sample [18][13] =86 ;  sample [18][14] = 81 ;  sample [18][15] =16;  sample [18][16] = 23 ;  sample [18][17] =57 ;  sample [18][18] =5  ;  sample [18][19] =54 ;  
		sample [19][ 0] = 1 ;  sample [19][ 1] = 70;  sample [19][ 2] =54 ;  sample [19][ 3] =71 ;  sample [19][ 4] =83 ;  sample [19][ 5] =51 ;  sample [19][ 6] =54 ;  sample [19][ 7] =69 ;  sample [19][ 8] =16 ;  sample [19][ 9] =92 ;  sample [19][10] =33 ;  sample [19][11] =48 ;  sample [19][12] =61 ;  sample [19][13] =43 ;  sample [19][14] = 52 ;  sample [19][15] =1 ;  sample [19][16] = 89 ;  sample [19][17] =19 ;  sample [19][18] =67 ;  sample [19][19] =48 ;  

		
		int result =0;
		
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				int temp1 = sample[i][j]*sample[i][j+1]*sample[i][j+2]*sample[i][j+3];
				int temp2 = sample[i][j]*sample[i+1][j]*sample[i+2][j]*sample[i+3][j];
				int temp3 = sample[i][j]*sample[i+1][j+1]*sample[i+2][j+2]*sample[i+3][j+3];
				int temp4 = sample[i][j+3]*sample[i+1][j+2]*sample[i+2][j+1]*sample[i+3][j];
				
				if (temp1>result) 
					result = temp1;
				if (temp2>result) 
					result = temp2;
				if (temp3>result) 
					result = temp3;
				if (temp4>result) 
					result = temp4;
				System.out.println(result);
			}
		}
		
		System.out.println(result);
	}

}
