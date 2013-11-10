package src.model.State;

import src.model.Virus.Virus;
import src.model.animals.Animal;

public class Sick extends State{

	public Sick(){
		this.illnessDayNumber = 0;
	}

	@Override
	public void next(Context context, Animal current, Virus presentVirus){

		// Increment the illness day number
		this.illnessDayNumber += 1;

		// Check the start of the contagious period
		if(current.virus.contagiousTime < this.illnessDayNumber){
			context.currentState = new Contagious();
		}
	}

	@Override
	public void infect(Context context, Animal infectious, Animal toInfect, Virus infection) {}

}
