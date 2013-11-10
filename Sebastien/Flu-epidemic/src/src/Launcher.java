package src;

import java.util.HashMap;
import java.util.Scanner;

import src.controler.Controler;
import src.util.Config;
import src.util.Configurations;



public class Launcher {

	public static void main(String args[]) throws Throwable{
		System.out.println("Welcome in the Flu Epidemic application.\n"
				+ "This application has been developped in POO at Polytech by PETILLON Sebastien.\n"
				+ "To run the application, please press the ENTER key.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		HashMap conf = (HashMap) Config.load("conf/CurrentConf", "1.0");
		if(conf == null){
			conf = Configurations.getDefault();
		}
		
		Controler c = new Controler(10, 20, conf);
	}
	
}
