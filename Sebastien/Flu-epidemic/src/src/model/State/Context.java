package src.model.State;

import src.model.Virus.Virus;
import src.model.animals.Animal;

public class Context {

	// Health state
	public State currentState;
	
	public Context(){
		currentState = new Healthy();
	}
	
	// Update the state
	public void next(Animal current){
		currentState.next(this, current, current.virus);
	}

	// Try to infect
	public void infect(Animal infectious, Animal toInfect, Virus infection){
		this.currentState.infect(this, infectious, toInfect, infection);
	}
}
