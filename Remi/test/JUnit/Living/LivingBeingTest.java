package JUnit.Living;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Environment.Case;
import JUnit.Virus.H1N1Test;
import Living.Human;
import Living.LivingBeing;
import Virus.H1N1;
import Virus.H5N1;
import Virus.StateEnum;
import Virus.Virus;

public class LivingBeingTest {

	public LivingBeing lb;

	@Before
	public void setUp() throws Exception {
		this.lb = new LivingBeing();
		this.lb.addCase(new Case(0, 0));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLivingBeing() {
		assertEquals(lb.getType(), "LivingBeing");
		assertEquals(lb.getState(), StateEnum.HEALTHY);
		assertEquals(lb.getID(), "x0y0");
		assertEquals(lb.getIsInfected(), false);
		assertEquals(lb.getNeigh().size(), 0);
	}

	@Test
	public void testGetIsInfected() {
		LivingBeing lb= new LivingBeing();
		assertEquals(lb.getIsInfected(),false); 
		lb.catchVirus(new H5N1(10,10,10));
		assertEquals(lb.getIsInfected(), true);
		
	}

	@Test
	public void testGetState() {
	}

	@Test
	public void testGetNeigh() {
	}

	@Test
	public void testGetCase() {
	}

	@Test
	public void testGetType() {
	}

	@Test
	public void testSetIsInfected() {
	}

	@Test
	public void testSetState() {
	}

	@Test
	public void testSetNeigh() {
	}

	@Test
	public void testSetCase() {
	}

	@Test
	public void testSetType() {
	}

	@Test
	public void TestCatchVirus() {
		H5N1 v = new H5N1(10, 11, 110);
		this.lb.catchVirus(v);
		assertEquals(lb.getVirus(), v);
		assertEquals(lb.getIsInfected(), true);
		assertEquals(lb.getState(), StateEnum.SICK);
	}

	@Test
	public void testVirusLeaving() {
		this.lb.virusLeaving();
		assertEquals(lb.getIsInfected(), false);
		assertEquals(lb.getVirus(), null);
		assertEquals(lb.getState(), StateEnum.HEALTHY);

	}

	@Test
	public void testDiffuseSickness() {

		H5N1 v = new H5N1(10, 11, 100);
		Human human = new Human();
		human.catchVirus(v);
		human.setState(StateEnum.CONTAGIOUS);
		

		ArrayList<LivingBeing> neigh = new ArrayList<LivingBeing>();

		for (int i = 0; i < 4; i++) {
			neigh.add(new Human());
			
		}
		
		
		human.setNeigh(neigh);
		human.diffuseSickness();
		
		for(int i=0;i<4;i++){
			assertEquals(neigh.get(i).getVirus(), v);
			assertEquals(neigh.get(i).getState(),StateEnum.SICK);
		}
		
		Human hum = new Human();
		ArrayList<LivingBeing> neigh2 = new ArrayList<LivingBeing>();

		for (int i = 0; i < 4; i++) {
			neigh2.add(new Human());
			
		}
		hum.setNeigh(neigh2);
		hum.diffuseSickness();
		
		for(int i=0;i<4;i++){
			assertEquals(neigh2.get(i).getState(),StateEnum.HEALTHY);

		}
	}

	
	@Test
	public void testGiveYourSickness() {
		H5N1 v = new H5N1(10, 11, 110);
		this.lb.catchVirus(v);
		Human living = new Human();
		this.lb.giveYourSickness(living);
		assertEquals(living.getState(), StateEnum.SICK);
		assertEquals(living.getIsInfected(), true);
		assertEquals(living.getVirus(), v);

		Human human = new Human();
		human.setResistance(240);
		this.lb.giveYourSickness(human);
		assertEquals(human.getState(), StateEnum.HEALTHY);
		assertEquals(human.getIsInfected(), false);
		assertEquals(human.getVirus(), null);

		Human hum = new Human();
		hum.catchVirus(new H1N1(10, 12, 12));
		this.lb.giveYourSickness(hum);
		assertEquals(hum.getState(), StateEnum.SICK);
		assertEquals(hum.getIsInfected(), true);
		assertEquals(hum.getVirus().equals(this.lb.getVirus()), false);

		this.lb.giveYourSickness(hum);
	}

}
