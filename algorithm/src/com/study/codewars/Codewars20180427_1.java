package com.study.codewars;

/*Instructions
Output
Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in descending order. Essentially, 
너는                     만든다           작동하도록       그것은 가능하다     모든     Integer 형이 아닌                      값 과     그리고           결과    와          

당신의 임무는 모든 음이 아닌 정수를 인수로 취할 수있는 함수를 만들고 그 자릿수를 내림차순으로 반환하는 것입니다. 본질적으로,         
rearrange the digits to create the highest possible number.
                                                생성 이   가능한 숫자중 가장 큰것
                                                가장 높은 숫자를 만들기 위해 숫자를 재정렬하십시오.
Examples:
Input: 21445 Output: 54421

Input: 145263 Output: 654321

Input: 1254859723 Output: 9875543221*/

public class Codewars20180427_1 {
	
	public static void main(String[] args) {
		
		sortDesc(1254859723);
	}
	
	public static int sortDesc(final int num) {
	    //Your code
	    int num_temp = num;
	    String length = "" + num_temp;
	    int[] temp = new int[length.length()];
	    
	    int resultnum = 0;
	    
	    for(int i=0; i<length.length(); i++)
	    {
	      temp[i] = num_temp %10;
	      num_temp = num_temp/10;
	    }
	    
	    for(int i=0; i<temp.length; i++)
	    {
	      for(int j=i+1; j<temp.length; j++)
	      {
//	       System.out.println(i + " " + j); 
	        if(temp[i] < temp [j])
	        {
	          int x = temp[i];
	          temp[i] = temp[j];
	          temp[j] = x;
	        };
	        
	      }
	      System.out.print(temp[i]);
//	      resultnum += temp[i] * (10^(length.length()-i));
	    }
//	    System.out.println("end");
	    
	    return resultnum;
	  }
}
