package Interface;

import java.awt.Color;

import Environment.GameRound;
import FandRInterface.Field;
import FandRInterface.SimulatorView;
import Living.Chicken;
import Living.Duck;
import Living.Human;
import Living.Pig;
import Virus.StateEnum;

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
	public Simulator(int lignes, int colonnes){
		
		this.initialize(lignes, colonnes);
		field = new Field(lignes, colonnes);
		view = new SimulatorView(lignes, colonnes);
		view.setColor(Chicken.class + StateEnum.HEALTHY.toString(), new Color(255,255,0));
		view.setColor(Chicken.class + StateEnum.SICK.toString(), new Color(183,183,2));
		view.setColor(Chicken.class + StateEnum.CONTAGIOUS.toString(), new Color(91,91,2));
		view.setColor(Chicken.class + StateEnum.RECOVERING.toString(),  new Color(140,140,64));

		view.setColor(Duck.class + StateEnum.HEALTHY.toString(),  new Color(17,255,0));
		view.setColor(Duck.class + StateEnum.SICK.toString(), new Color(11,172,0));
		view.setColor(Duck.class + StateEnum.CONTAGIOUS.toString(),  new Color(5,74,0));
		view.setColor(Duck.class + StateEnum.RECOVERING.toString(),  new Color(102,171,97));

		view.setColor(Human.class + StateEnum.HEALTHY.toString(), new Color(0,255,230));
		view.setColor(Human.class + StateEnum.SICK.toString(),  new Color(0,166,150));
		view.setColor(Human.class + StateEnum.CONTAGIOUS.toString(),  new Color(2,77,69));
		view.setColor(Human.class + StateEnum.RECOVERING.toString(),  new Color(52,135,127));
		

		view.setColor(Pig.class + StateEnum.HEALTHY.toString(),  new Color(255,0,230));
		view.setColor(Pig.class + StateEnum.SICK.toString(),  new Color(178,2,160));
		view.setColor(Pig.class + StateEnum.CONTAGIOUS.toString(),  new Color(82,4,75));
		view.setColor(Pig.class + StateEnum.RECOVERING.toString(),  new Color(125,61,119));
		
		view.setColor(Chicken.class + StateEnum.DEAD.toString(), Color.BLACK);
		view.setColor(Duck.class + StateEnum.DEAD.toString(), Color.BLACK);
		view.setColor(Human.class + StateEnum.DEAD.toString(), Color.BLACK);
		view.setColor(Pig.class + StateEnum.DEAD.toString(), Color.BLACK);
		
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
	public void initialize(int lignes, int colonnes){
		this.game= new GameRound(lignes,colonnes);
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
	

	public static void main(String args[]) {
		
		Simulator s = new Simulator(50,51);
		s.run();
	}
}
