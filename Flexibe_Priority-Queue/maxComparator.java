package A3;

import java.util.Comparator;

public class maxComparator<K> implements Comparator<K> {
	public int compare(K a, K b) { 
		return ((Comparable<K>) b).compareTo(a);
	}
	
}
