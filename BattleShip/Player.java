/*
Ait Hamouda Tarek 40044119

COMP249

Assignment #1

23/07/2017

*/
package assignments;
import java.util.*;
public class Player extends User {
	
	
	public static  Scanner keyIn = new Scanner(System.in);
	
	
	public Player(){
		super();
	}

	public  void fire(Board mboard, User player, User computer){
		
		System.out.print("position of your rocket: ");
		String str = keyIn.next();
	
		while((str.length() != 2 )){
				System.out.println("sorry, coordinates outside the grid. try again.");
				System.out.print("position of your rocket: ");
				 str = keyIn.next();
			}
			
			
		int x = getCol(str);
		int y = getRow(str);
		if(mboard.fire(x, y)){
			mboard.setCalled(x, y);
				 if (mboard.isGrenade(x, y)){
					 player.missTurn();
					player.setTurn(false);
				 }
				 else if(mboard.isPlayerShip(x, y)) computer.addPoint();
				else if(mboard.isComputerShip(x, y)) player.addPoint();
				
		}
			
	}
	public  void setup (Board mboard){
	
	int count =1;
	
	do{
		System.out.print("Enter the coordinates of your ship #" +count + ": ");
		
		String str = keyIn.next();
		int x = getCol(str);
		int y = getRow(str);
		
		
		if(!isCoordinateOkay(x,y) || (str.length() > 2) || (str.length() == 1)){
			do{
				System.out.println("sorry, coordinates outside the grid. try again.");
				System.out.print("Enter the coordinates of your ship #" +count + ": ");
				str = keyIn.next();
				 x = getCol(str);
				 y = getRow(str);
			}
			while(!isCoordinateOkay(x,y));
		}
			
		if( !mboard.isTaken(x, y)){
			mboard.setShip(x, y,"human");
			count++;
		}
		else {
					System.out.println("sorry, coordinates already used. try again.");
		}
	}
	while(count <7);
	
	System.out.println(); // space
	count = 1;
	do{
		System.out.print("Enter the coordinates of your grenade #" +count + ": "); // similar as setting ship
		String str = keyIn.next();
		int x = getCol(str);
		int y = getRow(str);
		
		if(!isCoordinateOkay(x,y) ||( str.length() > 2) || (str.length() ==1)){
			do{
				System.out.println("sorry, coordinates outside the grid. try again.");
				System.out.print("Enter the coordinates of your grenade #" +count + ": ");
				str = keyIn.next();
				 x = getCol(str);
				 y = getRow(str);
			}
			while(!isCoordinateOkay(x,y));
		}
		if( !mboard.isTaken(x, y)){ // if the case is taken display a correct message
			mboard.setGrenade(x, y, "human");
			count++;
		}
		else {
					System.out.println("sorry, coordinates already used. try again.");
		}
	}
	while(count <5);
	
}


}
