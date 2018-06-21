package com.test.util;

import java.util.Arrays;
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
	static int boardsize;
	static int bingGo;
	
	static Logger log = Logger.getLogger(Utill.class.getName());
	static ManagerVO manager = new ManagerVO();

	/**
	 * 호출시 셋팅값입력 - 초기셋팅시 필요<br>
	 * param int[3]<br>
	 * [0] 빙고판 크기 4 이상
	 * [1] 게임유형 1 인용 2cpu<br>
	 * [2] 랜덤여부 1random 2 수동
	 * [3] 난이도 1easy 2hard<br>
	 * [4] 빙고 갯수 1이상
	 * @param int[]
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.21	김진호               주석 수정 및 보드크기,빙고숫자 추가
	*/
	public Utill(int[] setting) {
		if (setting[3] == 2)
			this.max = (setting[0] * setting[0] * 4);
		else
			this.max = setting[0] * setting[0];
		// log.info(setting[3] + ": " + max);
		
		this.boardsize = setting[0];
		this.bingGo = setting[4];
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
	 * 18.06.21	김진호               랜덤제작 수정
	 */
	public int[][] startSetting(int[] setting) {
		Scanner sc = new Scanner(System.in);
		int[][] firstboard = new int[setting[0]][setting[0]];

		ManagerVO numberchking = new ManagerVO();
		numberchking.setChoiceNum(new int[setting[0] * setting[0] * 4]);
		int[] inserNumbers = new int[500];
		int insertcount = 0;
		numberchking.setInsertcount(insertcount);
		
		/*for (int i = 0; i < setting.length; i++) {
			System.out.println(setting[i]);
		}*/

		int randomNum = 1;
		if (setting[2] == 1) {
//			System.out.println("랜덤제작");
			numberchking.setSwich("랜덤제작");
			for (int i = 0; i < firstboard.length; i++) {
				for (int j = 0; j < firstboard.length; j++) {
					do {
						randomNum = ((int) (Math.random() * max) + 1);
						numberchking.setInsertNum(randomNum);
					} while (!insertCheck(numberchking));
					inserNumbers[insertcount] = randomNum;
					numberchking.setChoiceNum(inserNumbers);
					numberchking.setInsertcount(++insertcount);
					firstboard[i][j] = randomNum;
				}
			}
//			테스트용 뷰
//			boardInsertview(firstboard);
		} else {

			for (int i = 0; i < firstboard.length; i++) {
				for (int j = 0; j < firstboard.length; j++) {
					
					boolean areaCheck = false;

					int num = 0;
					String temp;

//					테스트용 뷰
					boardInsertview(firstboard);
					
					do {
						System.out.print("번호를 입력하세요 : ");
						temp = sc.next();
						num = whileNumberInserting(temp);
						areaCheck = insertArea(num);
					} while (!areaCheck);
					
					
					firstboard[i][j] = num;
				}
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
		if (!check && !isertVO.getSwich().equals("랜덤제작"))
		{
//			System.out.println(!check + " : " +isertVO.getSwich() + " : " +isertVO.getSwich().equals("랜덤제작"));
			log.info("이미 입력하신 번호 입니다.");
		}
			
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

		if (check){
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
	 * @return  BoardVO
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
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public void inserNumbersView(){
		int[] insertNumber = manager.getChoiceNum();
		int insercount = manager.getInsertcount();
		int [] numberSort = new int[insercount];
		
		for (int i = 0; i < insercount; i++) {
			numberSort[i] = insertNumber[i] ;
		}
		
		Arrays.sort(numberSort);
		
		for (int i = 0; i < insercount; i++) {
			insertNumber[i] = numberSort[i] ;
		}
		
		System.out.println("===========사용된 숫자 입니다 ===========");
		for (int i = 0; i < insercount; i++) {
			System.out.printf(" %3d ",insertNumber[i]);
			if ((i+1)%5 ==0 && i !=0) {
				System.out.println();
			}
		}

		System.out.println("\n========================================");
	}
	
	/**
	 * 빙고갯수 출력
	 * @param BoardVO
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.21	김진호               작성
	*/
	public int bingGoALLCount(BoardVO boVo){
		int result = 0;
		
		for (int i = 0; i < boardsize; i++) {
			result += xLineCount(boVo.getCheckboard(), i);
			result += yLineCount(boVo.getCheckboard(), i);
		}
		result += xyLineCount(boVo.getCheckboard(), 1);
		result += xyLineCount(boVo.getCheckboard(), 2);
		
		return result;
	}
	
	/**
	 * 가로 체크 수
	 * @param boolean[][] , int
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.21	김진호               작성
	*/
	public int xLineCount(boolean[][] board , int line){
		int result = 0;
		
		for (int i = 0; i < board.length; i++) {
			if (board[line][i] == true) {
				result++;
			}
		}
		
		return result;
	}
	
	/**
	 * 세로 체크 수
	 * @param boolean[][] , int
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.21	김진호               작성
	*/
	public int yLineCount(boolean[][] board , int line){
		int result = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][line]) {
				result++;
			}
		}
		return result;
	}
	
	/**
	 * 대각선 체크 수 뒤의 int 1인경우 /대각선 2일경우 역방향
	 * @param boolean[][] , int
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.20	김진호               작성
	*/
	public int xyLineCount(boolean[][] board , int line){
		int result = 0;
		if (line==1) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][i]) {
					result++;
				}
			}
		}else {
			for (int i = 0; i < board.length; i++) {
				if (board[boardsize-i-1][i]) {
					result++;
				}
			}
		}
		return result;
	}
	/**
	 * 입력값 확인 후 활성화
	 * @param boolean[][] , int
	 * @return  int
	 * @version 0.1
	 * @see <pre>
	 * == 개정이력(Modification Information) ==
	 *   수정일         수정자           수정내용
	 * 18.06.21	김진호               작성
	*/
	public BoardVO insertChecking(int number ,BoardVO boVo){
		
		int[][] board = boVo.getNumberboard();
		boolean[][] checkboard = boVo.getCheckboard();
		
		for (int i = 0; i < checkboard.length; i++) {
			for (int j = 0; j < checkboard.length; j++) {
				if (board[i][j] == number) {
					checkboard [i][j] = true;
				}
			}
		}
		
		return boVo;
	}
	
	
	
}
