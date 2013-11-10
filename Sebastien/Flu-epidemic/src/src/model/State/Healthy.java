package src.model.State;

import java.util.Random;

import src.model.Virus.Virus;
import src.model.animals.Animal;


public class Healthy extends State{

	public Healthy(){
		this.illnessDayNumber = null;
	}

	@Override
	public void next(Context context, Animal current, Virus presentVirus){}

	@Override
	public void infect(Context context, Animal infectious, Animal toInfect, Virus infection) {

		// Check if a virus is present
		if(infection != null){

			// Create a random number (0-100)
			Random r = new Random();
			Integer i = r.nextInt(100);

			// Take in consideration the resistance against the virus caused by the immune system
			i += toInfect.previousContagions;

			// Apply the infection possibility thanks to the infection rate
			if(infection.infectionRate > i 
					&& infection.isTransmissible(infectious, toInfect)){
				toInfect.setVirus(infection);
				toInfect.previousContagions += 1;
			}
		}
	}

}
