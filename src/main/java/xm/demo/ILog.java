package xm.demo;

import java.util.Arrays;

public interface ILog {
	default void println(Object o){
		System.out.println(o);
	}
	
	default void printArr(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	default void printArr(Object[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	default void printArr(int[] arr, int j) {
		int[] arr2 = new int[j];
		System.arraycopy(arr, 0, arr2, 0, j);
		System.out.println(Arrays.toString(arr2));
	}
	
	default void printArr(int[][] arr){
		System.out.println(Arrays.toString(arr));
	}
}
