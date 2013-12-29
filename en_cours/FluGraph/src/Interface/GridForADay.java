package Interface;

import Environment.GameRound;

/**
 * Classe GridForADay. Cette classe va creer une chaine de caractere correspondant a l'affichage d'une grille pour
 * un jour donné. Une GridForADay possede deux attributs: une chaine de caractere et un GameRound.
 * @author pourtier
 *
 */

public class GridForADay {
	
	public String gridDisplay;
	public GameRound game; 
	
	/**
	 * Constructeur de la classe GridForADay. La chaine de caractere est initialisée avec un espace et le GameRound 
	 * est specifié en parametre. La methode buildTheGrid est appelee directement apres l'initialisation des attributs.
	 * @param game
	 */
	public GridForADay(GameRound game){
		this.gridDisplay=" ";
		this.game=game;
		this.buildTheGrid();
	}
	
	/**
	 * Methode buildTheGrid. Cette methode permet de creer entierement la chaine de caractere correspondant a 
	 * l'affichage d'une grille pour un jour.
	 */
	public void buildTheGrid(){
		PieceOfDisplay piece= new PieceOfDisplay();
		piece.setDay(this.game.getDay());
		this.gridDisplay=piece.getDay()+"\n";
		for(int j=0;j<this.game.getGrid().getLine();j++){
			this.border(); 
			this.content(j);
			this.border(); 
		}	
	}
	
	/**
	 * Methode border. Cette methode construit les bords horizontaux de la grille. 
	 */
	
	public void border(){
		for(int i=0; i<this.game.getGrid().getColumn();i++){
			this.gridDisplay=this.gridDisplay+"+--------";
		}
		this.gridDisplay=this.gridDisplay+"+\n";
	}
	
	/**
	 * Methode content. Cette methode construit tout une ligne de case. Pour chaque case, les informations 
	 * du LivingBeing sont enregistres dans la chaine de caractere. 
	 * @param line
	 */
	
	public void content(int line){
		this.gridDisplay=this.gridDisplay+"|  ";
		for(int i=0; i<this.game.getGrid().getColumn();i++){
			/*
			 * Si la case n'est pas vide 
			 */
			if(this.game.getGrid().getGrid()[i][line].getLB()!=null){
			this.gridDisplay=this.gridDisplay+this.game.getGrid().getGrid()[i][line].getLB().lbInformations();
				if (i != (this.game.getGrid().getColumn() - 1)) {
					this.gridDisplay = this.gridDisplay + "  |  ";
				}
			}
			/*
			 * Si la case est vide et que l'on est pas à la derniere case
			 */
			else if(i!=(this.game.getGrid().getColumn() - 1)){
				this.gridDisplay=this.gridDisplay+"      |  ";
			}
			else{
				this.gridDisplay=this.gridDisplay+"    ";
			}
		}
		this.gridDisplay=this.gridDisplay+"  |\n";
	}
	
	/**
	 * Methode getDisplay. Cette methode renvoie la chaine de caractere correspondant a l'affichage de la grille. 
	 * @return
	 */
	
	public String getDisplay(){
		return this.gridDisplay;
	}

}
