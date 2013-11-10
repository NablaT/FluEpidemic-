package src.model.State;

import src.model.Virus.Virus;
import src.model.animals.Animal;

public class Recovering extends State{

	public Recovering(){
		this.illnessDayNumber = 0;
	}

	@Override
	public void next(Context context, Animal current, Virus presentVirus){

		// Check if the time to totally recover has come
		if(current.virus != null && current.virus.healingTime < this.illnessDayNumber){
			// Set the animal healthy
			context.currentState = new Healthy();
			// Delete the virus
			current.virus = null;
		}

		// Increment the recovering day number
		this.illnessDayNumber += 1;
	}

	@Override
	public void infect(Context context, Animal infectious, Animal toInfect, Virus infection) {}
}
