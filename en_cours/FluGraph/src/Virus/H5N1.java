package Virus;

/**
 * Classe H5N1.  Cette classe definit le virus H5N1.
 * Classe mere: Virus.
 * @author pourtier
 *
 */
public class H5N1 extends Virus {
	
	/**
	 * Constructeur de la classe H5N1. Creation d'un virus H5N1 a partir du taux de mortalité et du temps d'incubation rentrés 
	 * en parametre. 
	 * @param mortalityR
	 * @param incubation
	 */
	
	public H5N1(int mortalityR, int incubation, int probaSickness){
		super.name="H5N1"; 
		super.mortalityR=mortalityR; 
		super.incubationTime= incubation; 
		super.probaSickness=probaSickness;
	}
	
	
}
