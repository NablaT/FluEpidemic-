package Interface;

import java.awt.Color;

import Environment.GameRound;
import FandRInterface.Field;
import FandRInterface.SimulatorView;
import Living.Chicken;
import Living.Duck;
import Living.Human;
import Living.Pig;

/**
 * Classe PrintGrid. Cette classe permet l'affichage des grilles jour par jour. Elle possede une GridForADay utilisée 
 * l'affichage d'une journée et un GameRound qui permet de faire evoluer la grille jour par jour. 
 * @author pourtier
 *
 */
public class Simulator {

	private GridForADay grid; 
	private GameRound game;
	private SimulatorView view;
	private Field field;
	
	/**
	 * Constructeur par defaut de la classe PrintGrid. Ce constructeur lance la methode initialize.
	 */
	public Simulator(){
		
		this.initialize();
		field = new Field(20, 20);
		view = new SimulatorView(20, 20);
		view.setColor(Chicken.class, Color.GRAY);
		view.setColor(Duck.class, Color.GREEN);
		view.setColor(Human.class, Color.CYAN);
		view.setColor(Pig.class, Color.PINK);
		
	}
	
	public static void main(String args[]) {
		
		Simulator s = new Simulator();
		s.run();
	}
	/**
	 * Methode run. Cette methode permet de passer d'un jour à l'autre dans le menu en appuyant sur entree. 
	 * @return
	 */
	public int run() {
		
//		Scanner in = new Scanner(System.in);
//		String resultat;
//		while (true) {
//			resultat = in.nextLine();
//			if ("".equals(resultat)) {
//				this.updateMap();
//			} else {
//				return 0;
//			}
//		}
		// TODO on mettra ici une verification de la fin de la simulation
		int i = 0;
		while (i < 500) {
			try {Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {return -1;}
			this.updateMap();
	        view.showStatus(i, game.getGrid().toField());
	        i++;
		}
		return 0;
	}
	/**
	 * Methode initialize. Cette methode permet de creer un "monde" et de l'initialiser. On lance l'affichage de la 
	 * grille pour cette initialisation. 
	 */
	public void initialize(){
		this.game= new GameRound(20,20);
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
