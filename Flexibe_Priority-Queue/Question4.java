package A3;


	public class Question4<K, V> {
	    public static void main(String[] args) {
	    	
	    	
	    				System.out.println("Creating a new Flexible Priority Queue ...");
	    				
	    				// instantiating a PQ with default constructor
	    				FlexiblePriorityQueue<Integer, String> pq = new FlexiblePriorityQueue<Integer, String>();
	    				System.out.println("\nFlexible Priority Queue created");
	    				System.out.println("\nAbout to insert 3 entry with random keys into the Flexible Priority Queue!");
	    				// inserting random keys with elements
	    				System.out.println(pq.insert(randomNum(), "person 1"));
	    				System.out.println(pq.insert(randomNum(), "person 2"));
	    				System.out.println(pq.insert(randomNum(), "person 3"));
	                
	                System.out.print("\nCapacity of priority queue: " + pq.capacity);
	                System.out.print("\nNumber of element in priority queue: " + pq.size());
	                // displaying entries after the 3 insertion 
	                System.out.println("\nEntries are as follow "+pq.toString());
	                System.out.println("\nAbout to add three more ...");
	                System.out.println(pq.insert(randomNum(), "person 4"));
    					System.out.println(pq.insert(randomNum(), "person 5"));
    					System.out.println(pq.insert(randomNum(), "person 5.5"));
	                System.out.println("\nEntries are now as follow "+pq.toString());
	                System.out.println("\nCapacity of PQ is now "+pq.capacity + " and number of element inside PQ is " + pq.size());
	                System.out.println("\nState is now " + pq.state());
	                System.out.println("\nAbout to toggle... ");
	                pq.toggle();
	                System.out.println("\nState is now " + pq.state());
	                System.out.println("\nThe priority queue is now "+pq.toString());
	                System.out.println("\nAbout to add a new entry : " + pq.insert(randomNum(), "person 6"));
	                
	                System.out.println("\nPriority queue is now : "+pq.toString());
	                System.out.println("\nRemoving an element");
	                System.out.println("\nElement removed is : "+pq.remove().toString());
	                System.out.println("\nThe priority queue is now : "+pq.toString());
	                System.out.println("\nAbout to toggle again!");
	                pq.toggle();
	                System.out.println("\nThe priority queue is now : "+pq.toString());
	                
	                System.out.println("\nRemoving an element");
	                System.out.println("\nElement removed is : "+pq.remove().toString());
	                System.out.println("\nThe priority queue is now : "+pq.toString());
	                System.out.println("\nChecking if it is empty : " + pq.isEmpty());
	                System.out.println("\nLet's emtpy the priority queue!");
	                System.out.println("\nElement removed is : "+pq.remove().toString());
	                System.out.println("\nElement removed is : "+pq.remove().toString());
	                System.out.println("\nElement removed is : "+pq.remove().toString());
	                System.out.println("\nElement removed is : "+pq.remove().toString());
	                System.out.println("\nElement removed is : "+pq.remove().toString());
	                System.out.println("\nNumber of element of PQ is: " + pq.size());
	                System.out.println("\nChecking if it is empty : " + pq.isEmpty());
	                
	                	System.out.println("\nLet's refill the priority queue!");
	                	System.out.println("\nTop of PQ is " + pq.top());
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 7"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 8"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 9"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 10"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 11"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 12"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 13"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 14"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 15"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 16"));
	                	System.out.println("\nElement added : " + pq.insert(randomNum(), "person 17"));
	                
	                	System.out.println("\nTop of PQ is " + pq.top());
	                	System.out.println("\nThe PQ is now : " + pq.toString());
	                	System.out.println("\nNumber of elements inside priority queue: " + pq.size());
	                	System.out.println("\nSwitch to max" );
	                	pq.switchToMax();
	                	
	                	System.out.println("\nThe PQ is now : " + pq.toString());
	                	System.out.println("\nThe PQ state is now : " + pq.state());
	
	    }
	    private static int randomNum() {
	    	return (int) (Math.random()*100);
	    }
	}

