public class Duck extends Being{


	protected final boolean dead = false; //an animal can't dead

	//CONSTRUCTEURS

	//default: a chiken born healthy
	public Duck(){
		super();
		//desease caracteristics:
		incubationTime = 1;
		infectionToRecoveringTime = 3 ;
		infectionToHealthTime = 5 ;
	}
	
	public Duck (boolean isSick){
		this();
		sick = isSick;
		contagious = false;


		if (sick == true){ timeOfBeingSick = 0;}
		else{ timeOfBeingSick = -1;}
	}
	


	//AFFICHAGE TOSTRING
	public String toString(){

		//healthy duck: "( °)="
		if (sick == false) { return "   ( °)=   "; }
		//contagious duck: "*( ~)=*"
		if (contagious == true && sick == true) { return "  *( ~)=*  "; }
		//recovering duckc: "( u)= "
		if (sick == true && contagious == false && timeOfBeingSick >= infectionToRecoveringTime) { return "   ( u)=   "; }
		//sick duck : "( ~)="
		if (sick == true) { return "   ( ~)=   "; }
		
		
		else { return "('O_O)" ;}
	}

	
	//AUTRES FONCTIONS
	
	//return "duck"
	public String is_type(){
		return "duck";
	}
	
	// a duck can be infected by an other duck or a chicken:
	//return true if the type is duck or chicken 
	public boolean is_infected_by(String type){
		if ( type == "chicken" || type == "duck") {return true;}
		else{
			return false;
		}
	}
}
