package A3;
public class PQEntry<K,V> implements Entry<K,V> {
	  K k; // key
	  V v; // value
	  public PQEntry(K key, V value) { 
		  this.k = key;
		  this.v = value;
	  }  
	  // methods of the Entry interface
	  public K getKey( ) { return k; } 
	  public V getValue( ) { return v; } 
	  protected void setKey(K key) { k = key; } 
	   protected void setValue(V value) { v = value; } 
	   public String toString() {
		   return "[key: "+ k +", value: \""+v+"\"]";
	   }
	   
	   } 