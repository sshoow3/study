package com.test.board;
/**
 * 게임 관리<br>
 * choiceNum - 입력된 값들<br>
 *  insertcount - 입력값 갯수<br>
 * @param int[][] choiceNum ,int insertcount
 * @version 0.1
 * @see <pre>
 * == 개정이력(Modification Information) ==
 *   수정일         수정자           수정내용
 * 18.06.20	김진호               작성
*/
public class ManagerVO {
	private int[] choiceNum = new int[500];
	private int insertcount = 0;
	private int insertNum = 0;
	private String swich = "";
	
	
	public String getSwich() {
		return swich;
	}
	public void setSwich(String swich) {
		this.swich = swich;
	}
	public int getInsertNum() {
		return insertNum;
	}
	public void setInsertNum(int insertNum) {
		this.insertNum = insertNum;
	}
	public int[] getChoiceNum() {
		return choiceNum;
	}
	public void setChoiceNum(int[] choiceNum) {
		this.choiceNum = choiceNum;
	}
	public int getInsertcount() {
		return insertcount;
	}
	public void setInsertcount(int insertcount) {
		this.insertcount = insertcount;
	}
	
	
}
