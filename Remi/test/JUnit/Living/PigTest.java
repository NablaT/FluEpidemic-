package JUnit.Living;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Living.Pig;
import Virus.StateEnum;

public class PigTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPig() {
		Pig pig= new Pig(); 
		assertEquals(pig.getType(),"Pig");
		assertEquals(pig.getIsInfected(),false);
		assertEquals(pig.getState(),StateEnum.HEALTHY);
	}

}
