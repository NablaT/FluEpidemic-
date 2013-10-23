package JUnit.Living;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Living.Duck;
import Living.Human;

public class DuckTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDuck() {
		Duck d= new Duck();
		int resi=(int) d.getResistance();
		assertEquals(resi,10);
		assertEquals(d.getType(),"Duck");
	}

}
