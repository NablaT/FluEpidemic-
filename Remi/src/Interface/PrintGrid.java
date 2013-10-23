package Interface;

import java.util.Scanner;

import Environment.GameRound;

/**
 * Classe PrintGrid. Cette classe permet l'affichage des grilles jour par jour. Elle possede une GridForADay utilisée 
 * l'affichage d'une journée et un GameRound qui permet de faire evoluer la grille jour par jour. 
 * @author pourtier
 *
 */
public class PrintGrid {

	public GridForADay grid; 
	public GameRound game;
	
	/**
	 * Constructeur par defaut de la classe PrintGrid. Ce constructeur lance la methode initialize.
	 */
	public PrintGrid(){
		
		this.initialize();
		
	}
	/*
	public void main(String args[]) {
		
		this.run();
	}*/
	/**
	 * Methode run. Cette methode permet de passer d'un jour à l'autre dans le menu en appuyant sur entree. 
	 * @return
	 */
	public int run() {
		Scanner in = new Scanner(System.in);
		String resultat;
		while (true) {
			resultat = in.nextLine();
			if ("".equals(resultat)) {
				this.updateMap();
			} else {
				return 0;
			}
		}
	}
	/**
	 * Methode initialize. Cette methode permet de creer un "monde" et de l'initialiser. On lance l'affichage de la 
	 * grille pour cette initialisation. 
	 */
	public void initialize(){
		this.game= new GameRound(5,5);
		game.initialize(8, 2, 4, 7, 4, 3);
		this.grid=new GridForADay(this.game); 
		System.out.println(this.grid.getDisplay());
	}
	
	/**
	 * Methode updateMap. Cette methode permet de lancer une nouvelle journee et d'afficher l'etat de la grille apres 
	 * ce changement de jour. 
	 */
	public void updateMap(){		
		this.game.nextDay();
		this.grid=new GridForADay(this.game);
		System.out.println(this.grid.getDisplay());
	}
}
