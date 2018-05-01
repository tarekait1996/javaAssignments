/*
Ait Hamouda Tarek 40044119

COMP249

Assignment #1

23/07/2017

*/
package assignments;

import java.util.Scanner;

public class Computer extends User{
public static  Scanner keyIn = new Scanner(System.in);
public Computer(){
		super();	
	}
public  void fire(Board mboard, User player, User computer){
		
	int x =(int) ((Math.random())*8); // generate random number between 0 included -8 excluded
	int y =(int) ((Math.random())*8); // same
	char a = (char)('A'+(x)) ;
	System.out.println("Position of my rocket: " + a +(y+1)); // display his rocket
	if(mboard.fire(x, y)){
		mboard.setCalled(x, y);
		if (mboard.isGrenade(x, y)){ // if there is there is a grenade on the case -- missTurn + setting turn to false
			computer.missTurn();
			computer.setTurn(false);
		}
		 else if(mboard.isPlayerShip(x, y)) computer.addPoint(); // if s then its a point for computer
		else if(mboard.isComputerShip(x, y)) player.addPoint();// if S then its a point for player
	}
	
	}
public  void setup (Board mboard){
	
	int count =1;
	do{
		
		int x =(int) ((Math.random())*8); // generate random number between 0 included -8 excluded
		int y =(int) ((Math.random())*8);
		
		if(!mboard.isTaken(x,y)){ // verify if it is not taken already
			mboard.setShip(x, y,Board.COMPUTER); //setup
			count++;
		}
		
	}
	while( count < 7);
	
	count = 1;
	do{
		
		int x =(int) ((Math.random())*8);
		int y =(int) ((Math.random())*8);
		
		if(!mboard.isTaken(x,y)){
			mboard.setGrenade(x, y,Board.COMPUTER); // setup
			count++;
		}
	}
	while( count < 5);
	
		System.out.println("OK, the computer placed its ships and grenades at random.\n");
	
}

	
}




	
	
	