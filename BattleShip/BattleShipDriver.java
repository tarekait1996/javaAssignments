/*
Ait Hamouda Tarek 40044119

COMP249

Assignment #1

23/07/2017

*/
package assignments;
public class BattleShipDriver {
	public static void battleBoard(Board mboard){
		
	
		for(int row =0; row< 8; row++){
			for(int col =0; col<8; col++){

				if(mboard.getCalled(col,row))
					System.out.print("\t"+mboard.getContent(col, row));
				else
					System.out.print("\t"+"_");
			}
			
			
				System.out.println();
			
		}
	}
	public static void header(){
		System.out.println("Hi, let's play Battleship!\n");
	}


	public static void main(String[] args) {
		
	
		
		User player = new Player(); // an object of type User, it is the player 
		User computer = new Computer(); //  an object of type User, it is the computer
		
		Board mboard = new Board(); // creating an obect of type Board which is going to help me deal with cases, characters, etc...
		
	
		header(); // a simple header for the class , welcome message
		
		player.setup(mboard); // asking user to set up the ships and bomb
		computer.setup(mboard); // randomnly setting up the ships and bomb and placing them on the 2d array of type Case in mBoard

		
		
		
		// do-while loop that is going to call methods that ask the user for 
		//projectile info + verify them +verify turns + + display the board after each turn
		
		do{
			if(player.isTurn()){ // verify if the player didn't lose a turn
				
			player.fire(mboard,player,computer); // fire method in class Player ;
			
			battleBoard(mboard); // displaying the board
			}
			else player.resetTurn(); //  if the player lost a turn this is going to reset it
			
			
			if(computer.isTurn()){// verify if the computer didn't lose a turn
				
			computer.fire(mboard, player,computer); // call fire method inside the class Computer
			
			battleBoard(mboard); // printing the board
			}
			else computer.resetTurn();
			
			
		}
		while(!player.hasWon()&&!computer.hasWon()); // until someone won
		
		
		// determine who won + display a message informing the users 
		
		if(player.hasWon()) 
			System.out.println("Congratulations!! Player has won!");
		else
			System.out.println("Computer won!");
		// diplay missed turns
		System.out.println(" Player missed " + player.getMissedTurns() + " turns\nComputer missed " + computer.getMissedTurns() + " turns");
		// display the final board
		
		for(int i =0; i < 8 ; i++){
			for(int j = 0; j < 8; j++){
				if(mboard.getContent(i, j) == "_" ||mboard.getContent(i, j) == "*")
					System.out.print("\t ");
				else
				System.out.print("\t"+mboard.getContent(i, j));
				
			}
			System.out.println();
		}
		
		
		
		
		

	}
	

}
