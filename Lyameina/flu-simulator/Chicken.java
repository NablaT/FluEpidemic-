public class Chicken extends Being {
	
	protected final boolean dead = false; //an animal can't dead
	
	
	
	
	//CONSTRUCTEURS
	//default: a chicken born healthy
	public Chicken(){
		super();
		//desease caracteristics:
		incubationTime = 1;
		infectionToRecoveringTime = 5 ;
		infectionToHealthTime = 6 ;
	}
	public Chicken (boolean is_sick){
		this();
		sick = is_sick;
		contagious = false;

		if (sick == true){ timeOfBeingSick = 0;}
		else{ timeOfBeingSick = -1;}

	}
	
	
	
	//AFFICHAGE TOSTRING

	public String toString(){

		//healthy chicken: "ε(°v°)3"
		if (sick == false) { return "  ε(°v°)3  "; }
		//contagious chiken: "*ε(~v~)3*"
		if (contagious == true && sick == true) { return " *ε(~v~)3* "; }
		//recovering chiken : "ε(-v-)3 "
		if (sick == true && contagious == false && timeOfBeingSick >= infectionToRecoveringTime) { return "  ε(-v-)3  "; }
		//sick chicken : "ε(~v~)3"
		if (sick == true) { return "  ε(~v~)3  "; }
		
		
		else { return "('O_O)" ;}
	}
	
	//AUTRES FONCTIONS
	
	//return "chicken"
	public String is_type(){
		return "chicken";
	}
	
	// a chicken can be infected by an other chiken or a duck:
	//return true if the type is duck or chicken 
	public boolean is_infected_by(String type){
		if ( type == "chicken" || type == "duck") {return true;}
		else{
			return false;
		}
	}
}
