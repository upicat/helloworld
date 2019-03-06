package xm.demo;
import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@ActiveProfiles({ "test" })
public class SortDemoTests {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Resource
	private SortDemo sortDemo;

	@Test
	public void testRmElements() {
		sortDemo.sort(getRandomArr(100,100), 0, 99);
	}

	
	
	private int[] getRandomArr(int length, int maxVal) {
		int[] ret = new int[length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = RandomUtils.nextInt(0, maxVal);
		}
		return ret;
	}
}