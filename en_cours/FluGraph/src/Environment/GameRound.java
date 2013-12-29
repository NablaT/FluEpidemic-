package Environment;

import java.util.ArrayList;
import java.util.Random;

import Living.Chicken;
import Living.Duck;
import Living.Human;
import Living.LivingBeing;
import Living.Pig;
import Virus.H1N1;
import Virus.H5N1;
import Virus.StateEnum;
import Virus.Virus;

/**
 * Classe GameRound. Cette classe permet de creer le plateau sur lequel les
 * LivingBeing vont etre.
 * 
 * @author pourtier
 * 
 */
public class GameRound {

	private Grid grid;
	private JourEnum jour;
	

	/**
	 * Constructeur de la classe GameRound. Ce constructeur va creer le plateau
	 * en fonction du nombre de lignes et de colonnes specifiés en parametre.
	 * 
	 * @param column
	 * @param line
	 */
	public GameRound(int column, int line) {
		this.grid = new Grid(column, line);
		this.jour = JourEnum.MONDAY;
	}

	/**
	 * Methode getGrid. Cette methode retourne la grille sur laquelle les
	 * GameRound vont se derouler.
	 * 
	 * @return Grid.
	 */

	public Grid getGrid() {
		return this.grid;
	}

	/**
	 * Methode getDay. Cette methode retourne le jour courant. Chaque tour de
	 * jeu possede un jour.
	 * 
	 * @return
	 */
	public JourEnum getDay() {
		return this.jour;
	}

	/**
	 * Methode setGrid. Cette methode permet de remplacer la grille existante
	 * par celle specifiee en parametre.
	 * 
	 * @param Grid
	 *            g
	 */

	public void setGrid(Grid g) {
		this.grid = g;
	}

	/**
	 * Methode setDay. Cette methode remplace le jour du GameRound.
	 * 
	 * @param day
	 */
	public void setDay(JourEnum day) {
		this.jour = day;
	}

	/**
	 * Methode initialize. Cette methode va placer les LivingBeing sur le
	 * plateau.
	 */
	public void initialize(int nbOfPigs, int nbOfDuck, int nbOfChicken,
			int nbOfHuman, int nbOfH5N1, int nbOfH1N1) {
		if ((nbOfPigs + nbOfDuck + nbOfChicken + nbOfHuman) > (this.grid
				.getColumn() * this.grid.getLine())) {
			System.out
					.println("Le nombre d'etre vivant est trop important. Ils ne peuvent pas tous rentrer sur ce plateau");
		} else {
			this.putSomeLB(nbOfPigs, nbOfDuck, nbOfChicken, nbOfHuman);
			this.initializeNeigh();
			this.initializeDisease(nbOfH5N1, nbOfH1N1);
		}
	}

	/**
	 * Methode initializeDisease. Cette methode va placer un nombre de malade
	 * (nbOfSick) sur le plateau. Initialement tous les elements du tableaux
	 * sont Healthy, certains d'entre eux vont donc etre modifies.
	 */

	public void initializeDisease(int nbOfH5N1, int nbOfH1N1) {
		int rdmCol = 0;
		int rdmLine = 0;
		Random r = new Random();
		int nbOfSick = nbOfH5N1 + nbOfH1N1;
		while (nbOfSick > 0) {
			rdmCol = r.nextInt(this.grid.getColumn());
			rdmLine = r.nextInt(this.grid.getLine());
			if (this.grid.getGrid()[rdmCol][rdmLine].getLB() != null
					&& this.grid.getGrid()[rdmCol][rdmLine].getLB().getState()
							.equals(StateEnum.HEALTHY)) {
				if (nbOfH5N1 > 0) {
					if (!(this.grid.getGrid()[rdmCol][rdmLine].getLB()
							.getType().equals("Human"))) {
						this.grid.getGrid()[rdmCol][rdmLine].getLB()
								.catchVirus(new H5N1(10, 10, 70));
						nbOfH5N1--;
						nbOfSick--;
					}
				} else if (nbOfH1N1 > 0) {
					if (!(this.grid.getGrid()[rdmCol][rdmLine].getLB()
							.getType().equals("Human"))) {

						this.grid.getGrid()[rdmCol][rdmLine].getLB()
								.catchVirus(new H1N1(10, 10, 70));
						nbOfH1N1--;
						nbOfSick--;
					}
				}

			}
		}

	}

