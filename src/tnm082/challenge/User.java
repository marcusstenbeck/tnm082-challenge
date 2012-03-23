package tnm082.challenge;

//import Mission.jaca;

import java.util.ArrayList;
import java.util.List;

/**
    * Kodad av: Flaaten	
    * Task nr: 3
    * Datum: 2012-03-22
    * Estimerad tid: 2 h
    * Faktisk tid: 3 h
    * Testad/av: Nej
    * Utcheckad: Nej
    
    */

public class User {
	private String name, pass;
	private List<Mission> acceptedMissions, completedMissions;
	
	public User() {
		this.name = "klas";
		this.pass = "kalas";
		
		// En lista �ver uppdrag som ska utf�ras
		this.acceptedMissions = new ArrayList<Mission>();
		
		// En lista �ver uppdrag som anv�ndaren har klarat
		this.completedMissions = new ArrayList<Mission>();
	}
	
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
	public int getId() {
		//return h�mta id fr�n databasen;
		return 0;
	}

	public void completeMission(Mission the_mission)
	{			
		
		for(Mission m : acceptedMissions)
		{
			if(m.getId()==the_mission.getId())
			{
				acceptedMissions.remove(m);//kan bli fel isf ta fram indexet och ta bort det indexet bara.
				completedMissions.add(the_mission);
			}
		}
		 
	}
	public boolean hasAcceptedMission(Mission the_mission)
	{
		for(Mission m : acceptedMissions)
		{
			if(m.getId()==the_mission.getId())
				return true;
		}
		return false;
		
		
	}
	public void acceptMission(Mission the_mission)
	{
		acceptedMissions.add(the_mission);
	
	}
	public void cancelMission(Mission the_mission)
	{
		for(Mission m : acceptedMissions)
		{
			if(m.getId()==the_mission.getId())
				acceptedMissions.remove(m);
		}
	}
}