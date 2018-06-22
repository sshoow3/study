package com.test.run;

import java.util.Scanner;

import com.test.util.Utill;

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
	 * 실행기 1.게임판크기 설정 최소 4X4 <br>2.게임 유형(1인용 , vs CPU) 3.빙고판 입력여부 4.난이도 결정
	 * @param String[]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
	 * 18.06.21 김진호               코드 간략화 및 선택 옵션 추가
	 */
	public static void main(String[] args) {
		System.out.println("안녕하세요 빙고게임판입니다.");
		System.out.print("1.게임판 크기를 설정하세요(최소 4) : ");
		int[] select = new int[5];
		String insertTemp = "";
		Utill ut = new Utill();

		boolean check = true;
		try {
			insertTemp = sc.next();
			select[0] = ut.whileNumberInserting(insertTemp);
			if (select[0] >= 4) {
				check = false;
			}
		} catch (Exception e) {
			check = true;
		}

		while (check) {
			System.out.println("4미만의 숫자 혹은 숫자가 아닙니다 .");
			System.out.print("다시 입력해주세요(최소 4) : ");
			insertTemp = sc.next();
			select[0] = ut.whileNumberInserting(insertTemp);
			if (select[0] >= 4) {
				check = true;
			}

		}
		;
		// ----------------------------------------------------------
		select[1] = 0;
		try {
			System.out.print("2.게임 유형을 선택하세요 (1)1인용   (2)vs CPU : ");
			insertTemp = sc.next();
			select[1] = ut.whileNumberInserting(insertTemp);
			if (select[1] == 1 || select[1] == 2) {
				check = false;
			}
		} catch (Exception e) {
			check = true;
		}

		while (check) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("다시 입력해주세요(1)1인용   (2)vs CPU : ");
			insertTemp = sc.next();
			select[1] = ut.whileNumberInserting(insertTemp);
			if (select[1] == 1 || select[1] == 2) {
				check = false;
			}
		}
		;
		// ----------------------------------------------------------
		if (select[1] == 1) {
			System.out.println("3.1인용 게임은 빙고가 랜덤으로 지급됩니다.");
			select[2] = 1;
		} else {
			try {
				System.out.print("3.빙고을 랜덤으로 받으시겠습니까? (1)Yes  (2)No 직접입력  : ");
				insertTemp = sc.next();
				select[2] = ut.whileNumberInserting(insertTemp);
				if (select[2] == 1 || select[2] == 2) {
					check = false;
				}
			} catch (Exception e) {
				check = true;
			}

			while (check) {
				System.out.println("잘못입력하셨습니다.");
				System.out.print("다시 입력해주세요 (1)Yes  (2)No 직접입력 : ");
				insertTemp = sc.next();
				select[2] = ut.whileNumberInserting(insertTemp);
				if (select[2] == 1 || select[2] == 2) {
					check = false;
				}
			}
			;
		}
		// ----------------------------------------------------------
		select[3] = 0;
		try {
			System.out.printf("4.난이도 결정 (1)Easy 1 ~ %2d  (2)Hard 1 ~ %3d : ",
					(select[0] * select[0]), (select[0] * select[0] * 4));
			insertTemp = sc.next();
			select[3] = ut.whileNumberInserting(insertTemp);
			if (select[3] == 1 || select[3] == 2) {
				check = false;
			}
		} catch (Exception e) {
			check = true;
		}

		while (check) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("다시 입력해주세요(1)1인용   (2)vs CPU: ");
			insertTemp = sc.next();
			select[3] = ut.whileNumberInserting(insertTemp);
			if (select[3] == 1 || select[3] == 2) {
				check = false;
			}
		}
		// ----------------------------------------------------------
		select[4] = 0;
		try {
			System.out.print("5.빙고 완성 숫자 입력(최소1이상) :");
			insertTemp = sc.next();
			select[4] = ut.whileNumberInserting(insertTemp);
			if (select[4]>0) {
				check = false;
			}
		} catch (Exception e) {
			check = true;
		}
		while (check) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("5.빙고 완성 숫자 입력(최소1이상) :");
			insertTemp = sc.next();
			select[4] = ut.whileNumberInserting(insertTemp);
			if (select[4]>0) {
				check = false;
			}
		}

		MainBoard mb = new MainBoard(select);
		System.out.println("게임을 시작합니다  .");
		
		mb.gamePlay(select);
	}

}
