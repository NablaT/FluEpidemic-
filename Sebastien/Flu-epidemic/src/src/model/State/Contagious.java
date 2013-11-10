package src.model.State;

import java.util.Random;

import src.model.Virus.Virus;
import src.model.animals.*;


public class Contagious extends State{

	public Contagious(){
		this.illnessDayNumber = 0;
	}

	@Override
	public void next(Context context, Animal current, Virus presentVirus){

		if(current.virus != null){

			// Check the death moment
			if(current.virus.dyingTime < this.illnessDayNumber){

				// Create a random number (0-100)
				Random r = new Random();
				Integer i = r.nextInt(100);

				// Apply the healing possibility thanks to the healing rate
				if(current.virus != null && current.virus.healingRate > i){
					context.currentState = new Recovering();
				}
				// Or check if can die
				else if(current instanceof Human){
					context.currentState = new Dead(current);
				}
				else{
					this.illnessDayNumber = 0;
				}
			}

			// Update the number of days of this period
			this.illnessDayNumber += 1;
		}
	}

	@Override
	public void infect(Context context, Animal infectious, Animal toInfect, Virus infection) {}
}
