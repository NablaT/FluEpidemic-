package src.model.Virus;

import src.model.animals.*;

public class H1N1 extends Virus{

	public H1N1(){
		this.contagiousTime = 2;
		this.dyingTime = 4;
		this.healingRate = 45;
		this.healingTime = 2;
		this.infectionRate = 45;
		this.name = "H1N1";
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