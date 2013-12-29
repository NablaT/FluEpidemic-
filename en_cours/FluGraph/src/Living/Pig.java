package Living;

/**
 * Classe Pig.Cette classe herite de la classe Animal. 
 * @author pourtier
 *
 */
public class Pig extends Animal{


	/**
	 * Constructeur de la classe Pig. On initialise le type du LivingBeing, ici c'est un Pig.
	 */
	public Pig() {
		super.type = "Pig";
		super.resistance=35;
	}
}