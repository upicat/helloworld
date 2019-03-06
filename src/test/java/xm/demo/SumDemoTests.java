package xm.demo;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SumDemoTests {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private SumDemo sumDemo;

	int[] arr;
	
	@Before
	public void init() {
		arr = getRandomArr(499,9999);
//		sumDemo.printArr(arr);
	}
	
	
	@Test
	public void testGetClosest() {
		sumDemo.getClosest(arr, 4, 23456);
	}
	
	private int[] getRandomArr(int length, int maxVal) {
		int[] ret = new int[length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = RandomUtils.nextInt(0, maxVal);
		}
		return ret;
	}
}