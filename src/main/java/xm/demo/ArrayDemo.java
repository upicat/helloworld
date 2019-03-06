package xm.demo;

import java.util.Arrays;
import java.util.Collections;

import org.assertj.core.internal.Lists;
import org.springframework.stereotype.Component;

@Component("arrayDemo")
public class ArrayDemo extends AbstractDemo{

	public int rmElements(int[] arr, int e) {
		int i = 0, j = 0;

		for (; i < arr.length; i++) {
			if (e == arr[i]) {
				j++;
			} else {
				arr[i - j] = arr[i];
			}
		}

		printArr(arr, i - j);
		return i - j;
	}

	public int rmElements2(int[] arr, int e) {
		int i = 0, j = 0;

		for (; i < arr.length; i++) {
			if (e == arr[i]) {
				continue;
			}
			arr[j++] = arr[i];
		}

		printArr(arr, j);
		return j;
	}

	public int rmElements3(int[] arr) {
		int i = 0, j = 0;

		for (i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i]) {
				continue;
			}
			arr[++j] = arr[i];
		}

		printArr(arr, j + 1);
		return j + 1;
	}

	public int rmElements4(int[] arr, int n) {
		int i = 0, j = 0, k = 0;

		for (i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i]) {
				k++;
			} else {
				k = 0;
			}
			if (k > n - 1) {
				continue;
			}
			arr[++j] = arr[i];
		}

		printArr(arr, j + 1);
		return j + 1;
	}

	public static void main(String[] args) {
		System.out.println(new ArrayDemo().rmElements(new int[] { 1, 2, 2, 3, 4, 4, 2, 5 }, 2));
		System.out.println(new ArrayDemo().rmElements2(new int[] { 1, 2, 2, 3, 4, 4, 2, 5 }, 2));
		System.out.println(new ArrayDemo().rmElements3(new int[] { 1, 2, 2, 3, 4, 4, 5 }));
		System.out.println(new ArrayDemo().rmElements4(new int[] { 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 5 }, 2));
	}

}
