package com.test.board;

public class BoardVO {
	private int [][] numberboard;
	private boolean[][] checkboard;
	public  int[][] getNumberboard() {
		return numberboard;
	}
	public  void setNumberboard(int[][] numberboard) {
		this.numberboard = numberboard;
	}
	public  boolean[][] getCheckboard() {
		return checkboard;
	}
	public  void setCheckboard(boolean[][] checkboard) {
		this.checkboard = checkboard;
	}
}
