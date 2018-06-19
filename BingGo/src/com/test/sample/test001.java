package com.test.sample;

import java.util.regex.Pattern;

public class test001 {

	/**
	 * 입력값 이외의 자료형 포함여부 체크
	 * param = String 입력값 , int 검사종류
	 * 1. 한글여부 
	 * return boolean
	 * 참고 자료 : http://superfelix.tistory.com/70
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 2. 정규표현식 기본 문법
		^ : 문자열의 시작을 나타냄
		$ : 문자열의 종료를 나타냄
		. : 임의의 한문자를 나타냄 
		I : or를 나타냄
		[] : 문자열 클래스 지정시 사용
		\w : 알파벳이나 숫자
		\W : 알파벳이나 숫자를 제외한 문자
		\d : 숫자 [0-9]와 동일
		
		1) 한글만 구분
		(1) 정규식 : ^[ㄱ-ㅎ가-힣]*$ 
		(2) 메소드 : boolean a = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", "비교문자");
		(3) 예 : boolean a = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", "가지"); 
		2) 영문자(대소문자 구분함)
		(1) 정규식 : ^[a-zA-Z]*$
		(2) 메소드 : boolean b = Pattern.matches("^[a-zA-Z]*$", "비교문자");
		(3) 예 : boolean b = Pattern.matches("^[a-zA-Z]*$", "Felix");
		3) 영어소문자
		(1) 정규식: ^[a-z]*$
		(2) 메소드 : boolean c = Pattern.matches("^[a-z]*$", "비교문자");
		4) 숫자
		(1) 정규식 : ^[0-9]*$ 
		(2) 메소드 : boolean c = Pattern.matches("^[0-9]*$", "비교문자");
		5) 한글과 숫자
		(1) 정규식 : ^[ㄱ-ㅎ가-힣0-9]*$
		(2) 메소드 : boolean c = Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", "비교문자");
		
		 (?i) 대소문자 구분 안함
		*/
		String[] test = {"TEST" , "Test123" , "test" , "123","EN한글" ,"한글2019","!@#$%^" ," "};
		
		System.out.println();
		boolean a = false;
		boolean b = false;
		boolean c = false;
		boolean d = false;
		boolean e = false;
		boolean f = false;
		System.out.println( "           한글 , 영어 , 소문자 , 대문자 ,숫자 , 한글+숫자  " );
		for (int i = 0; i < test.length; i++) {
			a = Pattern.matches("^*[ㄱ-ㅎ가-힣]*$", test[i]);
			b = Pattern.matches("^*[a-zA-Z0-9]*$", test[i]);
			c = Pattern.matches("^*[a-z]*$", test[i]);
			f = Pattern.matches("^*[A-Z]*$", test[i]);
			d = Pattern.matches("^*[\\d]*$", test[i]);
			e = Pattern.matches("^*[\\D]*$", test[i]);
			System.out.println(test[i] + " : " +a +" , " +b +" , " +c +" , "+f +" , " +d +" , " +e );
		}
		
		
	}

}
