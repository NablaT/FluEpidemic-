public class Being {
		
	//VARIABLES D'INSTANCES
	protected boolean sick;
	protected boolean contagious;
	protected boolean dead;
	protected int timeOfBeingSick; //if timeOfBeingSick equals -1 it's mean that the being is not infected
	protected  double mortalityRate = 1/2; //mortality rate. default = 1/2
	
	
	
	//desease caracteristics:
	protected int incubationTime;
	protected int infectionToRecoveringTime;
	protected int infectionToHealthTime;
	protected long deseaseRate;

	//CONSTRUCTEURS

	//default: a being born healthy
	public Being(){
		sick = false;
		contagious = false;
		dead = false;
		timeOfBeingSick = -1; 
	}
	
	

	//ACCESSEURS

	public boolean is_sick(){
		return sick;
	}

	public boolean is_contagious(){
		return contagious;
	}

	public boolean is_dead(){
		return dead;
	}
	
	public int get_timeOfBeingSick(){
		return timeOfBeingSick;
	}
	


	//MODIFICATEURS
	public void set_mortalityRate(double mr){
	
		mortalityRate = mr;
	}
	
	public void set_sick( boolean s ){
		if (dead == false){
			sick = s;
			if (s == true){timeOfBeingSick = 0;}
			if (s == false){timeOfBeingSick = -1;}
		}
		
	}

	public void set_contagious ( boolean c ){
		contagious = c;
	}

	public void set_dead ( boolean d){
		//a dead being stays dead
		if (dead == false) {dead = d;}
	}
	


	//AFFICHAGE TOSTRING

	public String toString(){
		return "it's a being";
	}
	
	//AUTRES FONCTIONS
	
	//return "being" (same function in animals)
	public String is_type(){
		return "being";
	}
	
	//return true if the being can be infected by the others being
	//in this class :  all being infect being
	public boolean is_infected_by(String type){
		return true;
	}
		
	
	public void desease_caracteristics(){
		System.out.println ("incubation time = " + incubationTime);
		System.out.println ("infection to recovering time = " + infectionToRecoveringTime);
		System.out.println ("infection to health time = " + infectionToHealthTime);
	}
	

	public void update(){
		//If he's sick:
			if (sick == true){
				//1 day more:
				timeOfBeingSick++;
				
				//Recovering Case:
				if ( timeOfBeingSick > infectionToRecoveringTime){
					
					//if recovery is over: being is healthy again
					if (timeOfBeingSick == infectionToHealthTime){ 
						sick = false;
						timeOfBeingSick = -1;
					}
				}
				
				//if it not recovering yet:
				else{
					//after some day (incubationTime), being begins to be contagious.
					if (timeOfBeingSick == incubationTime){
						contagious = true;
						}
					
					//If it is already contagious:
					if (contagious == true){
						//after somes days it recover:
						if (timeOfBeingSick == infectionToRecoveringTime){
							contagious = false;
						}
					}		
				
				}
			}
		}
	}
	

