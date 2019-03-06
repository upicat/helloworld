package xm.demo;

import org.springframework.stereotype.Component;

@Component
public class TriangleDemo extends AbstractDemo{
	public int[][] getTriangle(int level) {
		int[][] arr = new int[level][level];
		for (int i = 0; i < level; i++) {
			try {
				if (i == 0) {
					arr[0][0] = 1;
					continue;
				}
				for (int j = 0; j <= i; j++) {
					arr[i][j] = (j - 1 < 0 ? 0 : arr[i - 1][j - 1]) + arr[i - 1][j];
				}
			} finally {
			}
		}
		return arr;
	}

	public int[] getTriangleDirect(int level) {
		int[] arr = new int[level];
		arr[0] = 1;
		for (int i = 1; i < level+1; i++) {
			try {
				for (int j = i - 1; j >= 0; j--) {
					arr[j] = (j - 1 < 0 ? 0 : arr[j - 1]) + arr[j];
				}
			} finally {
				println(arr);
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int n = 100;
//		 new TriangleDemo().prints(new TriangleDemo().getTriangle(n));
		new TriangleDemo().getTriangleDirect(n);
		
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-4>>1));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
	}

}
