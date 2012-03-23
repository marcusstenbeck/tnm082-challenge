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
		
		// En lista över uppdrag som ska utföras
		this.acceptedMissions = new ArrayList<Mission>();
		
		// En lista över uppdrag som användaren har klarat
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
		//return hämta id från databasen;
		return 0;
	}

	public void completeMission(Mission the_mission)
	{
		//b blir true om the mission har tagits bort ur acceptedMissions
		boolean b = acceptedMissions.remove(the_mission);
		
		if(b)
			completedMissions.add(the_mission);
		
		/*for(Mission m : acceptedMissions)
		{
			if(m.getId()==the_mission.getId())
				acceptedMissions.remove(m);//acceptedMissions.remove(the_mission.getID()); ska tabort uppdraget från "att göra listan" med hjälp av id som hämtas från databasen
		}
		 */
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
