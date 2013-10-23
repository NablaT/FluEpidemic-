package JUnit.Environment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Environment.Case;
import Environment.Grid;
import Living.Human;
import Living.LivingBeing;

public class GridTest {

	public Grid grid; 
	
	@Before
	public void setUp() throws Exception {
		this.grid=new Grid(2, 2); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGrid() {
		assertEquals(this.grid.sameGrid(new Grid(2,2)),true); 
	}

	@Test
	public void testGetGrid() {
		assertEquals(this.grid.sameGrid(new Grid(2,2)),true); 
	}

	@Test
	public void testSetGrid() {
		Case[][] tab=new Case[3][3]; 
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				tab[i][j]= new Case(i,j);
			}
		}
		this.grid.setGrid(tab,3,3);
		Grid grid2= new Grid(3,3);
		assertEquals(this.grid.sameGrid(grid2),true);
	}

	@Test
	public void testCaseEmpty() {
		Grid grid2= new Grid(2, 2);
		grid2.getGrid()[1][1].setLB(new LivingBeing());
		assertEquals(grid2.caseEmpty(1, 1), false);
		System.out.println("je suis passé une fois");
		assertEquals(grid2.caseEmpty(0,0), true);
	}
	
	@Test
	public void testSameGrid(){
		Grid grid2= new Grid(2,2); 
		grid2.getGrid()[1][1].setLB(new Human());
		Grid grid3= new Grid(2,3); 
		Grid grid4= new Grid(2,3);
		this.grid=new Grid(2,2); 

		this.grid.getGrid()[0][1].setLB(new Human());
		
		assertEquals(this.grid.sameGrid(grid3), false); 
		assertEquals(this.grid.sameGrid(grid2), true); 
		assertEquals(this.grid.sameGrid(grid4), false); 

		
	}

}
