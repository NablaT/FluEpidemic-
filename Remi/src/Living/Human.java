package Living;

/**
 * Classe Human.Cette classe herite de la classe LivingBeing. 
 * @author pourtier
 *
 */
public class Human extends LivingBeing {

	/**
	 * Constructeur de la classe Human. On initialise le type du LivingBeing, ici c'est un Human.
	 */
	
	public Human() {
		this.type = "Human";
		this.resistance=50;
	}
}