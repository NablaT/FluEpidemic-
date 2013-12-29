package Virus;

/**
 * Classe H1N1. Cette classe herite de la classe virus. 
 * @author pourtier
 *
 */
public class H1N1 extends Virus {

	/**
	 * Constructeur de la classe H1N1. Creation d'un virus H1N1 a partir du taux de mortalité et du temps d'incubation rentré 
	 * en parametre. 
	 * @param mortalityR
	 * @param incubation
	 */
	
	public H1N1(int mortalityR, int incubation, int probaSickness){
		super.name="H1N1"; 
		super.mortalityR=mortalityR; 
		super.incubationTime= incubation; 
		super.probaSickness=probaSickness;

	}
	
	
	
}
