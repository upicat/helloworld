package xm.demo;

import java.util.Arrays;

public class AbstractDemo {
	protected void println(Object o){
		System.out.println(o);
	}
	
	protected void printArr(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	protected void printArr(Object[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	protected void printArr(int[] arr, int j) {
		int[] arr2 = new int[j];
		System.arraycopy(arr, 0, arr2, 0, j);
		System.out.println(Arrays.toString(arr2));
	}
	
	protected void printArr(int[][] arr){
		System.out.println(Arrays.toString(arr));
	}
}
