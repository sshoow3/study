package com.test.util;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.test.board.BoardVO;
import com.test.board.ManagerVO;

/**
 * 설정도구
 */
public class Utill {
	static int max;
	static Logger log = Logger.getLogger(Utill.class.getName());
	static ManagerVO manager = new ManagerVO();

	/**
	 * 호출시 셋팅값입력 - 초기셋팅시 필요<br>
	 * param int[3]<br>
	 * [0] 빙고판 크기
	 * [1] 게임유형<br>
	 * [2] 랜덤여부
	 * [3] 난이도<br>
	 * @param int[]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
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
	 * 빙고판 초기값 설정<br>
	 * Parameters: 1. int 게임판크기 , 2.int 랜덤여부 , 3 int 난이도
	 * @param int[][]
	 * @return  int[][]
	 * @version 0.2
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
	 */
	public int[][] startSetting(int[] setting) {
		Scanner sc = new Scanner(System.in);
		int[][] firstboard = new int[setting[0]][setting[0]];

		ManagerVO numberchking = new ManagerVO();
		numberchking.setChoiceNum(new int[setting[0] * setting[0] * 4]);
		numberchking.setInsertcount(0);

		int randomNum = 1;
		if (setting[2] == 1) {
			numberchking.setSwich("랜덤제작");
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
										check = insertCheck(numberchking);
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
	 * @param int
	 * @return  boolean[][]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
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
	 * @param int[][]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
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
	 * 게임화면 출력 - 랜덤게임용
	 * @param int[][]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public static void randomPlayingView(BoardVO board){
		int[][] numberBoard = board.getNumberboard();
		boolean[][] checkBoard = board.getCheckboard();
		for (int i = 0; i < checkBoard.length; i++) {
			for (int j = 0; j < checkBoard.length; j++) {
					if (checkBoard[i][j]) System.out.printf(" %3s ","O") ;
					else System.out.printf(" %3s ","X");
			}
			System.out.println();
		}
	}
	
	/**
	 *  게임화면 출력 - 수동입력용
	 * @param int[][]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public static void insertPlayingView(BoardVO board){
		int[][] numberBoard = board.getNumberboard();
		boolean[][] checkBoard = board.getCheckboard();
		for (int i = 0; i < checkBoard.length; i++) {
			for (int j = 0; j < checkBoard.length; j++) {
					if (checkBoard[i][j]) System.out.printf(" %3d ", numberBoard[i][j]) ;
					else System.out.printf(" %3s ","O");
			}
			System.out.println();
		}
	}

	/**
	 * 입력 중복여부 체크 - 초기값 설정용<br>
	 * 이전에 이미 입력했는지 여부 체크
	 * @param int[] , int
	 * @return  boolean
	 * @version 0.2
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
	 */
	public boolean insertCheck(ManagerVO isertVO) {
		boolean check = true;
		int[] insertNumbers = isertVO.getChoiceNum();
		
		for (int i = 0; i < isertVO.getInsertcount(); i++) {
			if (insertNumbers[i] ==  isertVO.getInsertNum() ) {
				check = false;
				break;
			}
		}

		if (!check && isertVO.getSwich().equals("랜덤제작"))
			log.info("이미 입력하신 번호 입니다.");
		;

		return check;
	}
	
	/**
	 * 입력 중복여부 체크 - 게임용<br>
	 * 이전에 이미 입력했는지 여부 체크
	 * @param int
	 * @return  boolean
	 * @version 0.2
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	 */
	public boolean insertCheck(int insert) {
		boolean check = true;
		int insertNumbers[] = manager.getChoiceNum();
		int insertcount = manager.getInsertcount();
		

		for (int i = 0; i < insertcount; i++) {
			if (insertNumbers[i] == insert) {
				check = false;
				break;
			}
		}

		if (!check)log.info("이미 입력하신 번호 입니다.");
		else {
			insertNumbers[insertcount] = insert;
			insertcount++;
			manager.setChoiceNum(insertNumbers);
			manager.setInsertcount(insertcount);
		}

		return check;
	}

	/**
	 * 숫자범위 체크
	 * @param int
	 * @return  boolean
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
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
	 * 입력값 이외의 자료형 포함여부 체크 <br>
	 * param = String 입력값 <br>
	 * return boolean <br>
	 * <br>
	 * 참고 자료 : http://superfelix.tistory.com/70
	 * @param String
	 * @return  boolean
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
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

	/**
	 * 입력값이 숫자인지 여부 체크 후 숫자일때까지 반복
	 * @param String
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
	*/
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
	
	/**
	 * 게임 플레이 중 기록 파일저장 - 작성예정 
	 * @param String
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.19	김진호               작성
	*/
	public void logFileText(){
//		
	}
	
	/**
	 * 게임 시작시 환경설정 기록 파일저장 - 작성예정
	 * @param String
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public void startSettingLog(){
		
	}
	/**
	 * 입력값의 위치를 찾아 빙고판 활성화
	 * @param int
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public BoardVO search(int insertNumber ,BoardVO board){
		int[][] tempBoard = board.getNumberboard();
		boolean[][] tempCheckBoard = board.getCheckboard();
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard.length; j++) {
				if (tempBoard[i][j] == insertNumber) {
					x=i; y=j;
					tempCheckBoard[x][y] = true;
				}
			}
		}
		
		return board;
	}
	/**
	 * 지금까지의 입력값들 출력
	 * @param int
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public void inserNumbersView(){
		int[] insertNumber = manager.getChoiceNum();
		int insercount = manager.getInsertcount();
		
		System.out.println("===========사용된 숫자 입니다 ===========");
		for (int i = 0; i < insercount; i++) {
			System.out.printf(" %3d ",insertNumber[i]);
			if (insercount%5 ==0 && insercount !=0) {
				System.out.println();
			}
		}

		System.out.println("========================================");
	}
	
}
