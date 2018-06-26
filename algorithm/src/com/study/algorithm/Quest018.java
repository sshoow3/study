package com.study.algorithm;

import java.math.BigInteger;

public class Quest018 {
	
	static int temp[][] = new int [15][15];
	
	static{
		temp [0][0] = 75;                                                                                                                                                                                                                                                                  
		temp [1][0] = 95; temp [1][1] =  64;                                                                                                                                                                                                                                               
		temp [2][0] = 17; temp [2][1] =  47; temp [2][2] =82 ;                                                                                                                                                                                                                             
		temp [3][0] = 18; temp [3][1] =  35; temp [3][2] =87 ;temp [3][3] = 10;                                                                                                                                                                                                            
		temp [4][0] = 20; temp [4][1] =  04; temp [4][2] =82 ;temp [4][3] = 47; temp [4][4] = 65;                                                                                                                                                                                          
		temp [5][0] = 19; temp [5][1] =  01; temp [5][2] =23 ;temp [5][3] = 75; temp [5][4] = 03; temp [5][5] = 34;                                                                                                                                                                        
		temp [6][0] = 88; temp [6][1] =  02; temp [6][2] =77 ;temp [6][3] = 73; temp [6][4] = 07; temp [6][5] = 63; temp [6][6] = 67;                                                                                                                                                      
		temp [7][0] = 99; temp [7][1] =  65; temp [7][2] =04 ;temp [7][3] = 28; temp [7][4] = 06; temp [7][5] = 16; temp [7][6] = 70; temp [7][7] = 92;                                                                                                                                    
		temp [8][0] = 41; temp [8][1] =  41; temp [8][2] =26 ;temp [8][3] = 56; temp [8][4] = 83; temp [8][5] = 40; temp [8][6] = 80; temp [8][7] = 70; temp [8][8] =  33;                                                                                                                 
		temp [9][0] = 41; temp [9][1] =  48; temp [9][2] =72 ;temp [9][3] = 33; temp [9][4] = 47; temp [9][5] = 32; temp [9][6] = 37; temp [9][7] = 16; temp [9][8] =  94; temp [9][9] = 29;                                                                                               
		temp [10][0] =53 ;temp [10][1] =71 ;temp [10][2] =44 ;temp [10][3] =65 ;temp [10][4] =25 ;temp [10][5] =43 ;temp [10][6] =91 ;temp [10][7] =52 ;temp [10][8] = 97 ;temp [10][9] =51 ;temp [10][10] =14 ;                                                                           
		temp [11][0] =70 ;temp [11][1] =11 ;temp [11][2] =33 ;temp [11][3] =28 ;temp [11][4] =77 ;temp [11][5] =73 ;temp [11][6] =17 ;temp [11][7] =78 ;temp [11][8] = 39 ;temp [11][9] =68 ;temp [11][10] =17 ;temp [11][11] =57;                                                         
		temp [12][0] =91 ;temp [12][1] =71 ;temp [12][2] =52 ;temp [12][3] =38 ;temp [12][4] =17 ;temp [12][5] =14 ;temp [12][6] =91 ;temp [12][7] =43 ;temp [12][8] = 58 ;temp [12][9] =50 ;temp [12][10] =27 ;temp [12][11] =29;temp [12][12] =48 ;                                      
		temp [13][0] =63 ;temp [13][1] =66 ;temp [13][2] =04 ;temp [13][3] =68 ;temp [13][4] =89 ;temp [13][5] =53 ;temp [13][6] =67 ;temp [13][7] =30 ;temp [13][8] = 73 ;temp [13][9] =16 ;temp [13][10] =69 ;temp [13][11] =87;temp [13][12] =40 ;temp [13][13] =31 ;                   
		temp [14][0] =4 ;temp [14][1] =62 ;temp [14][2] =98 ;temp [14][3] =27 ;temp [14][4] =23 ;temp [14][5] = 9 ;temp [14][6] =70 ;temp [14][7] =98 ;temp [14][8] = 73 ;temp [14][9] =93 ;temp [14][10] =38 ;temp [14][11] =53;temp [14][12] =60 ;temp [14][13] =04 ;temp [14][14] = 23;
		
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

/*
다음과 같이 삼각형 모양으로 숫자를 배열했습니다.

3
7 4
2 4 6
8 5 9 3

삼각형의 꼭대기부터 아래쪽으로 인접한 숫자를 찾아 내려가면서 합을 구하면, 위의 그림처럼 3 + 7 + 4 + 9 = 23 이 가장 큰 합을 갖는 경로가 됩니다.

다음 삼각형에서 합이 최대가 되는 경로를 찾아서 그 합을 구하세요.


              75
             95 64
            17 47 82
           18 35 87 10
          20 04 82 47 65
         19 01 23 75 03 34
        88 02 77 73 07 63 67
       99 65 04 28 06 16 70 92
      41 41 26 56 83 40 80 70 33
     41 48 72 33 47 32 37 16 94 29
    53 71 44 65 25 43 91 52 97 51 14
   70 11 33 28 77 73 17 78 39 68 17 57
  91 71 52 38 17 14 91 43 58 50 27 29 48
 63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

참고: 여기서는 경로가 16384개밖에 안되기 때문에, 모든 경로의 합을 일일이 계산해서 답을 구하는 것이 가능합니다.
하지만 67번 문제에는 100층짜리 삼각형 배열이 나옵니다. 그런 경우에는 좀 더 현명한 풀이 방법을 찾아야겠지요.

15층  경우의수 15!
*/
//		int temp [][] = new int [15][15];
//		
//		temp [0][0] = 75;                                                                                                                                                                                                                                                                  
//		temp [1][0] = 95; temp [1][1] =  64;                                                                                                                                                                                                                                               
//		temp [2][0] = 17; temp [2][1] =  47; temp [2][2] =82 ;                                                                                                                                                                                                                             
//		temp [3][0] = 18; temp [3][1] =  35; temp [3][2] =87 ;temp [3][3] = 10;                                                                                                                                                                                                            
//		temp [4][0] = 20; temp [4][1] =  04; temp [4][2] =82 ;temp [4][3] = 47; temp [4][4] = 65;                                                                                                                                                                                          
//		temp [5][0] = 19; temp [5][1] =  01; temp [5][2] =23 ;temp [5][3] = 75; temp [5][4] = 03; temp [5][5] = 34;                                                                                                                                                                        
//		temp [6][0] = 88; temp [6][1] =  02; temp [6][2] =77 ;temp [6][3] = 73; temp [6][4] = 07; temp [6][5] = 63; temp [6][6] = 67;                                                                                                                                                      
//		temp [7][0] = 99; temp [7][1] =  65; temp [7][2] =04 ;temp [7][3] = 28; temp [7][4] = 06; temp [7][5] = 16; temp [7][6] = 70; temp [7][7] = 92;                                                                                                                                    
//		temp [8][0] = 41; temp [8][1] =  41; temp [8][2] =26 ;temp [8][3] = 56; temp [8][4] = 83; temp [8][5] = 40; temp [8][6] = 80; temp [8][7] = 70; temp [8][8] =  33;                                                                                                                 
//		temp [9][0] = 41; temp [9][1] =  48; temp [9][2] =72 ;temp [9][3] = 33; temp [9][4] = 47; temp [9][5] = 32; temp [9][6] = 37; temp [9][7] = 16; temp [9][8] =  94; temp [9][9] = 29;                                                                                               
//		temp [10][0] =53 ;temp [10][1] =71 ;temp [10][2] =44 ;temp [10][3] =65 ;temp [10][4] =25 ;temp [10][5] =43 ;temp [10][6] =91 ;temp [10][7] =52 ;temp [10][8] = 97 ;temp [10][9] =51 ;temp [10][10] =14 ;                                                                           
//		temp [11][0] =70 ;temp [11][1] =11 ;temp [11][2] =33 ;temp [11][3] =28 ;temp [11][4] =77 ;temp [11][5] =73 ;temp [11][6] =17 ;temp [11][7] =78 ;temp [11][8] = 39 ;temp [11][9] =68 ;temp [11][10] =17 ;temp [11][11] =57;                                                         
//		temp [12][0] =91 ;temp [12][1] =71 ;temp [12][2] =52 ;temp [12][3] =38 ;temp [12][4] =17 ;temp [12][5] =14 ;temp [12][6] =91 ;temp [12][7] =43 ;temp [12][8] = 58 ;temp [12][9] =50 ;temp [12][10] =27 ;temp [12][11] =29;temp [12][12] =48 ;                                      
//		temp [13][0] =63 ;temp [13][1] =66 ;temp [13][2] =04 ;temp [13][3] =68 ;temp [13][4] =89 ;temp [13][5] =53 ;temp [13][6] =67 ;temp [13][7] =30 ;temp [13][8] = 73 ;temp [13][9] =16 ;temp [13][10] =69 ;temp [13][11] =87;temp [13][12] =40 ;temp [13][13] =31 ;                   
//		temp [14][0] =4 ;temp [14][1] =62 ;temp [14][2] =98 ;temp [14][3] =27 ;temp [14][4] =23 ;temp [14][5] = 9 ;temp [14][6] =70 ;temp [14][7] =98 ;temp [14][8] = 73 ;temp [14][9] =93 ;temp [14][10] =38 ;temp [14][11] =53;temp [14][12] =60 ;temp [14][13] =04 ;temp [14][14] = 23;
//		
		int result = temp[0][0];
		
		int sample = 0;
		BigInteger a = new BigInteger("1");
		for (int i = 1; i <= 14; i++) {
			a = a.multiply(BigInteger.valueOf(2));
		}
		System.out.println(a);
//		16384 가지 경우의 수
		
		for (int i = 13; i >=0; i--) {
			for (int j = 0; j <= i; j++) {
			temp[i][j] = calac(i,j);
			System.out.printf("%3d  ",temp[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(temp[0][0]);
		
//		for (int i = 0; i < 14; i++) {
//			if (i <14) {
//				
//				System.out.println((i+1) + " . " +temp[i+1][sample] + " : " + temp[i+1][sample+1]);
//				
//				if (temp[i+1][sample] < temp[i+1][sample+1]) {
//					result += temp[i+1][sample+1];
//					System.out.println(result + " : " + temp[i+1][sample+1]);
//					sample++;
//				}
//				else {
//					result += temp[i+1][sample];
//					System.out.println(result+ " : " + temp[i+1][sample]);
//					
//				}
//				
//			}
//		}
//		
//		System.out.println("result : " + result);

	}
	
	public static int calac(int a , int b)throws Exception
	{
		int temp1 = temp[a][b] + temp[a+1][b];
		int temp2 = temp[a][b] + temp[a+1][b+1];
		
		int big = temp1;
		
		if (temp1 < temp2) {
			big = temp2;
		}
		
		return big;
		
	}

}
