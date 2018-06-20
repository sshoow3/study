package com.test.sample;

import java.util.*;

public class test002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] testarr = new int[200];
		String[] test = new String[50];
		
		for (int i = 0; i < 49; i++) {
			testarr[i] = (int) (Math.random()*999);
			test[i] = testarr[i] +"";
		}
		
		
		for (int i = 0; i < 30; i++) {
			System.out.printf(" %3d ",testarr[i]);
			if ((i+1)%5==0 && i!=0) {
				System.out.println();
			}
		}
		System.out.println();
		Arrays.sort(testarr);
		
		for (int i = 0; i < 30; i++) {
			System.out.printf(" %3d ",testarr[i]);
			if ((i+1)%5==0 && i!=0) {
				System.out.println();
			}
		}
		System.out.println();
		Arrays.sort(test, Collections.reverseOrder());
		
		for (int i = 0; i < 30; i++) {
			System.out.printf(" %3s  ",test[i]);
			if ((i+1)%5==0 && i!=0) {
				System.out.println();
			}
		}

	}

}
