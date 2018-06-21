package com.test.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.test.board.BoardVO;
import com.test.util.Utill;

public class abingoTEST2 {
	static boolean[][] checkboard = {
			{false,false,true,true,false},
			{true,false,true,true,false},
			{true,false,true,true,false},
			{true,true,false,true,false},
			{true,true,true,true,false}
	};
	static int[][] number = {
		{11,14,18,19,10},
		{16,3,15,25,12},
		{13,24,17,2,21},
		{5,4,6,22,7},
		{9,20,8,23,1}
};
	static Utill ut;

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
		
		// 줄검사 결과 - true 수 flase위치  검사하는 라인종류 라인 줄
		BoardVO board = new BoardVO();
		board.setCheckboard(checkboard);
		board.setNumberboard(number);
		ut.insertPlayingView(board);
		int setting[] ={5,1,1,1,3};
		ut = new Utill(setting);
		HashMap<String, CheckVO> check = new HashMap<String, CheckVO>();
		
		for (int i = 0; i < checkboard.length; i++) {
//			check.put("x"+i, lineSearch("x", i));
			compare(lineSearch("x", i));
		}
		for (int i = 0; i < checkboard.length; i++) {
//			check.put("y"+i, lineSearch("y", i));
			compare(lineSearch("y", i));
		}
//		check.put("z0", lineSearch("z", 1));
//		check.put("z1", lineSearch("z", 2));
		compare(lineSearch("z", 1));
		compare(lineSearch("z", 2));
	}
	
	public static CheckVO lineSearch(String type , int line){
		CheckVO ch = new CheckVO();
		
		ch.setLine(type);
		ch.setLineNumber(line);
//		int[] falseNumber = {};
		List<Integer> falseNumber = new ArrayList<Integer>();
		int falsecount =0;
		int count = 0;
		if (type.equals("x")) {
			for (int i = 0; i < checkboard.length; i++) {
				if (checkboard[line][i]==true) {
					count++;
				}else {
					falseNumber.add( i);
					falsecount++;
				}
			}
			
		}else if (type.equals("y")) {
			for (int i = 0; i < checkboard.length; i++) {
				if (checkboard[i][line]==true) {
					count++;
				}else {
					falseNumber.add( i);
					falsecount++;
				}
			}
		}else if (type.equals("z")) {
			if (line==1) {
				for (int i = 0; i < checkboard.length; i++) {
					if (checkboard[i][i]==true) {
						count++;
					}else {
						falseNumber.add( i);
						falsecount++;
					}
				}
			}else {
				for (int i = 0; i < checkboard.length; i++) {
					if (checkboard[checkboard.length-i-1][i]==true) {
						count++;
					}else {
						falseNumber.add( i);
						falsecount++;
					}
				}
			}
			
		}
		int[] falseNumbersa = new int[falseNumber.size()];
		
		int i = 0;
		for (Integer e : falseNumber) {
			falseNumbersa[i++] = e.intValue();
		}
		
		ch.setFalseNumbers(falseNumbersa);;
		ch.setCount(count);
		return ch;
	}
	
	public void view(){
		
	}
	
	public static void compare(CheckVO vo){
//		int[] location= new int[vo.getFalseNumbers().size()];
//		http://hochulshin.com/java-arraylist/
		
		int big = 0;
		int num = 0;
		if (vo.getLine().equals("x")) {
			System.out.println("x"+vo.getLineNumber()+" : "  + vo.getFalseNumbers().length);
//			System.out.println( vo.getFalseNumbers());
			for (int i = 0; i < vo.getFalseNumbers().length; i++) {
				num = numbering(vo.getLineNumber(),vo.getFalseNumbers()[i]);
				System.out.println(vo.getLineNumber()+","+vo.getFalseNumbers()[i]+" : "+num);
			}
		}else if (vo.getLine().equals("y")) {
			System.out.println("y"+vo.getLineNumber()+" : "  + vo.getFalseNumbers().length);
//			System.out.println( vo.getFalseNumbers());
			for (int i = 0; i < vo.getFalseNumbers().length; i++) {
				num = numbering(vo.getFalseNumbers()[i],vo.getLineNumber());
				System.out.println(vo.getLineNumber()+","+vo.getFalseNumbers()[i]+" : "+num);
			}
		}else if (vo.getLine().equals("z")) {
			System.out.println("z"+vo.getLineNumber()+" : "  + vo.getFalseNumbers().length);
//			System.out.println( vo.getFalseNumbers());
//			for (int i = 0; i < vo.getFalseNumbers().length; i++) {
//				num = numbering(vo.getFalseNumbers()[i],vo.getFalseNumbers()[i]);
//				System.out.println(num);
//			}
		}
		
		
	}
	
	public static int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		
		int i = 0;
		for (Integer e : list){
			ret[i++] = e.intValue();
		}
		
		
		return ret;
	}
	
	public static int numbering(int x, int y){
		int a = 0;
		ut = new Utill();
		a += ut.xLineCount(checkboard, x);
		a += ut.yLineCount(checkboard, y);
		if (x == y) {
			a += ut.xyLineCount(checkboard, 1);
			
		}else if (checkboard.length-x-1 == y) {
			a += ut.xyLineCount(checkboard, 2);
		}
		
		return a;
	}

}
