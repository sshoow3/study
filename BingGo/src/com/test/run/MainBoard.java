package com.test.run;
/**
 * 게임이 실행되는 메인보드
 * */

import java.util.Scanner;
import java.util.logging.Logger;

import com.test.board.BoardVO;
import com.test.board.ManagerVO;
import com.test.util.Utill;

public class MainBoard {
	
	static BoardVO user;
	static BoardVO cpu;
//	static UserVO user;
//	static CPUVO cpu;
	static Utill util;
	static int[] insertNumber;
	static Logger log = Logger.getLogger(MainBoard.class.getName());
	
	static int[] choiceNum = new int[500];
	
	/**
	 * 게임 초기 셋팅값입력
	 * 
	 * int[] - 1.빙고판 크기, 2.게임유형 ,3. 랜덤여부 , 4. 난이도
	 * @param int[]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
	*/
	public MainBoard(int[] setting) {
		util = new Utill(setting);
//		user = new UserVO();
//		cpu = new CPUVO();
		user = new BoardVO();
		cpu  = new BoardVO();
		
		user.setCheckboard(util.booleanBoadSetting(setting[0]));
		user.setNumberboard(util.startSetting(setting));
		cpu.setCheckboard(util.booleanBoadSetting(setting[0]));
		setting[2] = 1;
		cpu.setNumberboard(util.startSetting(setting));
		
		if (setting[3] == 2) insertNumber = new int[setting[0] * setting[0] * 4]; else insertNumber = new int[setting[0] * setting[0]];
	}
	
	/**
	 * 게임 play
	 * @param int[]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	 * 1 1인용 - 입력한숫자가 맞을경우 보여준다
	 * 2 vs랜덤 - 입력한 숫자가 맞을경우 보여준다
	 * 3 vs수동 - 숫자를 보여주고 체크한부분 표기
	*/
	public void gamePlay(int[] setting){
		boolean gameEnd = false;
		Scanner sc = new Scanner(System.in);
		while (!gameEnd) {
			
			boolean insertNumber = false;
			while (!insertNumber) {
				util.inserNumbersView();
				if (setting[2]==1) util.randomPlayingView(user);
				else util.insertPlayingView(user);
				
				
				
				System.out.print("숫자를 입력하세요");
				String insertTemp = sc.next();
				int insert = util.whileNumberInserting(insertTemp);
				if (util.insertArea(insert)) {
					insertNumber = util.insertCheck(insert);
				}
				
			}
			// 게임 
			if (setting[0]==1) {
				//1인
			}else {
				//cpu
				if (setting[2]==1) {
					//랜덤게임
				}else {
					//수동입력 게임
				}
			}
			//게임 end 체크
		}
		
	}
	/**
	 * 1인용 게임 play
	 * @param int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public void singGame(){
		// 입력값 중복여부 체크
		// 위치탐색 반영
		// 빙고 여부체크
		// 게임승리 여부
	}
	/**
	 * 게임 play
	 * @param int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public void vsCPURGame(){
		// 입력값 중복여부 체크
		// 위치탐색 반영
		// 빙고 여부체크
		// 
		// 게임승리 여부
	}
	/**
	 * 게임 결과 확인
	 * @return boolean
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public boolean gameResult(){
		boolean result = false;
		
		return result;
	}

}