	/**
	 * Methode initializeNeigh(). Pour chaque element de la grille, cette
	 * methode enregistre les cases voisines contenant un LivingBeing.
	 * L'enregistrement se fait dans la classe LivingBeing, chaque LB possede
	 * l'arrayList de ses voisins.
	 */
	public void initializeNeigh() {
		for (int i = 0; i < this.grid.getColumn(); i++) {
			for (int j = 0; j < this.grid.getLine(); j++) {
				if (this.grid.getGrid()[i][j] != null) {
					this.addNeigh(this.grid.getGrid()[i][j]);
				}
			}
		}
	}

	/**
	 * Methode addNeigh. Pour une case donnée, cette methode permet
	 * d'enregistrer la liste de ses cases voisines (ce sont les LivingBeing qui
	 * sont enregistrés).
	 * 
	 * @param case1
	 */
	public void addNeigh(Case case1) {
		if (this.grid.getGrid()[case1.getPosX()][case1.getPosY()].getLB() != null
				&& case1.getPosX() + 1 < this.grid.getColumn()
				&& this.grid.getGrid()[case1.getPosX() + 1][case1.getPosY()] != null
				&& this.grid.getGrid()[case1.getPosX() + 1][case1.getPosY()]
						.getLB() != null) {

			case1.getLB()
					.getNeigh()
					.add(this.grid.getGrid()[case1.getPosX() + 1][case1
							.getPosY()].getLB());

		}
		if (this.grid.getGrid()[case1.getPosX()][case1.getPosY()].getLB() != null
				&& case1.getPosY() - 1 >= 0
				&& this.grid.getGrid()[case1.getPosX()][case1.getPosY() - 1] != null
				&& this.grid.getGrid()[case1.getPosX()][case1.getPosY() - 1]
						.getLB() != null) {

			case1.getLB()
					.getNeigh()
					.add(this.grid.getGrid()[case1.getPosX()][case1.getPosY() - 1]
							.getLB());

		}

		if (this.grid.getGrid()[case1.getPosX()][case1.getPosY()].getLB() != null
				&& case1.getPosX() - 1 >= 0
				&& this.grid.getGrid()[case1.getPosX() - 1][case1.getPosY()] != null
				&& this.grid.getGrid()[case1.getPosX() - 1][case1.getPosY()]
						.getLB() != null) {

			case1.getLB()
					.getNeigh()
					.add(this.grid.getGrid()[case1.getPosX() - 1][case1
							.getPosY()].getLB());

		}
		if (this.grid.getGrid()[case1.getPosX()][case1.getPosY()].getLB() != null
				&& case1.getPosY() + 1 < this.grid.getLine()
				&& this.grid.getGrid()[case1.getPosX()][case1.getPosY() + 1] != null
				&& this.grid.getGrid()[case1.getPosX()][case1.getPosY() + 1]
						.getLB() != null) {

			case1.getLB()
					.getNeigh()
					.add(this.grid.getGrid()[case1.getPosX()][case1.getPosY() + 1]
							.getLB());

		}
	}

	/**
	 * Methode putSomeLB. Cette methode permet de placer le nombre d'etre
	 * vivants en parametre sur le plateau de jeu.
	 * 
	 * @param nbOfLB
	 * @return
	 */

	public void putSomeLB(int nbOfPigs, int nbOfDuck, int nbOfChicken,
			int nbOfHuman) {
		this.putSomePigs(nbOfPigs);
		this.putSomeDuck(nbOfDuck);
		this.putSomeChicken(nbOfChicken);
		this.putSomeHuman(nbOfHuman);
	}

	/**
	 * Methode putSomeHuman. Cette methode permet de placer nbOfHuman sur le
	 * plateau.
	 * 
	 * @param nbOfHuman
	 */

