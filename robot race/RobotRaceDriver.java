package Assignments;
// -------------------------------------------------------
// Assignment 4
// Written by: Tarek Ait Hamouda , ID: 40044119
// For COMP 248 Section 2164-WK – Winter 2017
//--------------------------------------------------------

import java.util.Scanner;

public class RobotRaceDriver {
	static Scanner key = new Scanner(System.in);
	public static void main(String[] args){
		
		Header(); // calling the header method to display a welcome message to the user
		
		int size = getGrid(); // size of the grid
		Robot[] arr = HowMany(); // nbr of robots to race
		
		//  REGISTERING THE NAMES OF EACH ROBOT
		for(int i =0; i< arr.length;i++){
			System.out.print("Name of robot " + (i+1) + ": ");
			
			String name = key.next() + key.nextLine();
			arr[i] = new Robot(name);
		}
		System.out.println();
		
		
		
		int count = letMove(size, arr); // CALLING THE STATIC METHOD LETMOVE WHICH IS GOING TO DO ALL THE WORK

		
		displayWinner(size, arr, count); // DISPLAYING WINNER 
	}
	
	public static int getGrid(){
		int size;
		do{
			System.out.print("What is the size of your grid? (Must be at least 2) ");
			size = key.nextInt();
		}
		while(size <2);
		
		return size;
		
	}
	
	public static Robot[] HowMany(){

		int nbRobot;
		
		do{
			System.out.print("How many robots will race? (Must have at least one robot in the race) ");
			nbRobot = key.nextInt();
		}
		while(nbRobot <1);
	
		Robot[] arr = new Robot[nbRobot];
		
		return arr;
		
		
		
	}

	public static void Header(){
		
		System.out.print("= 0 = 0 = 0 = 0 = 0 = 0 = 0 =\n");
		System.out.print("= 0     Hi I am a robot   0 =\n");
		System.out.print("= 0      ============     0 =\n");
		System.out.print("= 0    we are going to    0 =\n");
		System.out.print("= 0      ============     0 =\n");
		System.out.print("= 0    simulate a race!   0 =\n");
		System.out.print("= 0 = 0 = 0 = 0 = 0 = 0 = 0 =\n\n");
	}
	
	public static void displayWinner(int size, Robot[] arr, int count){
		String winner ="";
		for(int i =0; i< arr.length; i++ ){
			if(arr[i].won(size)){
				winner = arr[i].getName(); // name of the winner
			}
		}
		System.out.println("==> It took "+(count-1)+" rounds for "+ winner+" to win the race!!!");
		System.out.println("\n\nHope you didn't loose too much money ...");
}
	
	
	public static int letMove(int size,Robot[] arr){
		boolean isDone = false; // while the robot hasn't win yet
		int count =1; // keeping track of the moves
		int steps;
		
		do{
			
			System.out.println("Move Number " + count);
			System.out.println("===================");
			
			for(int i = 0; i< arr.length; i++ ){
				
				char temp = arr[i].getDirection(); // this keep the old direction in to check if it changed later on
				steps = arr[i].Steps(size); // getting nbr of steps randomly
				
				System.out.println("* Robot "+arr[i].toString() + " need to take "+ steps+" steps.");
				
				arr[i].move(steps,size); // calling method move which is going to move the robot
				
				if(!arr[i].checkDirection(temp)) // check if it changed direction
					System.out.println("  New direction: "+ arr[i].getDirection()); // displaying new direction
				System.out.println("  Result: "+arr[i].toString());
				
				
				if(arr[i].won(size)) {
					isDone = true; // if he won they stop
					break;
				}
			}
			
			System.out.println();
			count++;
		}
		while (!isDone);
		return count;
		
		
	}
	
	

}
