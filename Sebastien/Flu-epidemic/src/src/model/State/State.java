package src.model.State;

import src.model.Virus.Virus;
import src.model.animals.Animal;

public abstract class State {

	public Integer illnessDayNumber;
	
	// Methods to override
	public abstract void next(Context context, Animal current, Virus presentVirus);	
	public abstract void infect(Context context, Animal infectious, Animal toInfect, Virus infection);
	
}
