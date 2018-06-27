package com.test.sample;

public class Runtime {
	long start ;
	long end ;
	
	public void runStart(){
		start = System.currentTimeMillis();
	}
	
	public void runend(){
		end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}
}
