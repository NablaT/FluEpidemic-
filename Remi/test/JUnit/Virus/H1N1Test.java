package JUnit.Virus;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Virus.H1N1;

public class H1N1Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testH1N1() {
		H1N1 virus= new H1N1(10,10,10);
		int n=(int) virus.getRate();
		assertEquals(n,10);
		assertEquals(virus.getIncubation(),10);
		assertEquals(virus.getProbaSickness(),10);
		assertEquals(virus.getRate(),10);
	}

}
