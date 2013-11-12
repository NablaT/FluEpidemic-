public class Grid{
	
	private Being[][] grid;
	
	
	//Constructeur:
	public Grid(int hauteur,int largeur){
		grid = new Being [largeur][hauteur];
		int rand;
		for (int y = 0; y < hauteur; y++){
			for (int x = 0; x < largeur; x++){
				
				rand = (int) (Math.random() * 4); // rand in {0, 1, 2, 3}
				
				//put a sick pig in the case
				if( rand == 0 ){
					grid [x][y] = new Pig(true);
				}
				//put a sick chicken in the case
				if( rand == 1 ) {
					grid [x][y] = new Chicken(true);
				}
				//put a sick duck in the case
				if ( rand == 2 ){
					grid [x][y] = new Duck(true);
				}
				//put an healthy person in the case
				if ( rand == 3 ){
					grid[x][y] = new Person();
				}
			}
		}
	}
	
	//Accesseur:
	
	public int get_width(){
		int largeur = grid.length;
		return largeur;
	}
	
	public int get_height(){
		int hauteur = grid[0].length;
		return hauteur;
	}

	
	//String:
	
	public String toString(){
		String result = "";
		int height = get_height();
		int width = get_width();
		
		
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				result += grid[x][y];						
			}
			result += "\n\n";
		}
		result += "\n";
		return result;
	}
	
	//Others fonctions
	
	//control if (x,y) is in the grid
	public boolean is_valid (int x, int y){
		if ( x >= 0 && x < get_width() && y >= 0 && y < get_height() ){
			return true;
		}
		else{return false;}
	}
	
	//Give the being at the (x,y) position:
	public Being get_being_at(int x,int y){
		return grid[x][y];
	}
		
	
}
