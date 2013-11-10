package src.model.engine;

import src.model.Virus.Virus;
import src.model.animals.Animal;
import src.util.AnimalInformations;

public class Cell {

	// The eventual animal contained by the cell
	public Animal animal;

	public Cell(){
		this.animal = null;
	}

	public void setAnimal(Animal animal){
		this.animal = animal;
	}

	public void next(){
		// If there is an animal inside
		if(animal != null){
			// Call the context's next method
			animal.context.next(animal);
		}
	}

	public Virus contagion(){

		// Return the eventual virus the animal can have in this cell
		if(this.animal != null && animal.virus != null && animal.context != null){
			return this.animal.virus;
		}
		return null;
	}

	public AnimalInformations getAnimalInformations() {

		if(this.animal != null){
			// Get the species
			String species = animal.getClass().getSimpleName();
			// Get the state
			String state = 	animal.context.currentState.getClass().getSimpleName();
			// Create the asked information
			return new AnimalInformations(species, state);
		}
		// If there is no animal return null
		return null;
	}

}
