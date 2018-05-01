/*
Ait Hamouda Tarek 40044119

COMP249

Assignment #1

23/07/2017

*/
package assignments;

public class Case {

	
	
	private String content;
	private boolean called;
	

	
	public Case(){
		
		content = ContentOne.HIDE_CHARACTER.getContent();
		called = false;
		
	}
	// mutator
	public void setContent(String str){
		content = str;
	}
	//accessor
	public 	String getContent(){
		
		return content;
	}
	//mutator
	public void setCalled(boolean c){
	called = c;
	}
	//accessor
	public boolean getCalled() {
		return called;
	}
	//boolean to check if the case is already taken
	public boolean isTaken(){
		return ( getContent() != ContentOne.HIDE_CHARACTER.getContent() );
	}

	
	public boolean equals(Case c){
		return(content == c.content && called == c.called);
	}
	
	public String toString(){
		return " case has content " + content + " and has called value " + called;
	}
	
	
	
}

		
