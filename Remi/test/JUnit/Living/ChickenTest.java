package JUnit.Living;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Living.Chicken;

public class ChickenTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChicken() {
		Chicken c= new Chicken();
		int resi=(int) c.getResistance();
		assertEquals(resi,30);
		assertEquals(c.getType(),"Chicken");
	}

}
