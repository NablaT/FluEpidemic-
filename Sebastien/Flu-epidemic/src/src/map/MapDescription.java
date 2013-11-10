package src.map;

import java.awt.Dimension;
import java.util.HashMap;

import src.model.Virus.*;
import src.model.animals.*;

import src.util.ConfigXML;

public class MapDescription {

	public static HashMap<String, Object> createMap(){
		HashMap<String, Object> des = new HashMap<String, Object>();
		
		des.put("dimensions", new Dimension(10,10));
		HashMap<Dimension, Animal> animals = new HashMap<Dimension, Animal>();
		
		// Put animals
		
		animals.put(new Dimension(1,1), new Pig());
		animals.put(new Dimension(2,1), new Human());
		animals.put(new Dimension(2,2), new Human());
		animals.put(new Dimension(3,1), new Human());
		animals.put(new Dimension(2,5), new Human());
		animals.put(new Dimension(1,3), new Human());
		animals.put(new Dimension(6,6), new Human());
		animals.put(new Dimension(7,6), new Human());
		animals.put(new Dimension(7,5), new Human());
		animals.put(new Dimension(7,4), new Bird());
		animals.put(new Dimension(0,1), new Human());
		animals.put(new Dimension(8,4), new Human());
		animals.put(new Dimension(4,9), new Human());
		

		// Infect some animals
		animals.get(new Dimension(1,1)).setVirus(new H1N1());
		animals.get(new Dimension(7,4)).setVirus(new H5N1());
		
		des.put("animals", animals);
		
		return des;
	}
	
	public static void main(String args[]){
		ConfigXML.store(createMap(), "maps/Map", "1.0");
	}
}
