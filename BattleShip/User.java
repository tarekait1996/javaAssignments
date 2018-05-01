/*
Ait Hamouda Tarek 40044119

COMP249

Assignment #1

23/07/2017

*/
package assignments;


public class User  {

	
	private boolean turn;
	private int missedTurns;
	private int point;

	
	
	
	public User(){
		turn = true;
		point =0;
		missedTurns =0;
	}
	
	public void addPoint(){
		point++;
	}
	public void setup(Board mboard){ // so that its child inherit this metod
		
	}
	public void fire(Board mboard, User b, User c){ // same as previously
		
	}
	public int getPoint(){ // return points
		return point;
	}
	

	public boolean hasWon(){ // has he won
	  return(point == 6);
}
	public void resetTurn(){ // reset the turn at true 
		turn = true;
	}
	public boolean isTurn(){ // check if it is its turn
		return turn;
	}
	public void setTurn(boolean b){ // setting the turn 
		turn = b;
	}
	public int getCol(String str){
		// decompose the string and check the position of the ship or projectile
		char y =(str.toUpperCase().charAt(0));
		int a;
		switch(y){
		case 'A':
			a = 0;
			break;
		case 'B':
			a=1;
			break;
		case 'C':
			a=2;
			break;
		case 'D':
			a=3;
			break;
			
		case 'E':
			a=4;
			break;
			
		case 'F':
			a=5;
			break;
		case 'G':
			a=6;
			break;
		case 'H':
			a=7;
			break;
			default : a= 9;


		}
		return a;
	}
	public int getRow(String str){
		
		// decompose the string and check the position of the ship or projectile
	int x = Integer.parseInt(String.valueOf(str.charAt(1)));
	
	
	if(x > 0 && x< 9)
		return (x-1);
	else 
		return 9;
	
	}

	// when he miss the turn 
	public void missTurn(){
		missedTurns ++;
	}
	// get the number of time he missed a turn
	public int getMissedTurns(){
		return missedTurns;
	}
	
	// check if its it okay 
	public  boolean isCoordinateOkay(int x, int y){
		if( x <9 && y<9)
			return true;
			return false;
	}
	public boolean equals(User u){
		
		return (turn == u.turn && missedTurns == u.missedTurns && point == u.point);
	}
	public String toString(){
		return "user has turn : " + turn + " and has missed " + missedTurns + " turns and has " + point +"points";
	}

}
