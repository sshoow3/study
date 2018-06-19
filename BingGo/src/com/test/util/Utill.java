package com.test.util;

import java.util.Scanner;

/**
 * 설정도구
*/
public class Utill {
	static int  max;
	
	public Utill(int[] setting) {
		if (setting[3] ==2 ) this.max = (setting[0] * setting[0] );else this.max = setting[0];
	}
	/**
	 * 빙고판 초기값 설정
	 * 
	 * Parameters: 1. int 게임판크기 , 2.int 랜덤여부 , 3 int 난이도
	*/
	public int[][] startSetting(int[] setting) {
		Scanner sc = new Scanner(System.in);
		int[][] firstboard = new int[setting[0]][setting[0]];
		
		
		
		int[] insertnum = new int[setting[0]];
		int insertcount = 0;
		
		
		int randomNum = 1;
		if (setting[2] == 1) {
			for (int i = 0; i < firstboard.length; i++) {
				for (int j = 0; j < firstboard.length; j++) {
					firstboard[i][j] = randomNum;
					if (setting[3] ==2 ) randomNum = (randomNum + (int)(Math.random()*3)+1 );else randomNum++;
				}
			}
		}else {
			for (int i = 0; i < firstboard.length; i++) {
				for (int j = 0; j < firstboard.length; j++) {
					
					boolean check = false;
					int num =0;
					while (!check) {
						boardInsertview(firstboard);
						System.out.print("번호를 입력하세요 : ");
						try {
							num = sc.nextInt();
							
							check = insertArea(num);
							if (check) {
								check = insertCheck(insertnum, num);
								if (check) {
									insertnum[insertcount++] = num;
								}
							}
						} catch (Exception e) {
							System.out.println("잘못입력하셧습니다.");
						}
						
					}
					firstboard[i][j] = num;
				}
			}
		}
		
		return firstboard;
	}
	
	/**
	 * 체크보드 초기셋팅
	*/
	public boolean[][] booleanBoadSetting(int boardsize) {
		boolean[][] firstboard = new boolean[boardsize][boardsize];
		for (int i = 0; i < firstboard.length; i++) {
			for (int j = 0; j < firstboard.length; j++) {
				firstboard[i][j] = false;
			}
		}
		
		return firstboard;
	}
	
	/**
	 * 보드 출력 화면 - 입력화면
	*/
	public static void boardInsertview(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.printf(" %3d ",board[i][j]);
			}
			System.out.println();
		}
	}
	/**
	 * 입력여부 체크
	*/
	public boolean insertCheck(int[]insertNumbers,int insert) {
		boolean check = true;
		
		for (int i = 0; i < insertNumbers.length; i++) {
			if (insertNumbers[i] == insert) {
				check =false;
				break;
			}
		}
		
		return check;
	}
	/**
	 * 숫자범위 체크
	*/
	public boolean insertArea(int insert ) {
		boolean check = false;
		
		if (insert>0 && insert <=max) 
			check =true;
		else 
			System.out.println("0~"+max+" 사이의 숫자가 아닙니다.");
		
		
		return check;
	}
}
