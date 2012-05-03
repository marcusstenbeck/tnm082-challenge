package tnm082.challenge;

//import Mission.jaca;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import tnm082.challenge.Mission;

/**
    * Kodad av: Flaaten	
    * Task nr: 3
    * Datum: 2012-03-22
    * Estimerad tid: 2 h
    * Faktisk tid: 3 h
    * Testad/av: Nej
    * Utcheckad: Nej
    
    */
/**
 * Kodad av: Kristina	
 * Task nr: 6 (sprint2)
 * Datum: 2012-04-26
 * Estimerad tid: 4 h
 * Faktisk tid: 5 h
 * Testad/av: Nej
 * Utcheckad: Nej
 
 */

public class User {
	//alla variabler
	private String name, pass;
	private int id;
	private List<Mission> acceptedMissions, completedMissions;
	DBHandler db = new DBHandler(); 
	
	//tom konstruktor initierar alla värdena
	public User() {
		this.name = "klas";
		this.pass = "kalas";
		this.id = 0;
		
		// En lista över uppdrag som ska utföras
		this.acceptedMissions = new ArrayList<Mission>();
		
		// En lista över uppdrag som användaren har klarat
		this.completedMissions = new ArrayList<Mission>();
	}
	
	//enkel konstruktor med basic initalvärden
	public User(String new_name, String new_pass, int new_id){
		this.name = new_name;
		this.pass = new_pass;
		this.id = new_id;
		// En lista över uppdrag som ska utföras
		this.acceptedMissions = new ArrayList<Mission>();

		
		// En lista över uppdrag som användaren har klarat
		this.completedMissions = new ArrayList<Mission>();
		
	}
	
	//Full initierings konstruktor
	public User(String new_name, String new_pass,int new_id, List<Mission> new_accepted, List<Mission> new_completed) {
		this.name = new_name;
		this.pass = new_pass;
		this.id = new_id;
		
		for(int i = 0; i < new_accepted.size();i++)
		{
			this.acceptedMissions.add(i, new_accepted.get(i));
		}
		for(int i = 0; i < new_completed.size();i++)
		{
			this.completedMissions.add(i, new_completed.get(i));
		}
	}
	//set o get för alla variabler
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	//När man blitt klar med ett uppdrag tas den bort ur accepted o läggs in i completed
	public void completeMission(Mission the_mission)
	{				
		for(int i = 0; i < acceptedMissions.size();i++)
		{
			if(acceptedMissions.get(i).getId() == the_mission.getId())
			{
				acceptedMissions.remove(i); // kan bli fel isf ta fram indexet och ta bort det indexet bara.
				completedMissions.add(completedMissions.size(), the_mission);
			}
		}
		 
	}
	
	// Har man accepterat ett uppdrag
	public boolean hasAcceptedMission(Mission the_mission)
	{
		for(int i = 0; i < acceptedMissions.size();i++)
		{
			if(acceptedMissions.get(i).getId() == the_mission.getId())
			{
				return true;
			}
		}
		return false;
	}
	
	// Acceptera ett uppdrag
	public void acceptMission(Mission the_mission)
	{
		acceptedMissions.add(acceptedMissions.size(), the_mission);
	
	}
	
	// Vill inte fortsätta med uppdraget
	public void cancelMission(Mission the_mission)
	{
		for(int i = 0; i < acceptedMissions.size();i++)
		{
			if(acceptedMissions.get(i).getId() == the_mission.getId())
			{
				acceptedMissions.remove(i); // kan bli fel isf ta fram indexet och ta bort det indexet bara.
			}
		}
	}
	
	public List<Mission> getAcceptedMissions()
	{
		//hamta accepterade uppdrag for den aktuella anvandaren
		acceptedMissions = db.getMissions(this, "active");
		return acceptedMissions;
	}
	
	public List<Mission> getCompletedMissions()
	{
		//hamta avklarade uppdrag for den aktuella anvandaren
		completedMissions = db.getMissions(this,"completed");
		return  completedMissions;
	}
	public User getDummy()
	{
		Log.d("Accept/avAccept","Dummyuser 1");
		List<User> uList = db.getUsers();
		
		Log.d("Accept/avAccept","Dummyuser ");
		return db.getUsers().get(0);
	}
}
