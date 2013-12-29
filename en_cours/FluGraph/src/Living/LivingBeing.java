package Living;

import java.util.ArrayList;
import java.util.Random;

import Virus.StateEnum;
import Virus.Virus;

import Environment.Case;

/**
 * Classe LivingBeing. Cette classe permet de creer des etres vivants. Chaque
 * etre vivant est ici caracterisé par: un boolean utilisé afin de savoir si
 * l'etre est infecté ou non, le type de virus que le LivingBeing possede, le
 * type de LivingBeing, un etat de type StateEnum, une liste de voisin, sa
 * resistance aux virus, la case sur laquelle il se trouve ainsi que le temps
 * qu'il a passé dans cet état en jour. Cette classe possede plusieurs sous
 * classe: la classe Human et Animal.
 * 
 * @author pourtier
 */

public class LivingBeing {

	protected String type;
	protected boolean isInfected;
	protected Virus virus;
	protected StateEnum state;
	protected ArrayList<LivingBeing> neigh;
	protected Case caseGrid;
	protected String id;
	protected double resistance;
	protected int timeState; // temps en jour

	/**
	 * Constructeur par défaut de la classe LivingBeing. La case n'est pas
	 * initialisée ici.
	 */

	public LivingBeing() {
		this.isInfected = false;
		this.state = StateEnum.HEALTHY;
		this.neigh = new ArrayList<LivingBeing>();
		this.type = "LivingBeing";
		this.virus = null;
		this.resistance = 0;
		this.timeState = 0;
	}

	/**
	 * Methode addCase. Cette methode instancie la Case et permet de creer
	 * l'identifiant unique du LivingBeing.
	 * 
	 * @param Case
	 *            c
	 */

	public void addCase(Case c) {
		this.caseGrid = c;
		// this.caseGrid.setLB(this);
		this.id = "x" + this.caseGrid.getPosX() + "y" + this.caseGrid.getPosY();
	}

	/**
	 * Methode getTimeState. Cette methode retourne la durée de l'etat dans
	 * lequel le LivingBeing est. Cette duree comptee en jour.
	 * 
	 * @return
	 */

	public int getTimeState() {
		return this.timeState;
	}

	/**
	 * Methode getVirus. Cette methode retourne le virus que l'individu possede.
	 * 
	 * @return Virus virus.
	 */

	public Virus getVirus() {
		return this.virus;
	}

	/**
	 * Methode getIsInfected. Cette methode retourne un boolean correspondant a
	 * l'infection ou non de l'individu.
	 * 
	 * @return boolean
	 */

	public boolean getIsInfected() {
		if (this.virus != null
				&& (this.state.equals(StateEnum.SICK) || this.state
						.equals(StateEnum.CONTAGIOUS))) {
			this.isInfected = true;
		}
		return this.isInfected;
	}

	/**
	 * Methode getState. Cette methode retourne l'etat de l'individu.
	 * 
	 * @return StateEnum.
	 */
	public StateEnum getState() {
		return this.state;
	}

	/**
	 * Methode getNeigh. Cette methode retourne la liste des voisins de
	 * l'individu.
	 * 
	 * @return ArrayList<Neighbourhood>
	 */

	public ArrayList<LivingBeing> getNeigh() {
		return this.neigh;
	}

	/**
	 * Methode getResistance. Cette methode retourne le double correspondant au
	 * pourcentage de resistance d'un LivingBeing.
	 * 
	 * @return double
	 */
	public double getResistance() {
		return this.resistance;
	}

	/**
	 * Methode getCase. Cette methode retourne la case sur laquelle l'individu
	 * se trouve.
	 * 
	 * @return Case.
	 */

	public Case getCase() {
		return this.caseGrid;
	}

	/**
	 * Methode getType. Cette methode retourne le type de LivingBeing.
	 * 
	 * @return String.
	 */

	public String getType() {
		return this.type;
	}

	/**
	 * Methode getID. Cette methode retourne l'identifiant unique du
	 * LivingBeing.
	 * 
	 * @return int
	 */
	public String getID() {
		return this.id;
	}

	/**
	 * Methode setTimeState. Cette methode remplace la valeur de la durée de
	 * l'état du LivingBeing.
	 * 
	 * @param time
	 */
	public void setTimeState(int time) {
		this.timeState = time;
	}

	/**
	 * Methode setIsInfected. Cette methode remplace le boolean correspondant à
	 * l'infection de l'individu.
	 * 
	 * @param b
	 */

	public void setIsInfected(boolean b) {
		this.isInfected = b;
	}

	/**
	 * Methode setState. Cette methode remplace l'etat de l'individu.
	 * 
	 * @param state
	 */
	public void setState(StateEnum state) {
		this.state = state;
	}

	/**
	 * Methode setVirus. Cette methode remplace le virus du LivingBeing.
	 * 
	 * @param virus
	 */

	public void setVirus(Virus virus) {
		this.virus = virus;
	}

	/**
	 * Methode setResistance. Cette methode remplace la resistance du
	 * LivingBeing.
	 * 
	 * @param val
	 */

	public void setResistance(double val) {
		this.resistance = val;
	}

	/**
	 * Methode setNeigh. Cette methode remplace la liste des voisins de
	 * l'individu.
	 * 
	 * @param ArrayList
	 *            <Neighbourhood>
	 */
	public void setNeigh(ArrayList<LivingBeing> list) {
		this.neigh = list;
	}

