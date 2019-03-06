package xm.demo;
import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;

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
public class ArrayDemoTests {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Resource(name = "arrayDemo") 
	private ArrayDemo arrayDemo;

	@Test
	public void testRmElements() {
		arrayDemo.rmElements(new int[] { 1, 2, 2, 3, 4, 4, 2, 5 }, 2);
		String output = outputCapture.toString();
		assertThat(output).contains("1, 3, 4, 4, 5");
	}
	
	@Test
	public void testRmElements2() {
		arrayDemo.rmElements2(new int[] { 1, 2, 2, 3, 4, 4, 2, 5 }, 2);
		String output = outputCapture.toString();
		assertThat(output).contains("1, 3, 4, 4, 5");
	}
	
	@Test
	public void testRmElements3() {
		arrayDemo.rmElements3(new int[] { 1, 2, 2, 3, 4, 4, 5 });
		String output = outputCapture.toString();
		assertThat(output).contains("1, 2, 3, 4, 5");
	}
	
	@Test
	public void testRmElements4() {
		arrayDemo.rmElements4(new int[] { 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 5 }, 2);
		String output = outputCapture.toString();
		assertThat(output).contains("1, 1, 2, 2, 3, 3, 4, 5, 5");
	}

}