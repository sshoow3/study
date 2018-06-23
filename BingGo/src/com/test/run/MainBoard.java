package com.test.run;
/**
 * 게임이 실행되는 메인보드
 * */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

import com.test.board.BoardVO;
import com.test.board.ManagerVO;
import com.test.util.Utill;

public class MainBoard {
	
	static BoardVO user;
	static BoardVO cpu;
	
	static Utill util;
	static int[] insertNumber;
	static Logger log = Logger.getLogger(MainBoard.class.getName());
	
	static int[] choiceNum = new int[500];
	static int bingGo ;
	static boolean winner = false;
	static int max;
	static Date d = new Date();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd일HH시mm분");
	static SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-W");
	
	static String folder = "";
	static String file = "";
	
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
		
		folder= "C:\\JavaStudy\\BingGo\\log"+dt.format(d) ;
		file= sdf.format(d)+".txt";
		util.startSettingLog(folder,file,setting);
		
		user.setCheckboard(util.booleanBoadSetting(setting[0]));
		user.setNumberboard(util.startSetting(setting));
		cpu.setCheckboard(util.booleanBoadSetting(setting[0]));
		setting[2] = 1;
		cpu.setNumberboard(util.startSetting(setting));
		
		if (setting[3] == 2) insertNumber = new int[setting[0] * setting[0] * 4]; else insertNumber = new int[setting[0] * setting[0]];
		this.bingGo = setting[4];
		if (setting[3] == 2)
			this.max = (setting[0] * setting[0] * 4);
		else
			this.max = setting[0] * setting[0];
		
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
		Scanner sc = new Scanner(System.in);
		util.logPlaying(user,cpu,"start");
		while (!winner) {
			int insert = 0;
			boolean insertNumberCheck = false;
			
			do {
				util.inserNumbersView();
				if (setting[1]==1) util.randomPlayingView(user);
				else util.insertPlayingView(user);
//				util.insertPlayingView(user);
				System.out.print("숫자를 입력하세요  : ");
				String insertTemp = sc.next();
				insert = util.whileNumberInserting(insertTemp);
				insertNumberCheck = util.insertArea(insert);
				if (insertNumberCheck) {
					insertNumberCheck = util.insertCheck(insert);
				}
			} while (!insertNumberCheck);
			
			// 게임 
			if (setting[1]==1) {
				//1인
				singGame(insert);
			}else if(setting[1]==2){
				//cpu
				vsCPURGame(insert ,"user");
				if(winner)break;
				vsCPURGame(insert ,"cpu");
				if(winner)break;
			}
		}
		System.out.println("=======================================");
		System.out.println("================게임끝==============");
		System.out.println("=======================================");
		
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
	public void singGame(int num){
		// 위치탐색 반영
		user = util.insertChecking(num, user);
		
		// 게임승리 여부
		winner = gameResult(user);
		util.logPlaying(user,cpu,"1인용");
	}
	/**
	 * 게임 play
	 * @param int , String
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.22	김진호               작성
	*/
	public void vsCPURGame(int num,String clinet){
		boolean userBingGo = false;
		boolean cpuBingGo = false;
		if (clinet.equals("user")) {
			// 위치탐색 반영
			user = util.insertChecking(num, user);
			// 빙고 여부체크
			userBingGo = gameResult(user);
			// 위치탐색 반영
			cpu = util.insertChecking(num, cpu);
			// 빙고 여부체크
			cpuBingGo = gameResult(cpu);
			// 기록
			util.logPlaying(user,cpu,"user");
			// 게임승리 여부
			if (userBingGo || cpuBingGo) {
//				log.info("승리조건 충족");
				if(util.bingGoALLCount(user) > util.bingGoALLCount(cpu)){
					System.out.println("사용자 승리!!");
					winner =true;
				}else if (util.bingGoALLCount(user) < util.bingGoALLCount(cpu)) {
					System.out.println("컴퓨터 승리!!");
					winner =true;
				}else if (util.bingGoALLCount(user) == util.bingGoALLCount(cpu)) {
					System.out.println("빙고수가 같습니다. 먼저 더 많은 빙고수를 얻으시면 승리입니다.");
				}
			}
		}else if(clinet.equals("cpu")) {
			// 컴퓨터  턴
			boolean insertNumberCheck = true;
			do {
				int[] cpuInser = util.lineMax(cpu);
				//        개인 제작 빙고 ai 알고리즘
				num = util.cpuInsertFind(cpu, cpuInser[0], cpuInser[1]);
				insertNumberCheck = util.insertCheck(num);
			} while (!insertNumberCheck);
			
	
			user = util.insertChecking(num, user);
			// 빙고 여부체크
			userBingGo = gameResult(user);
			// 위치탐색 반영
			cpu = util.insertChecking(num, cpu);
			// 빙고 여부체크
			cpuBingGo = gameResult(cpu);
			util.logPlaying(user,cpu,"cpu");
			if (userBingGo || cpuBingGo) {
//				log.info("승리조건 충족");
				if(util.bingGoALLCount(user) > util.bingGoALLCount(cpu)){
					System.out.println("사용자 승리!!");
					winner =true;
				}else if (util.bingGoALLCount(user) < util.bingGoALLCount(cpu)) {
					System.out.println("컴퓨터 승리!!");
					winner =true;
				}else if (util.bingGoALLCount(user) == util.bingGoALLCount(cpu)) {
					System.out.println("빙고수가 같습니다. 먼저 더 많은 빙고수를 얻으시면 승리입니다.");
				}
			}
		}
		
	}
	/**
	 * 게임 결과 확인
	 * @return boolean
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.21	김진호               작성
	*/
	public boolean gameResult(BoardVO vo){
		boolean result = false;
		
		int count = util.bingGoALLCount(vo);
		
		if (count >= bingGo) {
			System.out.println("=============count==============");
//			util.insertPlayingView(vo);
			System.out.println("=============="+count+"===============");
//			util.randomPlayingView(vo);
//			System.out.println("=================================");
			result = true;
//			System.out.println(count + " : " + bingGo);
		}
		
		return result;
	}

}
