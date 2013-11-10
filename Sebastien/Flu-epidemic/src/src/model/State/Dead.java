package src.model.State;

import src.model.Virus.Virus;
import src.model.animals.Animal;

public class Dead extends State{

	public Dead(Animal animal){
		this.illnessDayNumber = null;
		animal.virus = null;
	}

	@Override
	public void next(Context context, Animal current, Virus presentVirus) {}

	@Override
	public void infect(Context context, Animal infectious, Animal toInfect, Virus infection) {}
}
