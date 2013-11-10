package src.model.Virus;

import src.model.animals.*;

public class H5N1 extends Virus{

	public H5N1(){
		this.contagiousTime = 3;
		this.dyingTime = 3;
		this.healingRate = 20;
		this.healingTime = 3;
		this.infectionRate = 15;
		this.name = "H5N1";
	}

	@Override
	public boolean isTransmissible(Animal infected, Animal current) {

		// Check the existence of each animals
		if(infected == null || current == null){return false;}
		// Infects the humans
		if(current instanceof Human){return true;}
		// Infects the same species
		if(infected.getClass().equals(current.getClass())){return true;}

		// Else, don't infect

		return false;
	}
}
