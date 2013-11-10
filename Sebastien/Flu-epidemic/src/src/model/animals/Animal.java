package src.model.animals;


import src.model.State.Contagious;
import src.model.State.Context;
import src.model.State.Sick;
import src.model.Virus.Virus;

public abstract class Animal {

	// The eventual virus
	public Virus virus;
	// The context (support of animal's state)
	public Context context;
	// The number of eventual previous contagions
	public int previousContagions;

	
	public Animal(){
		// Set the virus to null
		virus = null;
		// Initialise the context
		context = new Context();
		// Set that it has not been infected yet
		previousContagions = 0;
	}

	public void infect(Virus v, Animal infected){
		// Call the context method if the animal is contagious
		if(infected.context.currentState instanceof Contagious){
			context.infect(infected, this, v);
		}
	}

	// Allows to set the virus
	public void setVirus(Virus v){
		// Set the attribute
		this.virus = v;
		// Increment the contagious number
		this.previousContagions++;
		// Set the animal sick
		context.currentState = new Sick();
	}
}
