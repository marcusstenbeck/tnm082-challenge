package tnm082.challenge;

/**
 * Kodad av: Mathias
 * Task nr: Inget (men borde ha varit...)
 * Datum: 2012-03-23
 * Estimerad tid: --h
 * Faktisk tid: xh
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class Feed {
	
	private Mission[] feedMissions; 
	
	public Feed() {
		// TODO Auto-generated constructor stub
	}
	
	public Mission[] getMissions(){
		
		feedMissions[0] = new Mission("mission1","test1",1);
		feedMissions[1] = new Mission("mission2", "test2",2);
		
		return feedMissions;
	}
	
}
