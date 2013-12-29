package Virus;

/**
 * Classe Virus. Cette classe definit les virus qui peuvent se transmettre entre
 * animaux. Un virus se caracterise par son nom, son taux de mortalité, sa
 * periode d'incubation ainsi que la probabilité qu'un LivingBeing soit infecté
 * par un virus.
 * 
 * @author pourtier
 * 
 */
public abstract class Virus {

	protected String name;
	protected int mortalityR;// Taux de mortalite.
	protected int incubationTime; // Temps que met le virus pour rendre l'etre
									// vivant malade.
	protected int probaSickness;

	/**
	 * Methode getName. Cette methode retourne le nom du virus.
	 * 
	 * @return String name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Methode getRate. Cette methode retourne le taux de mortalite du virus
	 * 
	 * @return int mortalityR
	 */
	public int getRate() {
		return this.mortalityR;
	}

	/**
	 * Methode getIncubation. Cette methode retourne le temps d'incubation du
	 * virus.
	 * 
	 * @return int incubationTime.
	 */

	public int getIncubation() {
		return this.incubationTime;
	}

	/**
	 * Methode probaSickness. Cette methode retourne la probabilité qu'un
	 * LivingBeing soit contaminé par le virus.
	 * 
	 * @return
	 */
	public int getProbaSickness() {
		return this.probaSickness;
	}

	/**
	 * Methode setRate. Cette methode remplace le taux de mortalite du virus.
	 * 
	 * @param r
	 */
	public void setRate(int r) {
		this.mortalityR = r;
	}

	/**
	 * Methode setIncubation. Cette methode remplace le temps d'incubation du
	 * virus.
	 * 
	 * @param t
	 */

	public void setIncubation(int t) {
		this.incubationTime = t;
	}

	/**
	 * Methode probaSickness. Cette methode remplace la probabilité qu'un
	 * LivingBeing a de se faire contaminer par le virus.
	 * 
	 * @param proba
	 */
	public void setProbaSickness(int proba) {
		this.probaSickness = proba;
	}

	/**
	 * Methode equals. Cette methode permet de savoir si deux virus sont
	 * identiques.
	 * 
	 * @param virus
	 * @return boolean
	 */

	public boolean equals(Virus virus) {
		return (virus.getIncubation() == this.incubationTime
				&& virus.getName().equals(this.name)
				&& virus.getProbaSickness() == this.probaSickness && virus
					.getRate() == this.mortalityR);
	}

}
