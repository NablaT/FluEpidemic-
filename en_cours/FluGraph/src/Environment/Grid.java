package Environment;

import FandRInterface.Field;
import Living.LivingBeing;

/**
 * Classe Grid. Cette classe correspond à la grille sur laquelle les LivingBeing
 * vont se situer. Cette classe contient une matrice de cases.
 * 
 * @author pourtier
 * 
 */
public class Grid {

	private Case[][] grid;
	private int column;
	private int line;

	/**
	 * Constructeur de la classe Grid. Ce constructeur permet de creer le
	 * plateau sur lequel les LivingBeing sont a partir du nombre de ligne et de
	 * colonne specifiee en parametre.
	 * 
	 * @param column
	 * @param line
	 */
	public Grid(int column, int line) {
		this.grid=new Case[column][line];
		for(int i=0;i<column;i++){
			for(int j=0;j<line;j++){
				this.grid[i][j]= new Case(i,j);
			}
		}
		this.column = column;
		this.line = line;
	}

	/**
	 * Methode getGrid. Cette methode renvoie la matrice de cases.
	 * 
	 * @return
	 */

	public Case[][] getGrid() {
		return this.grid;
	}
	
	/**
	 * Methode getColumn. Cette methode retourne le nombre de colonne de la grille.
	 * @return int
	 */
	
	public int getColumn(){
		return this.column; 
	}
	
	/**
	 * Methode getLine. Cette methode retourne le nombre de ligne de la grille. 
	 * @return int
	 */
	
	public int getLine(){
		return this.line; 
	}


	/**
	 * Methode setGrid. Cette methode permet de remplacer la matrice de case.
	 * 
	 * @param cases
	 */

	public void setGrid(Case[][] cases, int col, int line) {
		this.grid = cases;
		this.column=col; 
		this.line=line; 
	}

	/**
	 * Methode caseEmpty. Cette methode permet de savoir si une case
	 * particulière est vide ou non.
	 * 
	 * @param posX
	 * @param posY
	 * @return boolean.
	 */

	public boolean caseEmpty(int posX, int posY) {
		if (this.grid[posX][posY].getLB() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Methode sameGrid. Cette methode permet de determiner si deux grilles sont identiques ou non. 
	 * @param Grid g
	 * @return boolean
	 */

	public boolean sameGrid(Grid g) {
		if(this.column!=g.getColumn() || this.line!=g.getLine()){
			return false;
		}
		else{
			for(int i=0; i<this.line;i++){
				for(int j=0; j<this.column; j++){
					if(!(this.grid[j][i].equals(g.getGrid()[j][i]))){
						return false;
					}
				}
			}
		}
		
		return true; 
	}
	
	public Field toField(){
		if(grid.length < 1){return null;}
		Field f = new Field(grid.length, grid[0].length);
		LivingBeing lb = null;
		for(int i=0; i<this.line;i++){
			for(int j=0; j<this.column; j++){
				lb = grid[j][i].getLB();
				if(lb != null){
					f.place(lb, i, j);
				}
			}
		}
		return f;
	}
	
}
