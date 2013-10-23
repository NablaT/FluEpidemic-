package Living;


/**
 * Classe Chicken. Cette classe Herite de la classe Poultry.
 * @author pourtier
 *
 */
public class Chicken extends Poultry {

	/**
	 * Constructeur par défaut de la classe Chicken. On initialise le type du LivingBeing, ici c'est un Chicken.
	 */
	public Chicken(){
		super.type="Chicken";
		super.resistance=30;
	}
	
	
}
