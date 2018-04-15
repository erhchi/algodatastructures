package group4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Group4Tests {

	@Test
	public void EFTtest() {
		
		EqualTemperedFrequency etfKey1 = new EqualTemperedFrequency(1);
		EqualTemperedFrequency etfKey2 = etfKey1.next();
		assertTrue(etfKey1.isLessThanOrEqual(etfKey2));
		
	}

}
