package xm.demo;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class SortDemo {
	private static int partition(int[] array, int lo, int hi) {
		// 固定的切分方式
		int key = array[lo];
		while (lo < hi) {
			while (array[hi] >= key && hi > lo) {// 从后半部分向前扫描
				hi--;
			}
			array[lo] = array[hi];
			while (array[lo] <= key && hi > lo) {// 从前半部分向后扫描
				lo++;
			}
			array[hi] = array[lo];
		}
		array[hi] = key;
		return hi;
	}
	int count = 0;
	public void sort(int[] array, int lo, int hi) {
		try {
			count++;
			if (lo >= hi) {
				return;
			}
			int index = partition(array, lo, hi);
			sort(array, lo, index - 1);
			sort(array, index + 1, hi);
		} catch (Throwable e) {
			System.out.println("--->"+count);
		}finally {
			count--;
		}
		
	}

	private static int[] getRandomArr(int length, int maxVal) {
		int[] ret = new int[length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = RandomUtils.nextInt(0, maxVal);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		SortDemo demo = new SortDemo();
		int length = 100000;
		int[] arr = getRandomArr(length, length/100); // length*100
		int[] arrCopy = Arrays.copyOf(arr, arr.length);
		
		long s = System.currentTimeMillis();
		demo.sort(arrCopy, 0, length - 1);
		System.out.println(System.currentTimeMillis() - s);
		s = System.currentTimeMillis();
		demo.sort(arrCopy, 0, length - 1);
		System.out.println(System.currentTimeMillis() - s);
		
		arrCopy = Arrays.copyOf(arr, arr.length);
		s = System.currentTimeMillis();
		Arrays.sort(arrCopy);
		System.out.println(System.currentTimeMillis() - s);
		s = System.currentTimeMillis();
		Arrays.sort(arrCopy);
		System.out.println(System.currentTimeMillis() - s);
	}

}
