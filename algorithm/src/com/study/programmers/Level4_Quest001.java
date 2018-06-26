package com.study.programmers;

public class Level4_Quest001 {

	static boolean[][] board ;
	static int boardsize;
	
	public static void main(String[] args) {
		/**
		 * 가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.

		예를 들어서 n이 2인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.
		
		체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때, n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.
		
		제한사항
		퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
		n은 12이하의 자연수 입니다.
		 */
		long start = System.currentTimeMillis();
		
		int n = 4;
		
		setting(n);
		
		int result = 0;
		
		for (int z = 0; z < boardsize; z++) {
//			System.out.println(insert(z) + " : " + boardsize);
			if (insert(z) == boardsize) {
				result++;
			}
		}
		System.out.println(result);
		
		long end = System.currentTimeMillis();

		System.out.println("실행 시간 : " + (end - start) / 1000.0);
	}
	
	public static void setting(int n){
		board = new boolean[n][n];
		boardsize = n;
		reset();
	}
	
	public static void reset(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = false;
			}
		}
	}
	
	
	public static boolean check(int x, int y){
		boolean ch = true;
//		System.out.println("check " +x + " ," + y);
		for (int i = 0; i < board.length; i++) {
			if (board[i][y]) ch = false;
		}
		
		for (int i = 0; i < board.length; i++) {
			if (board[x][i]) ch = false;
		}
		int min = 0;
		if (x< y) 	min = x;
		else 	min = y;
		int max = 0;
		if (x> y) 	max = x;
		else 	max = y;
		
		for (int i = 0; i < board.length -max +min; i++) {
//			System.out.println(x + " ||" + min + " || " + y + "  " + i);
//			System.out.println(i+ "," + ((x-min+i)) + "," + ((y-min+i)) + " , " );
			if (board[x-min+i][y-min+i]) ch = false;
		}
		
		if (x<y) {
			for (int i = 0; i < min+1; i++) {
				
				do {
//					System.out.println(i+ "," + ((x-min)+i) + "," + ((y+min)-i) + " , " +  (boardsize -1));
					if ((((y+min)-i) <= boardsize -1)&& (((x-min)+i) >= 0)) break;
					i++;
				} while (true);
//				System.out.println(i+ "," + ((x-min)+i) + "," + ((y+min)-i) + " , " +  (board[(x-min)+i][(y+min)-i]));
				if (board[(x-min)+i][(y+min)-i]) ch = false;
			}
		}else {
			for (int i = 0; i < max+1; i++) {
//				System.out.println(x + "  " + min + "  " + y + i);
//				System.out.println(i+ "," + ((x-max)+i) + "," + ((y+max)-i));
				do {
//					System.out.println(i+ "," + ((x-max)+i) + "," + ((y+max)-i)) + " , " +  (boardsize -1);
					if ((((y+max)-i) <= boardsize -1) && (((x-max)+i) >= 0)) break;
					i++;
				} while (true);
				if (board[(x-max)+i][(y+max)-i]) ch = false;
			}
		}
		
		
		
		return ch;
	}
	
	public static int insert(int z){
		int count = 1;
		board[0][z] = true;
		for (int i = 1; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (check(i, j)) {
					board[i][j] = true;
//					System.out.println(z +"] : "+ i +" : "+ j);
					count++;
				}
			}
		}
		if (count == boardsize) {
			view();
		}
		reset();
		return count;
	}
	
	public static void view(){
		System.out.println("==========================================");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i]) 	System.out.printf(" %s " , "Q");
				else System.out.printf(" %s " , "□");
			}
			System.out.println();
		}
		System.out.println("==========================================");
	}

}