	private void putSomeHuman(int nbOfHuman) {
		int rdmLine = 0;
		int rdmCol = 0;
		Random r = new Random();
		while (nbOfHuman != 0) {
			rdmLine = r.nextInt(this.grid.getLine());
			rdmCol = r.nextInt(this.grid.getColumn());
			if (this.grid.caseEmpty(rdmCol, rdmLine)) {
				// this.grid.getGrid()[rdmCol][rdmLine].setLB(new Human());
				this.grid.getGrid()[rdmCol][rdmLine] = new Case(rdmCol,
						rdmLine, new Human());
				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				nbOfHuman--;
			}
		}
	}

	/**
	 * Methode showMeGrid.Cette methode permet d'afficher le plateau. Cette
	 * methode est utilisé dans les JUnit
	 */

	public void showMeGrid() {
		for (int i = 0; i < this.grid.getColumn(); i++) {
			for (int j = 0; j < this.grid.getLine(); j++) {
				if (this.grid.getGrid()[i][j].getLB() == null) {
					System.out.println("EMPTY");
				} else {
					System.out.println("Case: [" + i + "," + j + "]: "
							+ this.grid.getGrid()[i][j].getLB().getType() + " "
							+ this.grid.getGrid()[i][j].getLB().getState());

				}
			}
		}
	}

	/**
	 * Methode putSomeChicken. Cette methode permet de placer nbOfChicken sur le
	 * plateau.
	 * 
	 * @param nbOfChicken
	 */

	private void putSomeChicken(int nbOfChicken) {
		int rdmLine = 0;
		int rdmCol = 0;
		Random r = new Random();
		while (nbOfChicken != 0) {
			rdmLine = r.nextInt(this.grid.getLine());
			rdmCol = r.nextInt(this.grid.getColumn());
			// On test si la case est bien vide.
			if (this.grid.caseEmpty(rdmCol, rdmLine)) {
				// this.grid.getGrid()[rdmCol][rdmLine].setLB(new Chicken());
				this.grid.getGrid()[rdmCol][rdmLine] = new Case(rdmCol,
						rdmLine, new Chicken());

				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				nbOfChicken--;
			}
		}
	}

	/**
	 * Methode putSomeDuck. Cette methode permet de placer nbOfDuck sur le
	 * plateau.
	 * 
	 * @param nbOfDuck
	 */

	private void putSomeDuck(int nbOfDuck) {
		int rdmLine = 0;
		int rdmCol = 0;
		Random r = new Random();
		while (nbOfDuck != 0) {
			rdmLine = r.nextInt(this.grid.getLine());
			rdmCol = r.nextInt(this.grid.getColumn());
			// On test si la case est bien vide.
			if (this.grid.caseEmpty(rdmCol, rdmLine)) {
				// this.grid.getGrid()[rdmCol][rdmLine].setLB(new Duck());

				this.grid.getGrid()[rdmCol][rdmLine] = new Case(rdmCol,
						rdmLine, new Duck());
				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				nbOfDuck--;
			}
		}

	}

	/**
	 * Methode putSomePigs. Cette methode permet de placer nbOfPigs sur le
	 * plateau.
	 * 
	 * @param nbOfPigs
	 */

	private void putSomePigs(int nbOfPigs) {
		int rdmLine = 0;
		int rdmCol = 0;
		Random r = new Random();
		while (nbOfPigs != 0) {
			rdmLine = r.nextInt(this.grid.getLine());
			rdmCol = r.nextInt(this.grid.getColumn());
			// On test si la case est bien vide.
			if (this.grid.caseEmpty(rdmCol, rdmLine)) {
				this.grid.getGrid()[rdmCol][rdmLine] = new Case(rdmCol,
						rdmLine, new Pig());
				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				this.grid.getGrid()[rdmCol][rdmLine].getLB().addCase(
						this.grid.getGrid()[rdmCol][rdmLine]);
				// this.grid.getGrid()[rdmCol][rdmLine].setLB(new Pig());
				nbOfPigs--;
			}
		}
	}

	/**
	 * Methode gameRound. Cette methode va permettre le déroulement des jours.
	 */

	public void gameRound() {
		for (int i = 0; i < 20; i++) {
			this.round(this.jour);
			this.nextDay();
			// this.showMeGrid();
			// System.out.println("/////////////////////////////////");

		}

	}

	/**
	 * Methode round. Cette methode decrit le deroulement d'un jour, c'est a
	 * dire la diffusion des virus dans la population ainsi que les changements
	 * d'etats.
	 * 
	 * @param jour
	 */

