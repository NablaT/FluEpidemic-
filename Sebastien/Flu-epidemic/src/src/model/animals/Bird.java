package src.model.animals;

import src.model.State.Sick;
import src.model.Virus.Virus;

public class Bird extends Animal{

	public void setSick(Virus virus){
		this.virus = virus;
		this.context.currentState = new Sick();
	}
	
}
