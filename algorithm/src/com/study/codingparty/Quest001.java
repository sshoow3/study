package com.study.codingparty;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Quest001 {
	 /*
	 * 배달의민족은 시범적으로 새로운 광고 상품을 만들기로 하였습니다. 시범 서비스이기 때문에, 일부분의 지역에서 3개의 업소를 대상으로만 진행해 볼 생각입니다.
	각 업소는 직사각형 모양의 광고 영역을 설정하고, 단위 영역 당 지불할 광고비를 책정하여 배달의민족에 제출합니다. 특정 지역은 2개 이상의 업소의 광고 영역에 포함될 수 있는데, 
	이 때는 가장 높은 광고비를 책정한 업소의 광고만 노출 됩니다. 광고비 정산은, 
	업소가 정한 단위 영역 당 광고비와 광고 노출 영역의 곱으로 이루어지기 때문에 각 업소의 광고 상품이 노출되는 면적을 알아내는 것이 필요합니다.
	3개 업소에서 단위 영역 당 지불하는 광고비의 오름차순으로 업소 번호를 부여했을 때, 1번 업소가 노출되는 영역의 면적은 얼마인지 구하는 프로그램을 작성하십시오.

	위에서 각 직사각형의 좌표가 다음과 같다고 하면
	1번 직사각형의 왼쪽 아래 좌표가 (700, 400), 오른쪽 위 좌표가 (1600, 1100)
	2번 직사각형의 왼쪽 아래 좌표가 (0, 400), 오른쪽 위 좌표가 (1100, 900)
	3번 직사각형의 왼쪽 아래 좌표가 (900, 0), 오른쪽 위 좌표가 (1800, 650)

	1번 직사각형과 2번 또는 3번이 겹치는 영역에서는 2번과 3번이 단위 영역 당 광고비를 더 많이 지불했음으로 1번 업소의 광고가 노출이 안 되게 됩니다. 
	위 그림에서 1번 업소가 노출되는 영역의 면적은, 점선 위 영역과(900 * 200 = 180,000) 점선 아래 영역을(500 * 250 = 125,000)을 합한 305,000이 됩니다.

	광고비 정산은, 업소가 정한 단위 영역 당 광고비와 광고 노출 영역의 곱으로 이루어지기 때문에 각 업소의 광고 상품이 노출되는 면적을 알아내는 것이 필요합니다.

	입력은 한 줄에 다음과 같이 12개의 정수가 공백으로 구분되어 주어집니다.
	x1  y1  x2  y2  x3  y3  x4  y4  x5  y5  x6  y6
	1번 업소 직사각형의 왼쪽 아래 꼭지점이 (x1,y1), 오른쪽 꼭지점이 (x2,y2)
	2번 업소 직사각형의 왼쪽 아래 꼭지점이 (x3,y3), 오른쪽 꼭지점이 (x4,y4)
	3번 업소 직사각형의 왼쪽 아래 꼭지점이 (x5,y5), 오른쪽 꼭지점이 (x6,y6)

	각 꼭지점의 x, y 값은 모두 1이상 10,000 이하이며, 표준 입력으로 12개의 정수가 주어졌을 때 1번 업소의 노출 영역의 면적을 출력하는 프로그램을 작성하십시오.
	*/	
	static int[][] company = new int[3][5];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] insert = new int[12];
		int count = 0 ;
		Scanner sc = new Scanner(System.in);
		while (count < 12) {
			System.out.print(" 입력 : ");
			String temp = sc.nextLine();
			temp = temp.trim();
			if (Checkking(temp)) {
				String[] temparr = temp.split(" ");
				for (int i = 0; i < temparr.length; i++) {
					if (NumberChecking(temparr[i])) {
						insert[count++] = Integer.parseInt(temparr[i]);
					} 
				}
			}else if (NumberChecking(temp)) {
				insert[count++] = Integer.parseInt(temp);
			} 
			
		}
		
		for (int i = 0; i < insert.length; i++) {
			System.out.print(insert[i]+"  ");
		}
		System.out.println();
		insert = setting(insert);
		for (int i = 0; i < insert.length; i++) {
			System.out.print(insert[i]+"  ");
		}
	
	}
	
	public static boolean NumberChecking(String temp){
		boolean check = false;

		check = Pattern.matches("^[0-9]*$", temp);
		System.out.println(temp + "숫자"+check);
		return check;
	}
	
	public static boolean Checkking(String temp){
		boolean check = false;

		check = Pattern.matches("^[\\d]*+([\\s]+[\\d]*){0,11}$", temp);
		System.out.println(temp + "공백"+check);

		return check;
	}
	
	public static int[] setting(int[] insert){
		
		for (int i = 0; i < 3; i++) {
			if (insert[(i*4)] > insert[(i*4)+2]) {
				int temp = 0;
				temp = insert[(i*4)];
				insert[(i*4)] = insert[(i*4)+2];
				insert[(i*4)+2] = temp;
				System.out.println(insert[(i*4)] + " x:x " + insert[(i*4)+2]);
			}
			if (insert[(i*4)+1] > insert[(i*4)+3]) {
				int temp = 0;
				temp = insert[(i*4)+1];
				insert[(i*4)+1] = insert[(i*4)+3];
				insert[(i*4)+3] = temp;

				System.out.println(insert[(i*4)+1] + " y:y " + insert[(i*4)+3]);
			}
			
		}
		
		return insert;
	}
	
	public static void basicArea(int[] insert){
		
		int bigarea = 0;
		
		for (int i = 0; i < 3; i++) {
			int x= insert[(i*4)+2] - insert[(i*4)];
			int y = insert[(i*4)+3] - insert[(i*4)+1];
			int area = x*y;
			company[i][0]= area;
			company[i][1]= insert[(i*4)];
			company[i][2]= insert[(i*4)+1];
			company[i][3]= insert[(i*4)+2];
			company[i][4]= insert[(i*4)+3];
		}
		for (int i = 0; i < company.length-1; i++) {
			for (int j = i+1; j < company.length-1; j++) {
				if (company[i][0] > company[j][0]) {
					swap(i,j);
				}
			}
		}
	}
	
	public static void swap(int i,int k){
		
		for (int j = 0; j < company[i].length; j++) {
			int temp = 0;
			temp = company[i][j];
			company[i][j] = company[k][j];
			company[k][j] = temp;
		}
	}
	
	public static void overArea(){
		for (int i = 0; i < company.length-1; i++) {
			int x1,x2,y1,y2 = 0;
			int xcount = 0,ycount = 0;
			
			if ((company[0][1] >= company[i][1] && company[0][1] >= company[i][3])||
					(company[0][3] >= company[i][1] && company[0][3] >= company[i][3])) {
//				x라인 겹치는곳이 있다
				if ((company[0][2] >= company[i][2] && company[0][2] <= company[i][4])||
						(company[0][2] >= company[i][2] && company[0][2] <= company[i][4])){
//					y라인 겹치는것이 있다 = 겹처서 보이지 않는 영역이 있다
					
				}
			}
			
		}
	}
	
	public static void between(int i){
		
		
	}
	
	
}
