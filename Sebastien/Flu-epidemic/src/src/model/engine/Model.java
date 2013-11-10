package src.model.engine;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.naming.directory.InvalidAttributesException;

import src.model.Virus.H1N1;
import src.model.Virus.H5N1;
import src.model.Virus.Virus;
import src.model.animals.Animal;
import src.model.animals.Bird;
import src.model.animals.Human;
import src.model.animals.Pig;
import src.util.AnimalInformations;
import src.util.Configurations;


public class Model {

	// Grid, the representation of the simulation's world
	public Cell[][] grid;
	// Day, representation of the simulation's time
	public int day;
	
	public Model(int x, int y) throws InvalidAttributesException{
		// Check the parameters' validity
		if(x < 1 || y < 1){throw new InvalidAttributesException("Must be > 0");}
		// Create the grid
		grid = new Cell[x][y];
		// Initialize the time
		day = 0;
	}
	
	public HashMap<Dimension, Animal> getGeneratedMap(int x, int y) {

		HashMap<Dimension, Animal> mapDescription = new HashMap<Dimension, Animal>();
		
		int fullCell;
		int pigApparition;
		int birdApparition;
		int infectionChance;

		
		// Iterate on the matrix's elements
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){

				// Set animal to null
				Animal animal = null;

				// Get random percentages
				Random r = new Random();
				fullCell = r.nextInt(100);
				pigApparition = r.nextInt(100);
				birdApparition = r.nextInt(100);
				infectionChance = r.nextInt(100);

				// Put something in the cell depending on the fullCell value
				if(fullCell < Configurations.getInstance().CELL_RATE){
					
					// Create a pig depending on the pigApparition value
					if(pigApparition < Configurations.getInstance().PIG_RATE){
						animal = new Pig();
						// Set the pig infected depending on the infectionChance value
						if(infectionChance < Configurations.getInstance().INFECTION_PIG_RATE){
							animal.setVirus(new H1N1());
						}
					}
					// Create a bird depending on the birdApparition value
					else if(birdApparition < Configurations.getInstance().BIRD_RATE){
						
						animal = new Bird();
						// Set the bird infected depending on the infectionChance value
						if(infectionChance > Configurations.getInstance().INFECTION_BIRD_RATE){
							animal.setVirus(new H5N1());
						}
					}
					else{
						// Else set the animal as an human
						animal = new Human();
					}
					// Add the animal to the description of the map
					mapDescription.put(new Dimension(i,j), animal);
				}
			}
		}

		// Return this description
		return mapDescription;
	}


	public void setAnimals(HashMap<Dimension, Animal> animals){
		
		// Set the grid empty
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				grid[i][j] = new Cell();
			}
		}
		
		// Create the iterator and the work variable
		Iterator<Dimension> i = animals.keySet().iterator();
		Dimension currentDim;
		
		// Iterate on the description
		while(i.hasNext()){
			
			// Get the position
			currentDim = (Dimension) i.next();
			
			// Check if the position exists
			if(currentDim.width >= 0 && currentDim.width < grid.length
					&& currentDim.height >= 0 && currentDim.height < grid[0].length){
				// Set the animal at the grid position
				grid[currentDim.width][currentDim.height].setAnimal(animals.get(currentDim));
			}
		}
		
	}
	
	public void next(){
		
		// Increment the day
		day++;

		// Create the work variable
		Cell currentCell;
		
		// Iterate on the cells
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				
				// Get the current cell
				currentCell = grid[i][j];
				// Update the cell state
				currentCell.next();
				
				// Get the eventual virus
				Virus v = currentCell.contagion();
				if(v != null){
					// Infect all around
					infectAll(i, j, v);
				}
			}
		}
		
	}

	private void infectAll(int i, int j, Virus v) {
		
		// Set the work variables
		int a = i - 1;
		int b = j - 1;
		
		// Select the closest cells
		for(int x = a; x <= i+1; x++){
			for(int y = b; y <= j+1; y++){
				// Check there existence
				if(!(x == i && y == j) && cellExists(x, y)){
					// Check there is an animal
					if(grid[x][y].animal != null){
						// Try to infect him
						grid[x][y].animal.infect(v, grid[i][j].animal);
					}
				}
			}
		}
		
	}

	private boolean cellExists(int i, int j){
		// Check if it is out of bound
		if(i < 0 || i >= grid.length){return false;}
		if(j < 0 || j >= grid[0].length){return false;}
		return true;
	}
	
	public AnimalInformations[][] getGridDesctiption(){
		
		AnimalInformations[][] matrixInformations = new AnimalInformations[grid.length][grid[0].length];
		
		// Iterate on the matrix
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				// Add the cell information
				matrixInformations[i][j] = grid[i][j].getAnimalInformations();
			}
		}
		
		return matrixInformations;
	}

	public boolean finished() {
		
		// Iterate on the matrix
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				// If someone is ill, it's not finished yet
				if(grid[i][j].contagion() != null){return false;}
			}
		}
		// Else it's the end
		return true;
	}
}
