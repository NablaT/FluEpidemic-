package Living;

/**
 * Classe Duck.Cette classe herite de la classe Poultry. 
 * @author pourtier
 *
 */
public class Duck extends Poultry {

	/**
	 * Constructeur de la classe Duck. On initialise le type du LivingBeing, ici c'est un Duck.
	 */
	public Duck() {
		this.type = "Duck";
		this.resistance=10;
	}
}
