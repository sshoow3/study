package com.test.sample;

import java.util.ArrayList;

public class CheckVO {
	String line ;
	int lineNumber;
	int count;
	int falseBingNum;
	int[] falseNumbers;
	
	public int[] getFalseNumbers() {
		return falseNumbers;
	}
	public void setFalseNumbers(int[] falseNumbers) {
		this.falseNumbers = falseNumbers;
	}
	public int getFalseBingNum() {
		return falseBingNum;
	}
	public void setFalseBingNum(int falseBingNum) {
		this.falseBingNum = falseBingNum;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
