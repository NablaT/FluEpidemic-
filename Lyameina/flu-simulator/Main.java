import java.util.Scanner;
public class Main{
	
	
	public static void main(String[] args){
		
		double infectionRate = 0.5;
		double mortalityRate = 0.5;
		int infectionRay = 1;
		int hauteur = 3;
		int largeur = 3;
		
		
		//ask the user about some values:
		
		System.out.print("Welcom to flu-simulator!\n");
		
		boolean test = true;
		do {
		  System.out.print("Would you please enter the Infection rate percentage  : ");
		  Scanner sc = new Scanner(System.in);  //read the input
		  try{
			infectionRate = sc.nextDouble();
			infectionRate = infectionRate / 100; // because the user give a percentage
			test = true;
		  } catch (Exception e) 
		  {
			System.out.println("Wrong input! ");
			test = false;
		  }
		} while (test != true); //to check the data inputed by the user
		
		do {
		  System.out.print("Would you please enter the Mortality rate percentage  : ");
		  Scanner sc = new Scanner(System.in);
		  try{
			mortalityRate = sc.nextDouble();
			mortalityRate = mortalityRate / 100; //because the user give a percentage
			test = true;
		  } catch (Exception e) 
		  {
			System.out.println("Wrong input! ");
			test = false;
		  }
		} while (test != true);
		
		do {
			System.out.print("Would you please enter the longer of the neighbourhood infection ray  (an interger): ");
			Scanner sc = new Scanner(System.in);
			try{
				infectionRay = sc.nextInt();
				test = true;		  
			}catch (Exception e) {
				System.out.println("Wrong input! ");
				test = false;
			}
		} while (test != true);
		
		System.out.println("And now before the simulation begin, give us the grid dimention:");
		
		do {
			System.out.print("height (an interger): ");
			Scanner sc = new Scanner(System.in);
			try{
				hauteur = sc.nextInt();
				test = true;		  
			}catch (Exception e) {
				System.out.println("Wrong input! ");
				test = false;
			}
		} while (test != true);
		
		do {
			System.out.print("width (an interger): ");
			Scanner sc = new Scanner(System.in);
			try{
				largeur = sc.nextInt();
				test = true;
			}catch (Exception e) {
				System.out.println("Wrong input! ");
				test = false;
			}
		} while (test != true);
		
		
		
		//tableau de hauteur x largeur:
		Grid grid = new Grid (hauteur,largeur);
		
		
		
		//Give to all human, the new mortality rate:
		for (int y = 0; y < hauteur; y++){
				for (int x = 0; x < largeur; x++){
					if(grid.get_being_at(x,y).is_type() == "person"){ 
						grid.get_being_at(x,y).set_mortalityRate(mortalityRate);
					}
				}
			}
			



		//MOTOR
		int day = 0;
		boolean theEnd = false; // true if everybody is fine or dead
		double rand; //usefull for the random numbers
		System.out.println("Day :" + day +"\n"+grid);
		
		while (!theEnd){
			day++;
			
			//update everyone
			for (int y = 0; y < hauteur; y++){
				for (int x = 0; x < largeur; x++){
					grid.get_being_at(x,y).update();
				}
			}
			
			
			//Relasionship:
			
			//move in the grid, one after one
			for (int y = 0; y < hauteur; y++){
				for (int x = 0; x < largeur; x++){
					//if it is sick
					
					
					if (grid.get_being_at(x,y).is_contagious()){
						//look for each neighbor: if neighboor is not sick and can be infected:
						//up neighbor:
						for (int j = -infectionRay; j <= infectionRay; j++){
							for (int i = -infectionRay; i <= infectionRay;i++){
								
								if (grid.is_valid(x+i,y+j)){	 //check if the neighbor position is valid
									
									//if the neighbor is infectable and healthy:
									 if (!grid.get_being_at(x+i,y+j).is_sick() && grid.get_being_at(x+i,y+j).is_infected_by(grid.get_being_at(x,y).is_type())){ 
										
										rand = Math.random();
										
										if (rand < infectionRate){

											grid.get_being_at(x+i,y+j).set_sick(true);
										}
									}
								}
							}
						}
					}
				}
			}
		
			
			//test if it is the End or not:
			theEnd = true;
			
			//test if everybody is not sick:
			for (int y = 0; y < hauteur; y++){
				for (int x = 0; x < largeur; x++){
					if (grid.get_being_at(x,y).is_sick()){ theEnd = false;}
				}
			}
			//imprime les gens
			System.out.println("Day :" + day +"\n"+grid);
		}
	}
}
