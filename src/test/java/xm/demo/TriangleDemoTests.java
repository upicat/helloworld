package xm.demo;
import static org.assertj.core.api.Assertions.assertThat;

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
public class TriangleDemoTests {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private TriangleDemo triangleDemo;

	@Test
	public void testPrints() {
		triangleDemo.printArr(triangleDemo.getTriangle(100));
		String output = outputCapture.toString();
		assertThat(output).contains("1, 1");
	}
	
	@Test
	public void testPrint() {
		triangleDemo.getTriangleDirect(100);
		String output = outputCapture.toString();
		assertThat(output).contains("1, 1");
	}
}