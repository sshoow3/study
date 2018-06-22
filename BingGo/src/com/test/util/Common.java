package com.test.util;

import com.test.board.AIVO;
import com.test.board.BoardVO;

public class Common {
	int boardsize;
	Common(int size){
		boardsize = size;
	}
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
	public void test1(BoardVO boardVO){
		Utill utill = new Utill();
		
	}
	
	public AIVO lineData(String lineTpe , int line){
		AIVO aivo = new AIVO();
		
		
		
		return aivo;
	}
	
	public int max(int x, int y){
		
		if (y != boardsize) {
			if (x<y) {
				x = y ;
			}
		}
		
		return x;
	}
}
