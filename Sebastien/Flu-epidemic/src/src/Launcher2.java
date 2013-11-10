package src;

import java.util.HashMap;
import java.util.Scanner;

import src.controler.Controler;
import src.util.ConfigXML;
import src.util.Configurations;



public class Launcher2 {

	public static void main(String args[]) throws Throwable{
		System.out.println("Welcome in the Flu Epidemic application (version with map loading).\n"
				+ "To run the application, please press the ENTER key.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		HashMap conf = (HashMap) ConfigXML.load("conf/CurrentConfig", "1.0");
		if(conf == null){
			conf = Configurations.getDefault();
		}

		HashMap mapDescription = (HashMap) ConfigXML.load("maps/Map", "1.0");
		
		Controler c = new Controler(mapDescription, conf);
	}
	
}
