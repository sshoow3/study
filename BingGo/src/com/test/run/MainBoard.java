package com.test.run;
/**
 * 게임이 실행되는 메인보드
 * */

import com.test.board.CPUVO;
import com.test.board.UserVO;
import com.test.util.Utill;

public class MainBoard {
	
	static UserVO user;
	static CPUVO cpu;
	static Utill util;
	
	static int[] choiceNum = new int[500];
	
	/**
	 * 게임 초기 셋팅값입력
	 * 
	 * int[] - 1.빙고판 크기, 2.게임유형 ,3. 랜덤여부 , 4. 난이도
	*/
	public MainBoard(int[] setting) {
		util = new Utill(setting);
		user = new UserVO();
		cpu = new CPUVO();
		
		user.setCheckboard(util.booleanBoadSetting(setting[0]));
		user.setNumberboard(util.startSetting(setting));
		cpu.setCheckboard(util.booleanBoadSetting(setting[0]));
		setting[2] = 2;
		cpu.setNumberboard(util.startSetting(setting));
	}
	
	
	public void setting(int[] setting) {
		
		
	}

}