	public void round(JourEnum jour) {

		for (int i = 0; i < this.grid.getColumn(); i++) {
			for (int j = 0; j < this.grid.getLine(); j++) {

				/*
				 * Si la personne est contagieuse: Soit elle sort de cet état là
				 * (son etat devient recovering). Soit elle essaye de donner sa
				 * maladie à ses voisins.
				 */

				LivingBeing lb = this.grid.getGrid()[i][j].getLB();
				if (this.grid.getGrid()[i][j].getLB() != null) {
					if (this.grid.getGrid()[i][j].getLB().getState()
							.equals(StateEnum.CONTAGIOUS)) {
						if (lb.getTimeState() > 3) {
							lb.setState(StateEnum.RECOVERING);
							lb.setTimeState(0);
						} else {
							lb.diffuseSickness();
							lb.setTimeState(lb.getTimeState() + 1);
						}

					}
					/*
					 * Si la personne est sick: Elle ne fait rien et elle
					 * devient contagious quelques jours après avoir ete
					 * infecté.
					 */

					else if (lb.getState().equals(StateEnum.SICK)) {
						if (lb.getTimeState() > 2) {
							lb.setState(StateEnum.CONTAGIOUS);
							lb.setTimeState(0);
						} else {
							lb.setTimeState(lb.getTimeState() + 1);
						}

					}
					/*
					 * Si la personne est en recovering. Elle attend quelques
					 * jours pour redevenir saine ou elle meurt.
					 */
					else if (this.grid.getGrid()[i][j].getLB().getState()
							.equals(StateEnum.RECOVERING)) {
						/*
						 * Si c'est un human, il peut mourrir au bout de trois
						 * jours ou redevenir sain.
						 */
						if (lb.getType().equals("Human")) {
							if (lb.getTimeState() > 3) {
								/*
								 * Soit il meurt
								 */
								if (lb.isDead()) {
									lb.dead();
								}
								/*
								 * Soit il survit
								 */
								else {
									lb.setState(StateEnum.HEALTHY);
								}
							} else {
								lb.setTimeState(lb.getTimeState() + 1);
							}

						}
						/*
						 * Apres quelques jours, l'animal repasse dans l'etat
						 * HEALTHY
						 */
						else if (lb.getTimeState() > 3) {
							lb.setState(StateEnum.HEALTHY);
							lb.setTimeState(0);
						} else {
							lb.setTimeState(lb.getTimeState() + 1);
						}
					}
					/*
					 * Si la personne est Healthy ou Dead: elle ne fait rien.
					 */
					else {
						this.grid.getGrid()[i][j].getLB().setTimeState(
								this.grid.getGrid()[i][j].getLB()
										.getTimeState() + 1);
					}
				}
			}
		}
	}

	/**
	 * Methode nextDay. Cette methode permet de passer au jour d'après. Elle
	 * relance un nouveau round avec un le nouveau jour.
	 */

	public void nextDay() {
		this.changeDay();
		this.round(this.jour);
	}

	/**
	 * Methode changeDay. Cette methode change l'enum correspondant au jour.
	 */

	private void changeDay() {
		if (this.jour.equals(JourEnum.MONDAY)) {
			this.jour = JourEnum.TUESDAY;
			// this.round(this.jour);
		} else if (this.jour.equals(JourEnum.TUESDAY)) {
			this.jour = JourEnum.WEDNESDAY;
			// this.round(this.jour);
		} else if (this.jour.equals(JourEnum.WEDNESDAY)) {
			this.jour = JourEnum.THURSDAY;
			// this.round(this.jour);
		} else if (this.jour.equals(JourEnum.THURSDAY)) {
			this.jour = JourEnum.FRIDAY;
			// this.round(this.jour);
		} else if (this.jour.equals(JourEnum.FRIDAY)) {
			this.jour = JourEnum.SATURDAY;
			// this.round(this.jour);
		} else if (this.jour.equals(JourEnum.SATURDAY)) {
			this.jour = JourEnum.SUNDAY;
		} else if (this.jour.equals(JourEnum.SUNDAY)) {
			this.jour = JourEnum.MONDAY;
			// this.round(this.jour);
		}
	}
}
