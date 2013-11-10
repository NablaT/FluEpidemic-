package src.util;

import java.util.HashMap;

// Configuration of an automatic simulation

public class AutomaticConf {
	
	public static void main(String args[]){
		
		HashMap configuration = new HashMap<String, Object>();
		
		//----------------//
		//--Map creation--//
		//----------------//
		
		// 60 % of cells will be completed
		configuration.put("CELL_RATE", 60);
		
		// Apparition rates
		configuration.put("BIRD_RATE", 20);
		configuration.put("PIG_RATE", 20);
		
		// Infection rates
		configuration.put("INFECTION_BIRD_RATE", 25);
		configuration.put("INFECTION_PIG_RATE", 18);
		
		
		//---------------------------//
		//--Controler configuration--//
		//---------------------------//

		configuration.put("AUTOMATIC_PLAY", true);
		configuration.put("DAY_TIME_IN_MILI", 50);
		configuration.put("STOP_SIMULATION", "stop");
		
		Config.store(configuration, "conf/AutomaticConf", "1.0");
	}
	
	
	
}
