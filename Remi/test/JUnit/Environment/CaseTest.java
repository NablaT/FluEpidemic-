package JUnit.Environment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Environment.Case;
import Living.Human;
import Living.LivingBeing;

public class CaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCaseIntInt() {
		Case c= new Case(1,2); 
		assertEquals(1,c.getPosX());
		assertEquals(2,c.getPosY());
		c.setLB(new LivingBeing());
		LivingBeing test= new LivingBeing();
		assertEquals(c.getLB().getID(),test.getID());
	}

	@Test
	public void testCaseIntIntLivingBeing() {
		Case c= new Case(1,2,new LivingBeing()); 
		assertEquals(1,c.getPosX());
		assertEquals(2,c.getPosY());
		LivingBeing test= new LivingBeing();
		assertEquals(c.getLB().getID(),test.getID());
	}

	@Test
	public void testGetPosX() {
		Case c= new Case(1,2,new LivingBeing()); 
		assertEquals(1,c.getPosX());
	}

	@Test
	public void testGetPosY() {
		Case c= new Case(1,2,new LivingBeing()); 
		assertEquals(2,c.getPosY());
	}

	@Test
	public void testGetLB() {
		LivingBeing lb=new LivingBeing(); 
		Case c= new Case(1,2,lb); 
		lb.addCase(c);
		assertEquals(c.getLB(),lb);
	}

	@Test
	public void testSetPosX() {
		Case c= new Case(1,2,new LivingBeing()); 
		c.setPosX(13);
		assertEquals(13,c.getPosX());
	}

	@Test
	public void testSetPosY() {
		Case c= new Case(1,2,new LivingBeing()); 
		c.setPosY(13);
		assertEquals(13,c.getPosY());
	}

	@Test
	public void testSetLB() {
		LivingBeing lb=new LivingBeing(); 
		Human h=new Human();
		Case c= new Case(1,2,lb); 
		c.setLB(h);
		h.addCase(c);
		assertEquals(c.getLB(),h);
	}

}
