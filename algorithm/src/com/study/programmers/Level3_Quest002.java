package com.study.programmers;

public class Level3_Quest002 {
	
	static int n ;
	static int[] money;
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**
 * 거스름돈
	문제 설명
	Finn은 편의점에서 야간 아르바이트를 하고 있습니다. 야간에 손님이 너무 없어 심심한 Finn은 손님들께 거스름돈을 n 원을 줄 때 방법의 경우의 수를 구하기로 하였습니다.
	
	예를 들어서 손님께 5원을 거슬러 줘야 하고 1원, 2원, 5원이 있다면 다음과 같이 4가지 방법으로 5원을 거슬러 줄 수 있습니다.
	
	1원을 5개 사용해서 거슬러 준다.
	1원을 3개 사용하고, 2원을 1개 사용해서 거슬러 준다.
	1원을 1개 사용하고, 2원을 2개 사용해서 거슬러 준다.
	5원을 1개 사용해서 거슬러 준다.
	거슬러 줘야 하는 금액 n과 Finn이 현재 보유하고 있는 돈의 종류 money가 매개변수로 주어질 때, Finn이 n 원을 거슬러 줄 방법의 수를 return 하도록 solution 함수를 완성해 주세요.
	
	제한 사항
	n은 100,000 이하의 자연수입니다.
	화폐 단위는 100종류 이하입니다.
	모든 화폐는 무한하게 있다고 가정합니다.
	정답이 커질 수 있으니, 1,000,000,007로 나눈 나머지를 return 해주세요.
	입출력 예
	n	money	result
	5	[1,2,5]	4
	입출력 예 설명
	입출력 예 #1
	문제의 예시와 같습니다.
	 */
		setting("");
		System.out.println("n : " + n);
		System.out.println("money : " );
		view();
		calc(0, n);
		System.out.println("result : " + count);
	}
	
	public static void setting(String test){
		n = 5;
		money = new int[2];
		money[0] = 2;
		money[1] = 1;
//		money[1] = 2;
//		money[2] = 1;
	}
	
	public static void setting(){
		n = (int) (Math.random()*100000)+1;
		int moneyType = (int) (Math.random()*100)+1;
		
		if (n < moneyType) moneyType = (int) (Math.random()*n)+1;;
		
		money = new int[moneyType];
		money[0] = 1;
		for (int i = 1; i < money.length; i++) {
			boolean ck;
			do {
				int a= (int) (Math.random()* (n) )+1;
				ck = !insertCheck(a);
				money[i] = a;
			} while (ck);
		}
		sort();
	}
	
	public static void setting(int number){
		n = number;
		int moneyType = (int) (Math.random()*number)+1;
		money = new int[moneyType];
		money[0] = 1;
		for (int i = 1; i < money.length; i++) {
			boolean ck = true;
			
			do {
				int a= (int) (Math.random()* (number) )+1;
				ck = !insertCheck(a);
				money[i] = a;
			} while (ck);
			
		}
		sort();
	}
	public static boolean insertCheck(int j){
		boolean check = true;
		for (int i = 0; i < money.length; i++) {
			if (money[i] == j) {
				System.out.println(i + ":" +money[i] + " , " + j);
				check = false;
			}
		}
		return check;
	}
	
	public static void sort(){
		for (int i = 0; i < money.length; i++) {
			for (int j = i+1; j < money.length; j++) {
				if (money[i] < money[j]) swarp(i,j);
			}
		}
	}
	
	public static void swarp(int i , int j){
		int temp = money[i];
		money[i] = money[j];
		money[j] = temp;
	}
	
	public static void calc(int i, int otherM){
		System.out.println(i + ":" + otherM + " : " + otherM/money[i]);
		
		for (int k = 0; k <= otherM/money[i] ; k++) {
			otherM = otherM-(money[i]);
			if (i+1 < money.length && otherM >= 0) {
				calc(i+1,otherM);
			}
		}
		
		if (otherM % money[i] == 0) {
			count++;	
		}
		
	}
	
	public static void view(){
//		System.out.println("money.length:" + money.length );
		for (int i = 0; i < money.length; i++) {
			if (i == money.length-1) {
				System.out.printf("[%6d]" , money[i]);
			}else {
				System.out.printf("[%6d],", money[i]);
			}
		}
		System.out.println();
	}

}
