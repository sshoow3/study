package com.study.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Quest024 {
	
	static ArrayList<String> list = new ArrayList<String>();

	static public void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 어떤 대상을 순서에 따라 배열한 것을 순열이라고 합니다. 예를 들어 3124는 숫자 1, 2, 3, 4로 만들 수 있는 순열
		 * 중 하나입니다.
		 * 
		 * 이렇게 만들 수 있는 모든 순열을 숫자나 문자 순으로 늘어놓은 것을 사전식(lexicographic) 순서라고 합니다. 0,
		 * 1, 2로 만들 수 있는 사전식 순열은 다음과 같습니다.
		 * 
		 * 012 021 102 120 201 210 0, 1, 2, 3, 4, 5, 6, 7, 8, 9로 만들 수 있는 사전식
		 * 순열에서 1,000,000번째는 무엇입니까?
		 */


		int sample[] = { 0,1, 2, 3 , 4, 5, 6, 7, 8, 9};
		int temp[] = new int[10];
		int example[] = { 0,1, 2};
		perm(sample, 0, 10, 10);
		
		System.out.println(list.size());
//		3628800
		
		
		System.out.println(list.get(999999));
		System.out.println(list.get(1000000));
		System.out.println(list.get(1000001));
		
//		2785960341
//		2785960431
//		2785960413
		
		
		Collections.sort(list);
		
		
		System.out.println(list.get(999999));
		System.out.println(list.get(1000000));
		System.out.println(list.get(1000001));
		
//		2783915460
//		2783915604
//		2783915640
		
		
	}

	public static void perm(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			// 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
			print(arr, k);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	} // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int count =1;

	public static void print(int[] arr, int k) {
//		if (count<=1000001) {
//			System.out.print((count++) + " : ");
		String temp = "";
		
			for (int i = 0; i < k; i++) {
//				if (i == k - 1)
//					System.out.println(arr[i]);
//				else
//					System.out.print(arr[i] + ",");
//				1000000 : 2,7,8,5,9,6,0,3,4,1
//				2785960341
				temp += arr[i];
			}
//			System.out.println(temp);
			list.add(temp);
//		}
	}
	
	
	
}
