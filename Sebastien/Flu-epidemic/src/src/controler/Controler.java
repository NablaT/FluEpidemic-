package src.controler;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributesException;

import src.model.engine.Model;
import src.util.Configurations;
import src.view.Displayer;


public class Controler {

	// Model, representation of the state of the simulation
	Model model;
	// View, in charge of displaying the simulation
	Displayer view;
	// Thread to run to start the simulation
	Simulation game;

	public Controler(int x, int y, HashMap conf) throws Throwable{

		// Load the configurations
		Configurations c = new Configurations(conf);

		// Check the validity of the given grid size
		if(x < 1){x = 5;}
		if(y < 1){y = 5;}

		// Create the model and set the grid

		model = new Model(x, y);
		model.setAnimals(model.getGeneratedMap(x, y));

		// Create the view
		view = new Displayer();

		// Run simulation
		game = new Simulation();
		game.run();
	}

	public Controler(HashMap mapDescription, HashMap conf) throws Throwable{

		// Load the configurations
		Configurations c = new Configurations(conf);
		
		if(mapDescription.get("dimensions") == null 
				|| !(mapDescription.get("dimensions") instanceof Dimension)){
			throw new Throwable("Invalid description : incorrect dimensions");
		}
		if(mapDescription.get("animals") == null 
				|| !(mapDescription.get("animals") instanceof HashMap)){
			throw new Throwable("Invalid description : incorrect dimensions");
		}

		Dimension d = (Dimension) mapDescription.get("dimensions");
		HashMap animals = (HashMap) mapDescription.get("animals");
		model = new Model(d.width, d.height);
		model.setAnimals(animals);

		// Create the view
		view = new Displayer();

		// Run simulation
		game = new Simulation();
		game.run();
	}


	private class Simulation implements Runnable{

		String prompt;

		@Override
		public void run() {
			// While someone is ill
			while(!model.finished()){

				// Display the current state of the grid
				view.display(model.getGridDesctiption(), model.day);

				// In case of an automatic day iteration
				if(Configurations.getInstance().AUTOMATIC_PLAY){
					// Wait
					try {Thread.currentThread().sleep(Configurations.getInstance().DAY_TIME_IN_MILI);
					} catch (InterruptedException e) {}
				}
				// In case of a manual day iteration
				else{
					// Wait the answer
					Scanner scan = new Scanner(System.in);
					// If asked, stop
					if(scan.nextLine().equals(Configurations.getInstance().STOP_SIMULATION)){break;}

				}
				// Update model state
				model.next();
			}

			// Display the final state of the simulation
			view.display(model.getGridDesctiption(), model.day);
			// Inform of the end of the simulation
			System.out.println("\nSimulation ended");
		}
	}

}
