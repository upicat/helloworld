package xm.demo;

import java.util.Arrays;
import java.util.Stack;

import org.springframework.stereotype.Component;

@Component
public class SumDemo extends AbstractDemo {
	private Stack<Integer> stack = new Stack<>();

	public void getAddends(int[] arr, int n, int t) {
		Arrays.sort(arr);
		_getAddends(arr, 0, n, t);
	}

	private int[] _getAddends(int[] arr, int s, int n, int t) {
		if (n == 1) {
			for (int i = s; i < arr.length; i++) {
				if (arr[i] == t) {
					stack.push(arr[i]);
					println(stack);
					stack.pop();
					break;
				}
			}
			return null;
		}

		for (int i = s + 1; i < arr.length; i++) {
			stack.push(arr[i - 1]);
			_getAddends(arr, i, n - 1, t - arr[i - 1]);
			stack.pop();
		}
		return null;
	}

	public void getClosest(int[] arr, int n, int t) {
		Arrays.sort(arr);
		_getClosest(arr, 0, n, t);
		printArr(cache);
	}

	private int gap = Integer.MAX_VALUE;
	private Object[] cache;

	private void _getClosest(int[] arr, int s, int n, int t) {
		if (n == 1) {
			for (int i = s; i < arr.length; i++) {
				int g = Math.abs(arr[i] - t);
				if (g < gap) {
					gap = g;
					stack.push(arr[i]);
					// println(stack);
					cache = stack.toArray();
					stack.pop();
				}
			}
			return;
		}

		for (int i = s + 1; i < arr.length; i++) {
			stack.push(arr[i - 1]);
			_getClosest(arr, i, n - 1,t - arr[i - 1]);
			if(gap == 0) {
				return;
			}
			stack.pop();
		}
		return;
	}

	public static void main(String[] args) {
		SumDemo demo = new SumDemo();
		 demo.getAddends(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5, 25);
		 demo.getClosest(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 3, 25);
	}
}
