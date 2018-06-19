package com.test.run;

import java.util.Scanner;

/**
 * 1. 빙고게임 - 룰 정하기 판 크기(5X5 , 6X6 등등) 승리 조건(몇 줄 이상 빙고여야 하는지) 빙고판 입력 여부(랜덤 혹은 사용자
 * 입력) 입력 숫자 범위 설정(중복되는 숫자가 없도록) 빙고판 입력 여부에 따라 게임 유형 선택 (1인용, vs cpu)
 *
 * - 1인용 랜덤으로 받은 판에서 숫자 입력하여 빙고판 체우기 easy : 판수만큼의 숫자 ex 5X5판이면 1~25 hard : 판수
 * 이상의 숫자중 판크기만큼 ex 5X5 판에서 1~100 숫자 중 25개 사용 - vs cpu 서로 한차례씩 숫자를 입력해 지정한 숫자의
 * 빙고를 먼저 완성하는 쪽 승리
 */
public class Main {

	static Scanner sc = new Scanner(System.in);

	/**
	 * 실행기 1.게임판크기 설정 최소 4X4 2.게임 유형(1인용 , vs CPU) 3.빙고판 입력여부 4.난이도 결정
	 */
	public static void main(String[] args) {
		System.out.println("안녕하세요 빙고게임판입니다.");
		System.out.print("1.게임판 크기를 설정하세요(최소 4) : ");
		int[] select = new int[10];
		int select1 = 0;

		boolean check = true;
		try {
			select[0] = sc.nextInt();
			if (select[0] < 4) {
				check = false;
			}
		} catch (Exception e) {
			check = true;
		}

		while (!check){
			System.out.println("4미만의 숫자 혹은 숫자가 아닙니다 .");
			System.out.print("다시 입력해주세요(최소 4) : ");
			select[0] = sc.nextInt();
		} ;
		// ----------------------------------------------------------
		select[1] = 0;
		try {
			System.out.print("2.게임 유형을 선택하세요 (1)1인용   (2)vs CPU : ");
			select[1] = sc.nextInt();
			if (select[1] == 1 || select[1] == 2) {
				check = false;
			}
		} catch (Exception e) {
			check = true;
		}

		while (check) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("다시 입력해주세요(1)1인용   (2)vs CPU : ");
			select[1] = sc.nextInt();
		} ;
		// ----------------------------------------------------------
		if (select[1] == 1) {
			select[2] = 1;
		} else {
			select[2] = 0;
			try {
				System.out.print("빙고을 랜덤으로 받으시겠습니까? (1)Yes  (2)No 직접입력  : ");
				select[2] = sc.nextInt();
				if (select[2] == 1 || select[2] == 2) {
					check = false;
				}
			} catch (Exception e) {
				check = true;
			}

			while (check) {
				System.out.println("잘못입력하셨습니다.");
				System.out.print("다시 입력해주세요 (1)Yes  (2)No 직접입력 : ");
				select[2] = sc.nextInt();
			} ;
		}
		// ----------------------------------------------------------
		select[3] = 0;
		try {
			System.out.printf("4.난이도 결정 (1)Easy 1 ~ %2d  (2)Hard 1 ~ %3d 직접입력: ", (select1 * select1),
					(select1 * select1 * 4));
			select[3] = sc.nextInt();
			if (select[3] == 1 || select[3] == 2) {
				check = false;
			}
		} catch (Exception e) {
			check = true;
		}

		while (check) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("다시 입력해주세요(1)1인용   (2)vs CPU: ");
			select[3] = sc.nextInt();
		} ;
		
		
	}

}
