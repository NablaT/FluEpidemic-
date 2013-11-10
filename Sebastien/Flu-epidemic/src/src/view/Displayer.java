package src.view;

import src.util.AnimalInformations;

public class Displayer {

	// Statistics variables
	int healthyHumans;
	int sickHumans;
	int contagiousHumans;
	int recoveringHumans;
	int deadHumans;
	int healthyAnimals;
	int sickAnimals;
	int contagiousAnimals;
	int recoveringAnimals;
	int deadAnimals;
	
	public void display(AnimalInformations[][] gridDescription, int day) {

		// Initialize the variables
		healthyHumans = 0;
		sickHumans = 0;
		contagiousHumans = 0;
		recoveringHumans = 0;
		deadHumans = 0;
		healthyAnimals = 0;
		sickAnimals = 0;
		contagiousAnimals = 0;
		recoveringAnimals = 0;
		deadAnimals = 0;
		
		// Create the final String
		String res = "";
		
		// Create a line on the top
		for(int j = 0; j < gridDescription[0].length; j++){
			res += " __";
		}
		
		res += "\n";
		
		// Iterate on the lines
		for(int i = 0; i < gridDescription.length; i++){
			// Iterate on the columns
			for(int j = 0; j < gridDescription[0].length; j++){
				if(gridDescription[i][j] == null){
					// Display an empty cell
					res += displayEmptyCell();
				}
				else{
					// Display the cell
					res += displayCell(gridDescription[i][j]);
					// Update the human statistics
					if(gridDescription[i][j].species.equals("Human")){
						if(gridDescription[i][j].state.equals("Healthy")){healthyHumans++;}
						if(gridDescription[i][j].state.equals("Sick")){sickHumans++;}
						if(gridDescription[i][j].state.equals("Contagious")){contagiousHumans++;}
						if(gridDescription[i][j].state.equals("Recovering")){recoveringHumans++;}
						if(gridDescription[i][j].state.equals("Dead")){deadHumans++;}
					}
					// Update the other animals statistics
					else{
						if(gridDescription[i][j].state.equals("Healthy")){healthyAnimals++;}
						if(gridDescription[i][j].state.equals("Sick")){sickAnimals++;}
						if(gridDescription[i][j].state.equals("Contagious")){contagiousAnimals++;}
						if(gridDescription[i][j].state.equals("Recovering")){recoveringAnimals++;}
						if(gridDescription[i][j].state.equals("Dead")){deadAnimals++;}
					}
				}
			}
			// Add a line
			res += "|\n";
			res += ligne(gridDescription[0].length);
			res += "|\n";
		}
		
		// Add the statistics to the final string
		res = addStatistics(res, day);
		System.out.println(res);
	}

	private String addStatistics(String res, Integer day) {
		
		res += "\nDay " + day + "\n";
		res += "\nHumans statistics : \n\tHealthy : " + healthyHumans
				+ "\n\tSick : " + sickHumans + "\n\tContagious : " + contagiousHumans
				+ "\n\tRecovering : " + recoveringHumans + "\n\tDead : " + deadHumans + "\n";
		res += "\nAnimals statistics : \n\tHealthy : " + healthyAnimals
				+ "\n\tSick : " + sickAnimals + "\n\tContagious : " + contagiousAnimals
				+ "\n\tRecovering : " + recoveringAnimals + "\n\tDead : " + deadAnimals;
		
		return res;
	}

	private String ligne(int size) {
		String res = "";
		for(int i = 0; i < size; i++){
			res += "|__";
		}
		return res;
	}

	private String displayEmptyCell() {
		return "|  ";
	}

	private String displayCell(AnimalInformations animalInformations) {
		return "|" + getSpecieCarac(animalInformations.species) 
				+ getSpecieState(animalInformations.state);
	}

	private String getSpecieState(String state) {
		if(state.equals("Healthy")){return " ";}
		else if(state.equals("Sick")){return "S";}
		else if(state.equals("Contagious")){return "C";}
		else if(state.equals("Recovering")){return "R";}
		else if(state.equals("Dead")){return "X";}
		return "?";
	}

	private String getSpecieCarac(String specie) {
		if(specie.equals("Pig")){return "P";}
		else if(specie.equals("Bird")){return "B";}
		else if(specie.equals("Human")){return "H";}
		return "?";
	}

}
