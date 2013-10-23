package JUnit.Virus;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Virus.H1N1;

public class VirusTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		H1N1 virus=new H1N1(10,11,13);
		assertEquals(virus.getName(),"H1N1");
	}

	@Test
	public void testGetRate() {
		H1N1 virus=new H1N1(10,11,13);
		assertEquals(virus.getRate(),10);

	}


	@Test
	public void testGetProbaSickness() {
		H1N1 virus=new H1N1(10,11,13);
		assertEquals(virus.getProbaSickness(),13);
	}

	@Test
	public void testGetIncubation() {
		H1N1 virus=new H1N1(10,11,13);
		assertEquals(virus.getIncubation(),11);
	}

	@Test
	public void testSetRate() {
		H1N1 virus=new H1N1(10,11,13);
		virus.setRate(2);
		assertEquals(virus.getRate(),2);
	}

	@Test
	public void testSetIncubation() {
		H1N1 virus=new H1N1(10,11,13);
		virus.setIncubation(2);
		assertEquals(virus.getIncubation(),2);
	}

	@Test
	public void testSetProbaSickness() {
		H1N1 virus=new H1N1(10,11,13);
		virus.setProbaSickness(2);
		assertEquals(virus.getProbaSickness(),2);
	}
}
