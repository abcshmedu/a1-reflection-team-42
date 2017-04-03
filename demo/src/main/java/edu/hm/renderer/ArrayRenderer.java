package edu.hm.renderer;

import java.util.Arrays;

public class ArrayRenderer {

	public String render(int[] arr){
		String res = "";
		res = Arrays.toString(arr);
		return res;
	}
	
	public static void main (String[] args){
		int[] test = new int[4];
		test[0] = 1;
		test[1] = 2;
		test[2] = 3;
		test[3] = 4;
		
		System.out.println(test.getClass().getSimpleName());
	}
}
