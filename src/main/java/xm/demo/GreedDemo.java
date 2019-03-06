package xm.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class GreedDemo {
	int max = 150;
	int[] h = new int[] { 35, 30, 6, 50, 40, 10, 25 };
	float[] n = new float[] { 10, 40, 30, 50, 35, 40, 30 };
	float[] r = new float[n.length];

	// incorrect, because
	// max: 30
	// h: 28 20 10
	// n: 28 20 10
	public void test() {
		SortedMap<Float, Integer> map = new TreeMap<Float, Integer>((a, b) -> b.compareTo(a));
		for (int i = 0; i < h.length; i++) {
			map.put(n[i] / h[i], i);
		}
//		map.forEach((a, b) -> System.out.print(a + " " + b + ","));

		Iterator<Entry<Float, Integer>> it = map.entrySet().iterator();
		List<Integer> l = new ArrayList<>();
		int cnt = 0;
		while (it.hasNext()) {
			Entry<Float, Integer> entry = it.next();
			cnt += h[entry.getValue()];
			if (cnt <= 150) {
				l.add(h[entry.getValue()]);
			} else {
				break;
			}
		}
		System.out.println(l);
	}

	public static void main(String[] args) {
		new GreedDemo().test();
		
	}

}
