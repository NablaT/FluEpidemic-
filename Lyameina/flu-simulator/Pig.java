public class Pig extends Being{
		
	protected final boolean dead = false; //an animal can't dead

	//default: a chiken born healthy
	public Pig(){
		super();
		//desease caracteristics:
		incubationTime = 3;
		infectionToRecoveringTime = 6 ;
		infectionToHealthTime = 10 ;
	}
	public Pig (boolean sickness){
		this();
		sick = sickness;
		contagious = false;


		if (sick == true){ timeOfBeingSick = 0;}
		else{ timeOfBeingSick = -1;}
	}
	
	//AFFICHAGE TOSTRING
	public String toString(){

		//healthy pig: "(°oo°)"
		if (sick == false) { return "   (°oo°)  "; }
		//contagious pig: "*(~oo~)*"
		if (contagious == true && sick == true) { return " *(~oo~)*  "; }
		//recovering pig: "(-oo-) "
		if (sick == true && contagious == false && timeOfBeingSick >= infectionToRecoveringTime) { return "  (-oo-)   "; }
		//sick pig : "(~oo~)"
		if (sick == true) { return "  (~oo~)   "; }
		
		
		else { return "('O_O)" ;}
	}
	
	//AUTRES FONCTIONS
	
	//return "pig"
	public String is_type(){
		return "pig";
	}
	// a pig can be infected by an otherpig:
	//return true only if the type is pig 
	public boolean is_infected_by(String type){
		if ( type == "pig"){return true;}
		else{
			return false;
		}
	}
}
