package src.model.Virus;

import src.model.animals.Animal;

public abstract class Virus {

	// Description of the virus
	public String name;
	public Integer infectionRate;
	public Integer healingRate;
	public Integer healingTime;
	public Integer contagiousTime;
	public Integer dyingTime;
	
	// The method to override
	public abstract boolean isTransmissible(Animal infected, Animal current);
}
