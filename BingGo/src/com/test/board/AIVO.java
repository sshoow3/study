package com.test.board;

public class AIVO {

	String lineType ;
	int line;
	int trueCount;
	public int getTrueCount() {
		return trueCount;
	}
	public void setTrueCount(int trueCount) {
		this.trueCount = trueCount;
	}
	public String getLineType() {
		return lineType;
	}
	public void setLineType(String lineType) {
		this.lineType = lineType;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getFalseCheckingNum() {
		return falseCheckingNum;
	}
	public void setFalseCheckingNum(int falseCheckingNum) {
		this.falseCheckingNum = falseCheckingNum;
	}
	public int[] getFalseNumbers() {
		return falseNumbers;
	}
	public void setFalseNumbers(int[] falseNumbers) {
		this.falseNumbers = falseNumbers;
	}
	int falseCheckingNum;
	int[] falseNumbers;
	
}
