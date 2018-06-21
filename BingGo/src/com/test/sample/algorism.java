package com.test.sample;

import java.util.HashMap;

import com.test.board.BoardVO;
import com.test.util.Utill;

public class algorism {
	static Utill ut;
	static BoardVO board;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 빙고 알고리즘 테스트
		 * 1. boardSize -1 검색
		 * 1-1 1개 인 경우 선택
		 * 1-2 1개 이상 인 경우 비교선택
		 * 2. 게임 턴 진행수가 6이하일경우 (상대방 포함) 싱글 3
		 * 2-1 6턴 이하일경우 중앙 입력
		 * 2-2  중앙 입력이 있을경우 다른위치(중앙쪽) 입력
		 * 3. 맥스 라인수 검색후처리
		 * 3-1 각 라인 활성화 수 구하기
		 * 3-2 활성화 위치에 따른  각 활성화수 총값 높은 위치 검색
		 * 3-3 여러건일 경우 랜덤으로 선택
		*/
		int[] setting = {5,1,1,1,3};
		ut = new Utill(setting);
		boolean[][] checkboard = {
				{false,false,true,true,false},
				{true,false,true,true,false},
				{true,false,true,true,false},
				{true,true,false,true,false},
				{true,true,true,true,false}
		};
		
		
		board = new BoardVO();
		board.setCheckboard(checkboard);
		board.setNumberboard(ut.startSetting(setting));
		
		boolean[][] test22 = ut.booleanBoadSetting(setting[0]);
		
		test(checkboard);
	}
	
	public static void test(boolean[][] checkboard){

		int[] x = new int[checkboard.length];
		int[] y = new int[checkboard.length];
		int[] z = new int[2];
		int total = 0;
		int maxX = 0;
		int maxXcount = 0;
		int maxY = 0;
		int maxYcount = 0;
		int maxXY = 0;
		int maxXYcount = 0;
		
		HashMap<String,TESTVO> a= new HashMap<String,TESTVO>();
		TESTVO test ;
		for (int i = 0; i < x.length; i++) {
			test = new TESTVO();
			x[i]=ut.xLineCount(checkboard, i);
			String text = "x"+i;
			
			test.setLocation(text);
			test.setMax(x[i]);
			a.put(text, test);
			
			if (maxX > x[i]) {
				maxX = x[i];
				maxXcount =1;
			}else if (maxX == x[i]) {
				maxXcount++;
			}
			
		}
		for (int i = 0; i < x.length; i++) {
			test = new TESTVO();
			y[i]=ut.yLineCount(checkboard, i);
			
			test.setLocation("y"+i);
			test.setMax(y[i]);
			a.put("y"+i, test);
			
			if (maxX == x[i]) {
				maxXcount++;
			}
			
			if (maxY > y[i]) {
				maxY = y[i];
				maxYcount =1;
			}else if (maxY == y[i]) {
				maxYcount++;
			}
			
			
		}
		for (int i = 0; i < z.length; i++) {
			z[i]=ut.xyLineCount(checkboard, i);
			
			test = new TESTVO();
			test.setLocation("z"+i);
			test.setMax(z[i]);
			a.put("z"+i, test);
			
			if (maxXY > z[i]) {
				maxXY = z[i];
				maxXYcount =1;
			}else if (maxY == z[i]) {
				maxXYcount++;
			}
			
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				if (i==0) {
					testview(a.get("x"+j));
				}else {
					testview(a.get("y"+j));
				}
				
			}
		}
		testview(a.get("z0"));
		testview(a.get("z1"));
		ut.randomPlayingView(board);


//		알아야 하는갎 각 줄의 true 겟수 
//		선택할 false 위치
//		위치를 선택시 가능성 변동폭
		
//		
		
		if (maxX == 4 || maxY == 4 || maxXY == 4) {
//			 * 1. boardSize -1 검색
//			 * 1-1 1개 인 경우 선택
//			 * 1-2 1개 이상 인 경우 비교선택
		}else if (total<6) {
//			 * 2. 게임 턴 진행수가 6이하일경우 (상대방 포함) 싱글 3
//			 * 2-1 6턴 이하일경우 중앙 입력
//			 * 2-2 3번까지의 우선순위 1. 정중앙 2. 대각선 포함하는 중앙(홀수일경우)
		}else {
//			 * 3. 맥스 라인수 검색후처리
//			 * 3-1 각 라인 활성화 수 구하기
//			 * 3-2 활성화 위치에 따른  각 활성화수 총값 높은 위치 검색
//			 * 3-3 여러건일 경우 랜덤으로 선택
		}
		
	}
	TESTVO max ;
	public TESTVO findmax(TESTVO test){
		TESTVO big =test;
		
		
		return big;
	}
	
	public static void testview( TESTVO value){
		System.out.println(value.getLocation() + " : " + value.getMax());
	}

}
