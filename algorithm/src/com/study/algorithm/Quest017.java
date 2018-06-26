package com.study.algorithm;

public class Quest017 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
1부터 5까지의 숫자를 영어로 쓰면 one, two, three, four, five 이고,
각 단어의 길이를 더하면 3 + 3 + 5 + 4 + 4 = 19 이므로 사용된 글자는 모두 19개입니다.

1부터 1,000까지 영어로 썼을 때는 모두 몇 개의 글자를 사용해야 할까요?

참고: 빈 칸이나 하이픈('-')은 셈에서 제외하며, 단어 사이의 and 는 셈에 넣습니다.
  예를 들어 342를 영어로 쓰면 three hundred and forty-two 가 되어서 23 글자,
  115 = one hundred and fifteen 의 경우에는 20 글자가 됩니다.
1 one
2 two
3 three
4 four 
5 five
6 six
7 seven
8 eight 
9 nine
10 ten
11  eleven
12  twelve
13  thirteen
14  fourteen
15	fifteen
16	sixteen
17	seventeen
18	eighteen
19	nineteen
20. twenty
30. thirty
40. forty
50. fifty
60. sixty
70. seventy
80. eighty
90. ninety
100.one hundred
115.one hundred and fifty
1000.one thousand

*/		
//		11~19 
//		숫자의 자릿수가 2보다 작을경우 1~9
//		숫자의 자릿수가 2보다 크거나 같지만 숫자가 20보다 작은경우
//		숫자의 자릿수가 2보다 크거나 같을경우
		
		String text[] = {"","one","two","three","four","five","six","seven","eight","nine","ten"
				,"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		
		String ty[] = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		
		String hundred = "hundred";
		String thousand = "thousand";
		
		String txt[] = new String[1000];
		
		int count = 0;
		
		for (int a = 1; a <= 1000; a++) {
			int length = (int)(Math.log10(a)+1);
			
			String temp = "";
			
//			System.out.println(a);
			
			if (a <20) {
				temp += text[a];
			}else if(length==2){
				temp += ty[a/10];
				if (a%10 != 0) 
					temp += "-"+ text[a%10];
			}else if(length==3){
				temp += text[a/100] + " " + hundred;
				
				if (a%100 <20 && a%100 !=0)
				{
					temp += " and "+text[(a%100)];
				}else if(a%100 >=20 ){
					temp += " and "+ ty[(a%100)/10];
					
					if (a%10 != 0) 
						temp +=  "-" + text[a%10];
				}
				
				
			}else if(length==4){
				temp += text[1]+ " "+thousand;
			}
			txt[a-1] = temp;
			
			temp = temp.replace(" ", "");
			temp = temp.replace("-", "");
			count += temp.length();
			System.out.println(txt[a-1] + " : " + temp.length() );
		}
		System.out.println(count);
//		21124
		
		
	
	}

}
