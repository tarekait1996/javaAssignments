package Assignments;
// -------------------------------------------------------
// Assignment 4
// Written by: Tarek Ait Hamouda , ID: 40044119
// For COMP 248 Section 2164-WK – Winter 2017
//--------------------------------------------------------

public class Robot {

	private String name; // name of robot
	private int x ; // x coordinate
	private int y; // y coordinate
	private char direction; // direction of the robot
	
	
	public Robot(){ // default constructor
		name = "noName";
		direction = 'E';
		x = 0 ;
		y = 0 ;
	}
	public Robot(String name1){ // one parameter constructor
		name = name1;
		direction = 'E';
		x=0;
		y=0;
		
	}
	public Robot(Robot robot1){ // copy constructor
		name = robot1.name;
		direction = robot1.direction;
		x = robot1.x;
		y = robot1.y;
	}
	
	public String getName(){ // getting the name back 
		return name;
	}
	
	public char getDirection(){// getting the direction back 
		return direction;
	}
	public int getX(){ // getting the x back 
		return x;
	}
	public int getY(){ // getting the y back 
		return y;
	}
	
	public void setName(String name1){ // setting the name of the robot
		name = name1;
	}
	// no mutator method direction()
	
	public String toString(){ //  displaying the name ,direction and position after each move
		
		return (name +" is facing "+getDirection()+" and at position ("+getX()+","+getY()+")");
	}
	public boolean equals( Robot robot1){ // is it equal?
		return(this.direction == robot1.direction && this.x== robot1.x && this.y == robot1.y);
	}
	
	public  int Steps(int size){ // generates steps randomly , loop if it is 0
		int steps;
		do{
		 steps = (int)(Math.random()*10)*(size+1)/10;
		}
		while (steps == 0);
		
		return steps;
	}
	
	public void changeDirection(char direction1){ // change direction of the robot when necessary
		
		
		switch(direction1){
		
		case 'E':
			direction = 'N';
			break;
		case 'W':
			direction = 'S';
			break;
		case 'N':
			direction = 'W';
			break;
		case 'S':
			direction = 'E';
			break;
		}
		
		
			
	}
	
	public void move(int steps, int sizeGrid){ // most important method, it makes the robot move.
		
		
		for(int i = 0; i < steps;i++){
		
			//WHEN IT IS AT THE LIMIT, I CALL THE CHANGEDIRECTION METHOD, ELSE , POSITION+1
			
				if(direction =='E'){
					if( x < sizeGrid){
						x++;	
					}
					else if (x == sizeGrid)
						changeDirection(direction);
				}
				if(direction =='N'){
					if( y < sizeGrid){
						y++;	
					}
					else
						changeDirection(direction);
				}
				if(direction =='W'){
					if( x > 0){
						x--;	
					}
					else
						changeDirection(direction);
				}
				if(direction =='S'){
					if( y>0){
						y--;	
					}
					else
						changeDirection(direction);
				}
			
		}
		
		
	}
	public boolean won(int size){ // return the boolean value of the robot's victory

		
		return(x == size && y == size);
			
	}


	
	
	
	public boolean checkDirection(char tempDirection){ 
		// check if he changed direction by comapring a temp variable that hold 
		// the previous direction and comparing it with the new
		
		return (this.direction == tempDirection);
	}
	
}
