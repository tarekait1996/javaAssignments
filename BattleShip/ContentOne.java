/*
Ait Hamouda Tarek 40044119

COMP249

Assignment #1

23/07/2017

*/
package assignments;

public enum ContentOne {
	
	// enum class
	
		 HIDE_CHARACTER( "_"),
		GRENADE_CHARACTER("g"),
		GRENADE_CHARACTER_UPPERCASE("G"),
		SHIP_CHARACTER("s"),
		SHIP_CHARACTER_UPPERCASE("S"),
		 HIT_CHARACTER("*");
	
	private String content;
	
	 ContentOne(String str){
		content = str;
		
		
		
	
	 }
	 

	 
	 public String getContent(){ 
		 return content;
	 }
	 
	 
	
}