	// ///////////////////////////// A ENLEVER
	// //////////////////////////////////////////
	public void setID(String id) {
		this.id = id;
	}

	// //////////////////////////////////////////////////////////////////////////////////

	/**
	 * Methode setCase. Cette methode remplace la case sur laquelle l'individu
	 * se trouve.
	 * 
	 * @param Case
	 */
	public void setCase(Case c) {
		this.caseGrid = c;
	}

	/**
	 * Methode setType. Cette methode remplace le type de LivingBeing.
	 * 
	 * @param String
	 *            t
	 */

	public void setType(String t) {
		this.type = t;
	}

	/**
	 * Methode equals. Cette methode est une redefinition de la methode equals
	 * definit dans la classe Object. Elle permet de comparer deux LivingBeing,
	 * on peut savoir grace a elle si ils sont identiques ou non.
	 * 
	 * @return boolean.
	 */

	public boolean equals(LivingBeing lb) {
		return (lb.getID().equals(this.id));
	}

	/**
	 * Methode catchVirus. Cette methode affectera le virus specifié en
	 * parametre au LivingBeing.
	 * 
	 * @param virus
	 */

	public void catchVirus(Virus virus) {
		this.virus = virus;
		this.isInfected = true;
		this.timeState = 0;
		this.state = StateEnum.SICK;
	}

	/**
	 * Methode virusLeaving. Lorsqu'un LeavingBeing guéri et redeviens sain,
	 * cette methode va mettre a jour toutes ses informations.
	 */

	public void virusLeaving() {
		this.virus = null;
		this.isInfected = false;
		this.timeState = 0;
		this.state = StateEnum.HEALTHY;
	}

	/**
	 * Methode diffuseSickness. Cette methode permet la diffusion de la maladie
	 * du LivingBeing (si il en a une).
	 */

	public void diffuseSickness() {
		if (this.state.equals(StateEnum.CONTAGIOUS)) {
			for (int i = 0; i < this.neigh.size(); i++) {
				this.giveYourSickness(this.neigh.get(i));
			}
		}
	}

	/**
	 * Methode giveYourSickness. Cette methode permet de donner ou non une
	 * maladie au LivingBeing specifiee en parametre.
	 * 
	 * @param lb
	 */

	public void giveYourSickness(LivingBeing lb) {
		double probaSickness = 0;
		Random r = new Random();
		int result;
		if (!(lb.getIsInfected())) {
			if (!(lb.getState().equals(StateEnum.DEAD))) {
				if (this.getType().equals(lb.getType())
						|| lb.getType().equals("Human")) {
					probaSickness = this.getVirus().getProbaSickness()
							- lb.getResistance();
					if (probaSickness < 0) {
						probaSickness = 0;
					}
					result = r.nextInt(100) + 1;
					if (result <= probaSickness && probaSickness != 0) {
						lb.catchVirus(this.virus);
					}
				}
			}
		}
	}

	/**
	 * Methode deadOrNot. Cette methode va calculer la probabilité que le
	 * LivingBeing a de survivre à sa maladie.
	 * 
	 * @return boolean b
	 */
	public boolean isDead() {
		boolean b = false;
		Random r = new Random();
		int proba = r.nextInt(101);
		if (proba < (10 + this.virus.getRate())) {
			b = true;
		}
		return b;
	}

	/**
	 * Methode isDead. Cette methode a pour but de changer les parametres du
	 * LivingBeing qui vient de mourrir.
	 */
	public void dead() {
		this.isInfected = false;
		this.state = StateEnum.DEAD;
		this.virus = null;
		this.timeState = 0;
		this.resistance = 0;
	}

	/**
	 * Methode lbInformations. Cette methode retourne un string contenant deux
	 * caracteres. Le premier correspond au type de LivingBeing (H pour Human,D
	 * pour Duck,P pour Pig,C pour Chicken) et le second correspond a son etat
	 * de sante.
	 * 
	 * @return
	 */
	public String lbInformations() {
		String infos = " ";
		if (this.type.equals("Human")) {
			infos = " H " + lbState();
		}
		if (this.type.equals("Pig")) {
			infos = " P " + lbState();
		}
		if (this.type.equals("Duck")) {
			infos = " D " + lbState();
		}
		if (this.type.equals("Chicken")) {
			infos = " C " + lbState();
		}

		return infos;
	}

	/**
	 * Methode lbState. Cette methode retourne un caractere correspondant a
	 * l'etat de sante du LivingBeing: H pour Healthy, S pour SICK, C pour
	 * CONTAGIOUS, R pour RECOVERING et D pour DEAD.
	 * 
	 * @return
	 */

	public char lbState() {
		char c = 'a';
		if (this.state.equals(StateEnum.HEALTHY)) {
			c = 'H';
		}
		if (this.state.equals(StateEnum.SICK)) {
			c = 'S';
		}
		if (this.state.equals(StateEnum.CONTAGIOUS)) {
			c = 'C';
		}
		if (this.state.equals(StateEnum.RECOVERING)) {
			c = 'R';
		}
		if (this.state.equals(StateEnum.DEAD)) {
			c = 'D';
		}
		return c;
	}

	public LivingState getLivingState() {
		return new LivingState(this.getClass(), state.toString());
	}
}
