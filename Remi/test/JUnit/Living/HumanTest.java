package JUnit.Living;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Living.Chicken;
import Living.Human;

public class HumanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHuman() {
			Human h= new Human();
			int resi=(int) h.getResistance();
			assertEquals(resi,50);
			assertEquals(h.getType(),"Human");
		
	}

}
