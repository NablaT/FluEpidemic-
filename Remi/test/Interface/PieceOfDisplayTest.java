package Interface;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Environment.JourEnum;

public class PieceOfDisplayTest {

	public PieceOfDisplay pod;
	
	@Before
	public void setUp() throws Exception {
		this.pod = new PieceOfDisplay();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDay() {
		pod.day = "testDay";
		assertEquals("testDay", pod.getDay());
	}

	@Test
	public void testSetDay() {
		pod.setDay(JourEnum.TUESDAY);
		assertEquals("Today : TUESDAY", pod.day);
	}

}
