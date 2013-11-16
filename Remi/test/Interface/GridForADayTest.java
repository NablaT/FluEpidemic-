package Interface;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Environment.Case;
import Environment.GameRound;
import Environment.Grid;
import Living.Human;
import Living.Pig;

public class GridForADayTest {

	public GridForADay gfad;
	public GameRound gr;
	
	@Before
	public void setUp() throws Exception {
		
		// Creation des cases
		Case cases[][] = new Case[5][5];
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				cases[i][j] = new Case(i, j);
			}
		}
		
		// Remplissage de cases
		cases[1][2].setLB(new Human());
		cases[3][3].setLB(new Pig());
		
		// Creation de la grille
		Grid g = new Grid(10, 10);
		g.setGrid(cases, 5, 5);
		
		// Creation du gameRound
		this.gr = new GameRound(5, 5);
		this.gr.setGrid(g);
		
		// Creation de la grille
		this.gfad = new GridForADay(gr);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGridForADay() {
		assertEquals(gr, gfad.game);
	}

	@Test
	public void testBuildTheGrid() {
		
		// Recuperation de l'affichage
		String display = gfad.getDisplay();
		
		// Declaration de la ligne courante
		char[] ligneCourante = new char[80];

		// Taille d'une ligne
		int tailleLigne = 46; 
		
		// Declaration de la ligne de date
		String date = "Today : MONDAY";
		char[] dateChar = new char[80];
		date.getChars(0, 14, dateChar, 0);
		
		// Declaration d'une ligne de bord
		String bord = "+--------+--------+--------+--------+--------+";
		char[] bordChar = new char[80];
		bord.getChars(0, tailleLigne, bordChar, 0);
		
		// Declaration d'une ligne vide
		String vide = "|        |        |        |        |        |";
		char[] videChar = new char[80];
		vide.getChars(0, tailleLigne, videChar, 0);

		// Declaration d'une avec humains
		String humains = "|        |   H H  |        |        |        |";
		char[] humainsChar = new char[80];
		humains.getChars(0, tailleLigne, humainsChar, 0);
		
		// Declaration d'une avec cochons
		String cochons = "|        |        |        |   P H  |        |";
		char[] cochonsChar = new char[80];
		cochons.getChars(0, tailleLigne, cochonsChar, 0);
		
		// Test des lignes
		display.getChars(0, 14, ligneCourante, 0);
		assertEquals(String.valueOf(dateChar), String.valueOf(ligneCourante));

		int index = 15;

		//assertEquals(gfad.getDisplay(), "");
		
		for(int i = 0; i < 5; i++){
			
			display.getChars(index, index + tailleLigne, ligneCourante, 0);
			assertEquals(String.valueOf(bordChar), String.valueOf(ligneCourante));
			index += tailleLigne + 1;
			
			
			display.getChars(index, index + tailleLigne, ligneCourante, 0);
			if(i == 2){assertEquals(String.valueOf(humainsChar), String.valueOf(ligneCourante));}
			else if(i == 3){assertEquals(String.valueOf(cochonsChar), String.valueOf(ligneCourante));}
			else{assertEquals(String.valueOf(videChar), String.valueOf(ligneCourante));}
			index += tailleLigne + 1;
			
			display.getChars(index, index + tailleLigne, ligneCourante, 0);
			assertEquals(String.valueOf(bordChar), String.valueOf(ligneCourante));
			index += tailleLigne + 1;
		}
	
	}
}