import static org.junit.Assert.*;

import org.junit.Test;

public class ConCatTest {

	@Test
	public void Concattest() {
		MyJUnitClass junit = new MyJUnitClass();
		String result = junit.ConCat("this is ", "a test.");
		assertEquals("this is a test.", result);
			
	}

}
