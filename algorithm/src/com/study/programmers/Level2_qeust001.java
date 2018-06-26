package com.study.programmers;

public class Level2_qeust001 {

	public static void main(String[] args) {
		/**
		 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
			124 나라에는 자연수만 존재합니다.
			124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
			예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
			
			10진법	124 나라	10진법	124 나라
				1	1		6		14
				2	2		7		21
				3	4		8		22
				4	11		9		24
				5	12		10		41
			자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
			
			n은 500,000,000이하의 자연수 입니다.
		 */
		
		String numberal = numeralSystem(130, 12);
		
		numberal = numberal.replaceAll("3", "4");
		
		System.out.println(numberal);

	}
	
	/**
	 * 진법 출력
	 * @param num
	 * @param numeral
	 * @return
	 */
	public static String numeralSystem(int num , int numeral){
		String temp = "";
		boolean check = true;
		if (numeral > 16) {
			temp = "16진수 까지만 가능합니다.";
			while (check) {
//				System.out.println(num + " " + exponentiation + " " + temp);
				if (num/numeral < 1 ) {
					temp = numeralSytstem(num,numeral) +temp;
					num = num/numeral;
					check = false;
				}else {
					temp = numeralSytstem(num,numeral) +temp;
					num = num/numeral;
				}
				
			}
		}
		
		
//		System.out.println(temp);
		return temp;
	}
	
	public static String numeralSytstem(int num , int numeral){
		String temp = "";
//		System.out.println(num +" " + numeral + " ,," + (num % numeral) + " " + (num / numeral));
		if (num % numeral > 9) {
			temp = (char)(87+(num % numeral))+"";
		}else {
			temp = ((num  % numeral))+"";
		}
		
		return temp;
	}

}
