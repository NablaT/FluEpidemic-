package Environment;
import Living.LivingBeing;

/**
 * Classe Case. Cette classe definit une Case sur la grille (classe Grid). Une case possede: deux coordonnées entieres posX, posY,
 * un LivingBeing.
 * @author pourtier
 *
 */
public class Case {
	private int posX; 
	private int posY; 
	private LivingBeing lb; 
	
	
	/**
	 * Constructeur de la classe Case. Le constructeur permet de creer une case vide a partir de deux coordonees entieres.
	 * Le LivingBeing est à null.
	 * @param posX
	 * @param posY
	 */
	
	public Case(int posX,int posY){
		this.posX=posX; 
		this.posY=posY;
		this.lb=null;
	}
	/**
	 * Constructeur de la classe Case. Le constructeur permet de creer une case a partir de deux coordonees entieres et d'un LivingBeing.
	 * @param posX
	 * @param posY
	 * @param lb
	 */
	public Case(int posX, int posY, LivingBeing lb){
		this.posX=posX; 
		this.posY=posY;
		this.lb=lb; 
	}
	
	/**
	 * Methode getPosX. Cette methode retourne la valeur entiere de la position X de la case.
	 * @return int posX.
	 */
	public int getPosX(){
		return this.posX; 
	}
	/**
	 * Methode getPosY. Cette methode retourne la valeur entiere de la position Y de la case.
	 * @return int posY.
	 */
	public int getPosY(){
		return this.posY; 
	}
	
	/**
	 * Methode getLB. Cette methode retourne le LivingBeing etant sur la case.
	 * @return LivingBeing lb.
	 */
	
	public LivingBeing getLB(){
		return this.lb; 
	}
	
	/**
	 * Methode setPosX. Cette methode remplace la coordonnée en abscisse de la case.
	 * @param posX
	 */
	
	public void setPosX(int posX){
		this.posX=posX;
	}
	
	/**
	 * Methode setPosY. Cette methode remplace la coordonnee en ordonnee de la case.
	 * @param posY
	 */
	
	public void setPosY(int posY){
		this.posY=posY;
	}
	
	/**
	 * Methode setLB. Cette methode remplace le LivingBeing appartenant a cette case.
	 * @param lb
	 */

	
	public void setLB(LivingBeing lb){
		this.lb=lb; 
	}
	
	/**
	 * Methode equals. Cette methode est une redefinition de la methode equals de la classe Object. Elle permet 
	 * de comparer deux cases entre elles, elle nous indique si elles sont identiques ou pas. 
	 * @return boolean.
	 */
	
	public boolean equals(Case c){
		return (this.posX==c.getPosX() && this.posY==c.getPosY()); 
	}
}
