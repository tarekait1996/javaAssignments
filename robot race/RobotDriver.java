package Assignments;
// -------------------------------------------------------
// Assignment 4
// Written by: Tarek Ait Hamouda , ID: 40044119
// For COMP 248 Section 2164-WK – Winter 2017
//--------------------------------------------------------

import java.util.Scanner;

public class RobotDriver {


	public static void Header(){ // simply the header
		
		System.out.print("= 0 = 0 = 0 = 0 = 0 = 0 = 0 =\n");
		System.out.print("= 0                       0 =\n");
		System.out.print("= 0       Robot Walk      0 =\n");
		System.out.print("= 0                       0 =\n");
		System.out.print("= 0 = 0 = 0 = 0 = 0 = 0 = 0 =\n\n");
	}
	
	public static int size(Scanner key){ // getting the size of the grid 
		
		System.out.print("What is the size of your grid? ");
		int size = key.nextInt();
		
		return size;	
	}
	
	public static void closingMessage( Robot myRobot, int count){
		
		System.out.println("\n"+myRobot.getName()+" reached its final destination in " + count + " moves."); // closing message to display when the robot won!
	}
	
	public static void main(String[] args) {
		 Scanner key = new Scanner(System.in); // scanner
		
		String name;
		Robot myRobot = new Robot();
		
		Header(); // display header
		
		System.out.println("What is the name of your robot?");
		name = key.nextLine();
		myRobot.setName(name); // getting the name
		
		int size = size(key); // calling static methot to get the size
		int count =0; // counter to keep track of how many smoves taken
		int steps; 
		
		System.out.println("\nTime for " + name +" to start walking!!!!");// let's start!
		System.out.println("At start " + myRobot.getName() + " is facing " +myRobot.getDirection()+ " and at position (" +myRobot.getX()+","+myRobot.getY()+")" );
		
		do{
			steps = myRobot.Steps(size); // getting the steps randomly from a method in the Robot class
			char temp = myRobot.getDirection();// this keep the old direction in to check if it changed later on
			myRobot.move(steps,size); // let's move it!
			
			System.out.println("==> Number of steps to take " + steps + "."); // displaying steps
			if(!myRobot.checkDirection(temp))// check if it changed direction
				System.out.println("  New direction: "+ myRobot.getDirection()); // displaying new direction
			System.out.println("	Result: "+myRobot.toString()); // result after each move 
			count++;
		}
		while(!myRobot.won(size)); // while it didnt win it goes on...
		
		closingMessage(myRobot, count); // closing message
		
	key.close();	
	}
	

}
