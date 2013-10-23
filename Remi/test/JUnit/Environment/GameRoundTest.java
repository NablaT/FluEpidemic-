package JUnit.Environment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Environment.GameRound;
import Environment.Grid;
import Environment.JourEnum;
import Living.Human;
import Living.Pig;
import Virus.H1N1;
import Virus.H5N1;
import Virus.StateEnum;

public class GameRoundTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGameRound() {
		GameRound game = new GameRound(3, 3);
		game.putSomeLB(2, 3, 2, 1);
		Grid grid = new Grid(3, 3);
		GameRound game2 = new GameRound(3, 3);
		game2.setGrid(grid);
		game2.putSomeLB(2, 3, 2, 1);
		assertEquals(game.getGrid().sameGrid(game2.getGrid()), true);
	}

	@Test
	public void testInitialize() {
		GameRound game = new GameRound(3, 3);
		game.initialize(2, 3, 2, 1, 2, 0);
		int line = game.getGrid().getLine();
		int col = game.getGrid().getColumn();
		assertEquals(line, 3);
		assertEquals(col, 3);
		int pigs = 0;
		int chicken = 0;
		int duck = 0;
		int human = 0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < line; j++) {
				if ((game.getGrid().getGrid()[i][j].getLB() != null)) {
					switch (game.getGrid().getGrid()[i][j].getLB().getType()) {
					case "Duck":
						duck++;
						break;
					case "Chicken":
						chicken++;
						break;
					case "Pig":
						pigs++;
						break;
					case "Human":
						human++;
						break;
					default:
						break;
					}

				}

			}
		}
		assertEquals(duck, 3);
		assertEquals(human, 1);
		assertEquals(chicken, 2);
		assertEquals(pigs, 2);
	}

	@Test
	public void testInitializeDisease() {
		GameRound game = new GameRound(3, 3);
		game.initialize(3, 2, 2, 0, 2, 1);
		int nbOfH5N1 = 0;
		int nbOfH1N1 = 0;
		int nbOfHealthy = 0;
		for (int i = 0; i < game.getGrid().getColumn(); i++) {
			for (int j = 0; j < game.getGrid().getLine(); j++) {
				if (game.getGrid().getGrid()[i][j].getLB() != null
						&& game.getGrid().getGrid()[i][j].getLB().getState()
								.equals(StateEnum.HEALTHY)) {
					nbOfHealthy++;
				} else if (game.getGrid().getGrid()[i][j].getLB() != null
						&& game.getGrid().getGrid()[i][j].getLB().getState()
								.equals(StateEnum.SICK)) {
					if (game.getGrid().getGrid()[i][j].getLB().getVirus()
							.equals(new H5N1(10, 10, 10))) {
						nbOfH5N1++;
					} else if (game.getGrid().getGrid()[i][j].getLB()
							.getVirus().equals(new H1N1(10, 10, 10))) {
						nbOfH1N1++;
					}
				}

			}
		}
		// game.showMeGrid();
		assertEquals(nbOfHealthy, 4);
	}

	@Test
	public void testInitializeNeigh() {
		GameRound game = new GameRound(3, 3);
		game.initialize(3, 2, 1, 0, 1, 1);
		Human human = new Human();
		Pig pig = new Pig();
		game.getGrid().getGrid()[0][0].setLB(new Human());
		game.getGrid().getGrid()[0][1].setLB(human);
		human.addCase(game.getGrid().getGrid()[0][1]);
		game.getGrid().getGrid()[1][0].setLB(pig);
		pig.addCase(game.getGrid().getGrid()[1][0]);
		//game.showMeGrid();
		game.initializeNeigh();
		assertEquals(game.getGrid().getGrid()[0][0].getLB().getNeigh().get(1),
				human);
		assertEquals(game.getGrid().getGrid()[0][0].getLB().getNeigh().get(0),
				pig);

	}

	@Test
	public void testAddNeigh() {
		GameRound game = new GameRound(3, 3);
		game.putSomeLB(9, 0, 0, 0);
		game.getGrid().getGrid()[0][0].setLB(new Human());
		game.addNeigh(game.getGrid().getGrid()[0][0]);

		/*
		 * if (game.getGrid().getGrid()[0][0].getLB().getNeigh().size() != 0) {
		 * for (int i = 0; i < game.getGrid().getGrid()[0][0].getLB()
		 * .getNeigh().size(); i++) {
		 * System.out.println("\n"+game.getGrid().getGrid()[0][0].getLB()
		 * .getNeigh().get(i).getType()); } }
		 */

		Human h1 = new Human();
		Human h2 = new Human();
		h1.addCase(game.getGrid().getGrid()[0][1]);
		h2.addCase(game.getGrid().getGrid()[1][0]);
		game.getGrid().getGrid()[0][1].setLB(h1);
		game.getGrid().getGrid()[1][0].setLB(h2);

		// game.showMeGrid();
		assertEquals(game.getGrid().getGrid()[0][0].getLB().getNeigh().size(),
				2);
		assertEquals(game.getGrid().getGrid()[0][1].getLB(), h1);
		assertEquals(game.getGrid().getGrid()[1][0].getLB(), h2);

	}

	@Test
	public void testPutSomeLB() {
		GameRound game = new GameRound(1, 2);
		game.putSomeLB(1, 1, 0, 0);
		int cpt = 0;
		if (game.getGrid().getGrid()[0][0].getLB().getType().equals("Pig")
				|| game.getGrid().getGrid()[0][0].getLB().getType()
						.equals("Duck")) {
			cpt++;
		}
		if (game.getGrid().getGrid()[0][1].getLB().getType().equals("Pig")
				|| game.getGrid().getGrid()[0][1].getLB().getType()
						.equals("Duck")) {
			cpt++;
		}
		assertEquals(cpt, 2);
	}
	
	@Test
	public void testRound(){
		//System.out.println("//////////////////DEBUT TEST ROUND////////////////////////////");
		GameRound game = new GameRound(3, 3);
		game.initialize(3, 2, 2, 2, 1, 1);
		//game.showMeGrid();
		game.gameRound();
		
		
	}
	
	@Test
	public void testNextDay(){
		GameRound game = new GameRound(3, 3);
		game.initialize(3, 2, 2, 2, 1, 1);
		game.showMeGrid();
		game.nextDay();
		assertEquals(game.getDay(), JourEnum.TUESDAY); 
	}

}
