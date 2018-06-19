package com.test.board;

public class CPUVO {
	static int [][] numberboard;
	static boolean[][] checkboard;
	public static int[][] getNumberboard() {
		return numberboard;
	}
	public static void setNumberboard(int[][] numberboard) {
		UserVO.numberboard = numberboard;
	}
	public static boolean[][] getCheckboard() {
		return checkboard;
	}
	public static void setCheckboard(boolean[][] checkboard) {
		UserVO.checkboard = checkboard;
	}
}
