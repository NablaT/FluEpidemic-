package Interface;

import Environment.JourEnum;

public class PieceOfDisplay {
	
	public String day;
	
	
	public String getDay(){
		return this.day; 
	}

	public void setDay(JourEnum day){
		this.day="Today : "+day;
	}
}
