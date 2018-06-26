package com.study.algorithm;

import java.util.Calendar;

public class Quest019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
다음은 달력에 관한 몇 가지 일반적인 정보입니다 (필요한 경우 좀 더 연구를 해 보셔도 좋습니다).

1900년 1월 1일은 월요일이다.
4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월, 10월, 12월은 31일까지 있다.
2월은 28일이지만, 윤년에는 29일까지 있다.
윤년은 연도를 4로 나누어 떨어지는 해를 말한다. 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며, 400으로 나누어 떨어지면 윤년이다
20세기 (1901년 1월 1일 ~ 2000년 12월 31일) 에서, 매월 1일이 일요일인 경우는 총 몇 번입니까?
*/	
		Calendar cal = Calendar.getInstance();
		
		int count = 0;
		
		int month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		int date = 0;
		
		
		String days[] = {"일","월","화","수","목","금","토"};
		
		
		for (int year = 1901; year < 2001; year++) {
			if ((year % 4 ==0 && year % 100 != 0) || year%400 ==0 ) {
				month[1] = 29;
			}
			else {
				month[1] = 28;
			}
			
			
			
			if (year == 1901) {
				
			}else {
				date += month[11];
//				System.out.println(year + "년    1월 요일 = " +days[date%7]);
			}
			
			if (days[date%7].equals("일")) {
				System.out.println(year + "년    1월 요일 = " + days[date%7]);
				count++;
			}
			
			for (int i = 0; i < 11; i++) {
				date += month[i];
//				System.out.println(year + "년  "+(i+2)+"월 요일 = " +days[date%7]);
				
				if (days[date%7].equals("일")) {
					count++;
					System.out.printf("%d년   %2d월 요일 = "+days[date%7]+"\n" , year , (i+2));
				}
			}
		}
		
		System.out.println(count);
//		172	
		count = 0;
		date = 0;
		
		for (int i = 1901; i <2001; i++) {
			
		
			if ((i % 4 == 0 && i % 100 !=0 )||(i%400==0) ) {
				month[1] = 29;
//				System.out.println(i + "a");
			}else {
				month[1] = 28;
//				System.out.println(i + "b");
			}
			
			
			//171
			for (int j = 0; j < 12; j++) {
				date = (365 * (i-1901)) + (((i-1901)/4) -((i-1901)/100)+ ((i-1901)/400)); 
				for (int j2 = 0; j2 < j; j2++) {
					date += month[j2];
//					System.out.println(j + " : " +j2 + " : " + month[j2]);
					}			
				
				int y = i;
				
				int d = 1;
				
				int day = (date) % 7; 
//				System.out.println(date + " : " + day);		
//				System.out.println("year : " + y + ": " + (j+1) + " : " + d +  " : " + day + " day " + days[day]);
				
				if (day == 0) {
					count ++;
					System.out.println("year : " + y + ": " + (j+1) + " : " + d +  " : " + day + " day " + days[day]);
					}
			}
			
			

			
			
		}
		
		System.out.println(count);
		
		
	}

}
