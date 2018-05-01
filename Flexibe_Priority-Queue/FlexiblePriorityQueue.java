package A3;
import java.util.Comparator;

public class FlexiblePriorityQueue<K,V> {
	private Comparator<K> comp;
	public int capacity = 5 ;
	//enum type Mode that serves to know the state or mode of the heap 'min'/'max'
	private enum Mode {
		Min,
		Max
	}
	// By default I chose to set the priority queue to Min, this can easily be changed to Max
	Mode mode = Mode.Min;  
	
	// in case user want to provide his own max/min Comparator
	private Comparator<K>specialMaxcomp;
	private Comparator<K>specialMincomp;
	
	// initialize a dynamic array with type PQEntry which stores the entries inside the heap
	PQEntry<K,V>[] priorityArray = new PQEntry[capacity];
	private int size = 0;
	
	public FlexiblePriorityQueue() { 
		// initially set the comparator to min as it is a min heap first 
		comp = (Comparator<K>) new minComparator();
	 }
	
	public FlexiblePriorityQueue(Comparator<K> minc, Comparator<K> maxc) { 
		// in case the user wants to set his own comparator, we allow him to do so
		specialMincomp = minc;
		comp = minc;
		specialMaxcomp = maxc;
	 }
	
	public PQEntry<K,V> remove(){
		/**
		 * removes and returns the entry (a key, value pair) with the smallest or
		 *  biggest key depending on the current state of the priority queue (either Min or Max).
		 */
		if(isEmpty()) {
			return null;
		}
		else {
				// initializing a new entry which is set to be equal to top of the heap
			PQEntry<K,V> e = top();
			
				// set the top of the array to be the last entry of the heap
			priorityArray[0] = priorityArray[size-1];
			
				// setting the last entry to null in order to get rid of it
			priorityArray[size-1] = null;
			
			size--;
			
				// reshaping (arrange order of the heap) of the heap is needed now --> using DownHeap method, going from the top to bottom
				//we call downheap with 0 in order to start from top and go until the bottom
			if (!isEmpty()) {
				downHeap(0);
			}
				// return the removed entry
			return e;
		}
	}
	private void downHeap(int index) {
		// getting the index of the left child 
        int leftIndex = (2*index) + 1;
        // getting the index of the right child
        int rightIndex = leftIndex + 1;
        // index of the one we are going to compare to 
        int a; 
        
        if (rightIndex >= size()) {//no right child
            if (leftIndex >= size()) {//no left child
                return;
            } else {
            	//if only left child we treat a as left child
                a = leftIndex;
            }
        } 
        //otherwise check which one of left or right has priority and assign a
        else {
        		// for min it means if left < right 
        		// for max it means if left > right
            if (comp.compare(priorityArray[leftIndex].getKey(), priorityArray[rightIndex].getKey()) < 0) {
                a = leftIndex;
            } else {
                a = rightIndex;
            }
        }
        // compare the index to the child that ahs the best priority among the two
        if (comp.compare(priorityArray[index].getKey(),priorityArray[a].getKey()) > 0) {//swap the value
            PQEntry<K,V> tmp = priorityArray[a];
            priorityArray[a] = priorityArray[index];
            priorityArray[index] = tmp;
            downHeap(a);
        }
	}
	public PQEntry<K,V> insert(K key, V value) throws IllegalArgumentException{
		/**
		 * Insert the (k,v) entry which is a key(k), value(v) pair to the priority queue.
		 */
		// checking if the keys are comparable and compatible
		checkKey(key);
		// create an entry based on data provided
		PQEntry<K,V> newest = new PQEntry<>(key,value);
		// if no more space in array, it will automatically extend
		if (size() == capacity) {
			capacity *= 2; //doubling strategy
			PQEntry<K,V>[] new_array = new PQEntry[capacity];
			for(int i =0; i < size; i++) {
				new_array[i] = priorityArray[i];
			}
			priorityArray = new_array;
		}
		// end of extension  of array
		// add entry into the array
		priorityArray[size] = newest;
		// reorder the heap now based on upheap starting 
		upheap(size);
		
		size ++;
		
		return newest;
	}
	protected boolean checkKey(K key) throws IllegalArgumentException { 
		/**
		 * helping function to make sure the keys are valid 
		 */
		try { 
			return (comp.compare(key,key) == 0); // see if key can be compared to itself
		} catch (ClassCastException e) { 
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	private void upheap(int i) {
		/**
		 * helping function to reorder the heap after an insert()
		 */
		        if (i != 0) {
		            int p = (i-1)/2;
		                if (comp.compare(priorityArray[p].getKey(),priorityArray[i].getKey()) > 0) {
		                    PQEntry<K,V> tmp = priorityArray[p];
		                    priorityArray[p] = priorityArray[i];
		                    priorityArray[i] = tmp;
		                    upheap(p);
		            }
		        }
		    }
	public void switchToMin() {
		/**
		 * transforms a max- to a min-priority queue; else leave unchanged.
		 */
        if (mode == Mode.Max) {
            reverseArray();
            if (comp == specialMaxcomp)
            		comp = specialMincomp;
            else 
            		comp =  (Comparator<K>) new minComparator();
            mode = Mode.Min;
        }
    }
    public void switchToMax() {
    	/**
		transforms a min- to a max-priority queue; else leave unchanged.
    	 */
        if (mode == Mode.Min) {
            reverseArray();
            if (comp == specialMincomp)
        		comp = specialMaxcomp;
            else 
            comp = (Comparator<K>)new maxComparator();
            mode = Mode.Max;
        }
    }
    private void reverseArray() {
    	// this function serves to reverse the array from a state to another
    	// it will remove every element and insert them backward
    	// basically it will swap the heap order mode 
        PQEntry<K,V>[] new_array = new PQEntry[capacity];
        // have to make a copy of size() because it will change as we remove elements
        int currSize = size();
        
        for (int i = 0; i < currSize; i++) {
            new_array[currSize - i -1] = this.remove();
            
        }
        priorityArray = new_array;
        size = currSize;
    }
	public boolean isEmpty() {
		/**
		 * returns true if the priority queue is empty.
		 */
	        return size == 0;
	}
	public int size() {
		/**
		 * returns the current number of entries in the priority queue
		 */
        return size;
     }
    public void toggle() {
    	/**
    	 * this method serves to transform a min- to a max-priority queue or vice versa.
    	 */
    		if (mode == Mode.Min) {
    			switchToMax();
	    } else {
	    		switchToMin();
    		}
    	}
    public PQEntry<K, V> top() {
    	/**
    	 * returns the top entry (with the minimum or the maximum key depending on whether it is a Min- or 
    	 * Max-priority queue, without removing the entry.
    	 */
        if (isEmpty()) {
            return null;
        }
        return priorityArray[0];
    }
    public String state() {
    	/**
    	 * returns the current state (Min or Max) of the priority queue.
    	 */
    		return mode.toString();
    }
    public String toString() {
    	
    	/**
    	 * this is a method that returns a string containing the informations about the priorityQueue
    	 */
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
        	// we assume top is entry 1 and last entry is last 
            sb.append("Entry " + (i+1) + " =>");
            sb.append("[key:" + priorityArray[i].k + ", value:\"" + priorityArray[i].v + "\"], ");
        }
        return sb.toString();
    }
}

