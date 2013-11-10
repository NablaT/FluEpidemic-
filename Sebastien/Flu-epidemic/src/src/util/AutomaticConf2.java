package src.util;

import java.util.HashMap;

// Configuration of an automatic simulation

public class AutomaticConf2 {
	
	public static void main(String args[]){
		
		HashMap configuration = new HashMap<String, Object>();
		
		//----------------//
		//--Map creation--//
		//----------------//
		
		// 90 % of cells will be completed
		configuration.put("CELL_RATE", 90);
		
		// Apparition rates
		configuration.put("BIRD_RATE", 5);
		configuration.put("PIG_RATE", 8);
		
		// Infection rates
		configuration.put("INFECTION_BIRD_RATE", 15);
		configuration.put("INFECTION_PIG_RATE", 5);
		
		
		//---------------------------//
		//--Controler configuration--//
		//---------------------------//

		configuration.put("AUTOMATIC_PLAY", true);
		configuration.put("DAY_TIME_IN_MILI", 100);
		configuration.put("STOP_SIMULATION", "stop");
		
		ConfigXML.store(configuration, "conf/AutomaticConf", "2.0");
	}
	
	
	
}
