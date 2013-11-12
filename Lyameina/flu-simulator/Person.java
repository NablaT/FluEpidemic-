public class Person extends Being{
	
	
	//CONSTRUCTEURS
	//default: a person born healthy
	public Person(){
		super();
		//desease caracteristics:
		incubationTime = 2;
		infectionToRecoveringTime = 5 ;
		infectionToHealthTime = 8 ;
		
	}
	
	
	//AFFICHAGE TOSTRING

	public String toString(){
		//dead person : "(X_X)"
		if (dead == true) { return "   (X_X)   "; }
		//healthy person: "(^_^)"
		if (sick == false) { return "   (^_^)   "; }
		//contagious person: "*(~_~)*"
		if (contagious == true && sick == true) { return "  *(~_~)*  "; }
		//recovering person : " (u_u) "
		if (sick == true && contagious == false &&  timeOfBeingSick >= infectionToRecoveringTime) { return "   (u_u)   "; }
		//sick person : "(~_~)"
		if (sick == true) { return "   (~_~)   "; }
		else { return "('O_O)" ;}
	}
	
	
	
		
	
	//AUTRES FONCTIONS
	
	//return "person"
	public String is_type(){
		return "person";
	}
	
	
	
	
	//update for a person: a person can die:
	public void update(){
		super.update();
			//after somes days it recover(0) or die(1) depend of the desaese rate:
			if (timeOfBeingSick == infectionToRecoveringTime){
								
				double rand =Math.random(); //rand is an integer in {0;1}
				//Recovering: no more contagious and 3 day of recovery countdown
				if (rand > mortalityRate){
					contagious = false ;
				}
				if (rand < mortalityRate){
					dead = true ; 
					sick = false ;
					contagious = false ;
				}
			}
		}
	}
