package src.util;

import java.util.HashMap;

public class Configurations {
	
	// Implementation of the Singleton design pattern
	private static Configurations configurations;
	
	public Integer CELL_RATE;
	
	// Apparition rates
	public Integer BIRD_RATE;
	public Integer PIG_RATE;
	
	// Infection rates
	public Integer INFECTION_BIRD_RATE;
	public Integer INFECTION_PIG_RATE;
	
	public Boolean AUTOMATIC_PLAY;
	public Integer DAY_TIME_IN_MILI;
	public String STOP_SIMULATION;
	
	public Configurations(HashMap<String, Object> conf) throws Throwable {
		configurations = this;
		CELL_RATE = (Integer) conf.get("CELL_RATE");
		BIRD_RATE = (Integer) conf.get("BIRD_RATE");
		PIG_RATE = (Integer) conf.get("PIG_RATE");
		INFECTION_BIRD_RATE = (Integer) conf.get("INFECTION_BIRD_RATE");
		INFECTION_PIG_RATE = (Integer) conf.get("INFECTION_PIG_RATE");
		AUTOMATIC_PLAY = (Boolean) conf.get("AUTOMATIC_PLAY");
		DAY_TIME_IN_MILI = (Integer) conf.get("DAY_TIME_IN_MILI");
		STOP_SIMULATION = (String) conf.get("STOP_SIMULATION");
		if(CELL_RATE == null || BIRD_RATE == null || PIG_RATE == null
				|| INFECTION_BIRD_RATE == null || INFECTION_PIG_RATE == null
				|| AUTOMATIC_PLAY == null || DAY_TIME_IN_MILI == null || STOP_SIMULATION == null){
			throw new Throwable("Bad configuration file");
		}
		
		
	}

	// Implementation of the Singleton design pattern
	public static Configurations getInstance(){
		return configurations;
	}

	public static HashMap getDefault() {

		HashMap<String, Object> def = new HashMap<String, Object>();
		
		def.put("CELL_RATE", 60);
		def.put("BIRD_RATE", 20);
		def.put("PIG_RATE", 20);
		def.put("INFECTION_BIRD_RATE", 25);
		def.put("INFECTION_PIG_RATE", 18);
		def.put("AUTOMATIC_PLAY", true);
		def.put("DAY_TIME_IN_MILI", 50);
		def.put("STOP_SIMULATION", "stop");
		
		return def;
		
	}
	
}
