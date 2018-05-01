/*
Ait Hamouda Tarek 40044119

COMP249

Assignment #1

23/07/2017

*/
package assignments;

public class Board {
	
	public static final  int  GRENADE_AMOUNT = 4;
	public static final  int  SHIP_AMOUNT = 6;
	public static final String HUMAN = "human";
	public static final String COMPUTER = "computer";
	


	
	private Case[][] board = new Case[8][8]; // its going to become an object of type cell
	
	
	
	
	public Board(){ // constructor
	
		for(int i =0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				 board[i][j] = new Case();
			}
		}
	}
	public String getContent(int x, int y){
		return(board[y][x].getContent());
	}
	public void setCalled(int x, int y){
		board[y][x].setCalled(true);
	}
	public boolean getCalled(int x, int y){
		return(board[y][x].getCalled());
	
	}
	public void displayBoard(){ // to display my board
		for(int i =0; i< 8; i++){
			for(int j =0; j<8; j++){
				System.out.print("\t"+board[i][j].getContent());
			}
			System.out.println();
		}
	}
	public boolean isHidden(int col, int row){ // verify if the character at that case is a hidden character
		if( ContentOne.valueOf(board[row][col].getContent()) == ContentOne.HIDE_CHARACTER){
			return true;
		}
		 return false;
	}
	public boolean isPlayerShip(int col, int row){ // verify if it is a small s 
		return( board[row][col].getContent().equals(ContentOne.SHIP_CHARACTER.getContent()));
	}
	public boolean isComputerShip(int col, int row){ // verify if it is a big S
		return( board[row][col].getContent().equals(ContentOne.SHIP_CHARACTER_UPPERCASE.getContent()));
			
		
		
	}
	public boolean isGrenade(int col, int row){ // if it is a grande
		return( board[row][col].getContent().equals(ContentOne.GRENADE_CHARACTER.getContent())||board[row][col].getContent().equals(ContentOne.GRENADE_CHARACTER_UPPERCASE.getContent()));
			
		
		
	}
	public boolean isHit(int col, int row){ // if it is a *
		return( board[row][col].getContent().equals(ContentOne.HIT_CHARACTER.getContent()));
		
	}
	public boolean isTaken(int col, int row){ // if it is taken
		return (!board[row][col].getContent().equals(ContentOne.HIDE_CHARACTER.getContent()));
	}
	
	public void setShip(int col, int row, String owner){ // to set up ship
		
		
		if ( !board[row][col].isTaken()){
			if( owner == HUMAN)
			board[row][col].setContent("s");
			else
				board[row][col].setContent("S");
		}
		else {
			System.out.println("sorry, coordinates already used. try again.");
			
		}
		
		
	}
	public void setGrenade(int col, int row, String owner){ // to set up grenade
		
		
		if ( !board[row][col].isTaken()){
			if(owner == "human")
			board[row][col].setContent("g");
			else
				board[row][col].setContent("G");
		
		}
		else {
			System.out.println("sorry, coordinates already used. try again.");
			
		}
	}
	
	public boolean fire (int col, int row){ // to verify if it landed on something other than nothing
		
		if ( !board[row][col].getCalled()){
			
			switch(board[row][col].getContent()){
				
			case "_":
				board[row][col].setContent("*");
				System.out.println("nothing.");
				return true;
			case "s": 
				System.out.println("ship hit.");
				return true;
			case "S": 
				System.out.println("ship hit.");
				return true;
			case "g":
				System.out.println("boom! grenade.");
				return true;
			case "G":
				System.out.println("boom! grenade.");
				return true;
			default: 
				return false;
			}
		}
		else
			System.out.println("position already called.");
			return false;
	}

}
