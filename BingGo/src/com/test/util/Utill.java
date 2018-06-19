package com.test.util;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * 설정도구
 */
public class Utill {
	static int max;
	static Logger log = Logger.getLogger(Utill.class.getName());

	/**
	 * 호출시 셋팅값입력 - 초기셋팅시 필요
	 * param int[3]
	 * [0] 빙고판 크기
	 * [1] 게임유형
	 * [2] 랜덤여부
	 * [3] 난이도
	*/
	public Utill(int[] setting) {
		if (setting[3] == 2)
			this.max = (setting[0] * setting[0] * 4);
		else
			this.max = setting[0] * setting[0];
		// log.info(setting[3] + ": " + max);
	}

	/**
	 * 다른 메소드 호출용
	*/
	public Utill() {
	}

	/**
	 * 빙고판 초기값 설정
	 * 
	 * Parameters: 1. int 게임판크기 , 2.int 랜덤여부 , 3 int 난이도
	 */
	public int[][] startSetting(int[] setting) {
		Scanner sc = new Scanner(System.in);
		int[][] firstboard = new int[setting[0]][setting[0]];

		int[] insertnum = new int[setting[0] * setting[0] * 4];
		int insertcount = 0;

		int randomNum = 1;
		if (setting[2] == 1) {
			for (int i = 0; i < firstboard.length; i++) {
				for (int j = 0; j < firstboard.length; j++) {
					firstboard[i][j] = randomNum;
					if (setting[3] == 2)
						randomNum = (randomNum + (int) (Math.random() * 3) + 1);
					else
						randomNum++;
				}
			}
		} else {

			if (setting[1] == 1) {
				for (int i = 0; i < firstboard.length; i++) {
					for (int j = 0; j < firstboard.length; j++) {

						boolean check = false;
						int num = 0;
						while (!check) {
							boardInsertview(firstboard);
							System.out.print("번호를 입력하세요 : ");
							try {
								String temp;
								temp = sc.next();
								boolean numcheck = insertEditCheck(temp);
								if (numcheck) {
									num = Integer.parseInt(temp);
									check = insertArea(num);
									if (check) {
										check = insertCheck(insertnum, num);
										if (check) {
											insertnum[insertcount++] = num;
										}
									}
								}
							} catch (Exception e) {
								log.info(e.toString());
								log.info("잘못입력하셧습니다.");
								num = 0;
							}

						}
						firstboard[i][j] = num;
					}
				}
			} else {

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
				System.out.printf(" %3d ", board[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * 입력여부 체크
	 */
	public boolean insertCheck(int[] insertNumbers, int insert) {
		boolean check = true;

		for (int i = 0; i < insertNumbers.length; i++) {
			if (insertNumbers[i] == insert) {
				check = false;
				break;
			}
		}

		if (!check)
			log.info("이미 입력하신 번호 입니다.");
		;

		return check;
	}

	/**
	 * 숫자범위 체크
	 */
	public boolean insertArea(int insert) {
		boolean check = false;

		if (insert > 0 && insert <= max)
			check = true;
		else
			log.info("0~" + max + " 사이의 숫자가 아닙니다.");

		return check;
	}

	/**
	 * 입력값 이외의 자료형 포함여부 체크 
	 * param = String 입력값 
	 * return boolean 
	 * 
	 * 참고 자료 : http://superfelix.tistory.com/70
	 */
	public boolean insertEditCheck(String insert) {
		/*
		 * 1) 한글만 구분 (1) 정규식 : ^[ㄱ-ㅎ가-힣]*$ (2) 메소드 : boolean a =
		 * Pattern.matches("^[ㄱ-ㅎ가-힣]*$", "비교문자"); (3) 예 : boolean a =
		 * Pattern.matches("^[ㄱ-ㅎ가-힣]*$", "가지"); 2) 영문자(대소문자 구분함) (1) 정규식 :
		 * ^[a-zA-Z]*$ (2) 메소드 : boolean b = Pattern.matches("^[a-zA-Z]*$",
		 * "비교문자"); (3) 예 : boolean b = Pattern.matches("^[a-zA-Z]*$", "Felix");
		 * 3) 영어소문자 (1) 정규식: ^[a-z]*$ (2) 메소드 : boolean c =
		 * Pattern.matches("^[a-z]*$", "비교문자"); 4) 숫자 (1) 정규식 : ^[0-9]*$ (2) 메소드
		 * : boolean c = Pattern.matches("^[0-9]*$", "비교문자"); 5) 한글과 숫자 (1) 정규식
		 * : ^[ㄱ-ㅎ가-힣0-9]*$ (2) 메소드 : boolean c =
		 * Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", "비교문자");
		 */
		boolean check = false;

		check = Pattern.matches("^*[//D]*$", insert);

		if (check)
			log.info("입력하신 것은 숫자가 아닙니다");
		;

		return !check;
	}

	public int whileNumberInserting(String insert) {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		boolean numberCheck = false;

		while (!numberCheck) {

			numberCheck = insertEditCheck(insert);

			if (numberCheck)
				result = Integer.parseInt(insert);
			else
				insert = sc.next();
		}

		return result;

	}
}
