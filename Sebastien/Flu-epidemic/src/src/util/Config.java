package src.util;

// Class taken from IUT Nice, developed in the APO module.

import java.io.*;

abstract public class Config {


   // ------------------------------------------     *** Methode store
   //
   public static boolean store (Object config, 
                                String  name  ,
                                String  version) {                          	
   String origine;
   String nomFichier;      
   FileOutputStream f= null;
   ObjectOutputStream out= null;
   
      // Controler l'existence de la configuration
      //
      if (config == null) return false;
      
      // Controler la classe d'origine de la configuration
      //
      origine= config.getClass().getName();
      if (origine != "java.util.HashMap" && 
          origine != "java.util.LinkedHashMap") return false;
      
      // Construire le nom du fichier de configuration
      //
      nomFichier= name + "-" + version + ".conf";
      
      // Construire un fichier logique et le fichier physique associe
      //
      try {f= new FileOutputStream(nomFichier);}
      catch (Exception e) {return false;}
      
      // Construire un flux de sortie base sur le fichier logique
      //
      try {out= new ObjectOutputStream(f);}
      catch (Exception e) {return false;}
      
      // Serialiser la configuration dans le flux de sortie
      //
      try{out.writeObject(config);}
      catch (Exception e) {return false;}
      
      System.out.println("Enregistrement du fichier " + nomFichier + " : OK");
      return true;
   }
   
   // ------------------------------------------     *** Methode load
   //
   public static Object load (String  name   ,    
                              String  version) {
   String origine;
   String nomFichier;      
   FileInputStream f= null;
   ObjectInputStream in= null;
   Object resultat;
   
      // Construire le nom du fichier source de la configuration
      //
      nomFichier= name + "-" + version + ".conf";
      
      // Construire un fichier logique correspondant
      //
      try {f= new FileInputStream(nomFichier);}
      catch (Exception e) {return null;}
      
      // Construire un flux d'entree base sur le fichier logique
      //
      try {in= new ObjectInputStream(f);}
      catch (Exception e) {return null;}
      
      // Acquerir et deserialiser le flux d'entree
      //
      try{resultat=in.readObject();}
      catch (Exception e) {return null;}
      
      // Controler la classe d'origine du resultat
      //
      origine= resultat.getClass().getName();
      if (origine != "java.util.HashMap" && 
          origine != "java.util.LinkedHashMap") return null;
          
      System.out.println("Chargement du fichier " + nomFichier + " : OK");
      return resultat;
   }
}
