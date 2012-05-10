package tnm082.challenge;

import java.util.*;


import android.util.Log;

/**
 * Kodad av: Magnus S/Markus O
 * Task nr:15
 * Datum: 2012-03-22
 * Estimerad tid: 2h
 * Faktisk tid: xh
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 * @param namn - beskrivning.
 * @return namn - beskrivning.

 */

public class Group{
	private String name;
	private int id;
	private static DBHandler db = new DBHandler();

	protected List<User> userList;
	protected List<Mission> missionsList;
	protected static List<Group> groupsList;
	protected List<Mission> acceptedMissions;
	protected List<Mission> completedMissions;

	
	public Group()
	{
		name = "†bergruppen";
		userList = new Vector<User>();
		id = 0;
		
	}

	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Kodad av: Mathias
	 * Task nr: 7, sprint 2
	 * Datum: 2012-04-26
	 * Estimerad tid: 4h
	 * Faktisk tid: 
	 * Testad/av: Nej / namn
	 * Utcheckad/av: Ja / Rikard unt HC
	 * @return List<User> - En lista över alla användare i gruppen. Använder sig av klassen User.
	 */
	public List<User> getUserList() {
		userList = db.getUsersInGroup(id);
		return userList;
	}
	
	public List<Mission> getMissionsList() {
		missionsList = db.getMissions(id);
		return missionsList;
	}
	
	public static List<Group> getAllGroups(){
		groupsList = db.getGroups();
		return groupsList;
	}
	/**
	 * Kodad av: Rikard
	 * Task nr: 12, sprint 2
	 * Datum: 2012-04-26
	 * Estimerad tid: 4h
	 * Faktisk tid: 1h
	 * Testad/av: Nej / namn
	 * Utcheckad/av: Ja / Rikard unt HC
	 * @return List<User> - En lista över alla användare i gruppen. Använder sig av klassen User.
	 */
	public void addUser(User a){
		userList.add(a);	
		db.accept(a, this);
	}
	
	
	public void removeUser(User a){
		userList.remove(a);
		db.unaccept(a, this);
	}
	
	public String toString()
	{
		return getName();
	}
	
	public User getUser(int id){
		if( userList != null && userList.size() > 0 )
		{
			for(int i = 0; i<userList.size(); i++)
			{
				if(id == userList.get(i).getId())
				{
					return userList.get(i);
				}
			}
		}
		return null;
	}
	/**
	 * Kodad av: HC
	 * Task nr: 13, sprint 3
	 * Datum: 2012-05-10
	 * Estimerad tid: 1h
	 * Faktisk tid: 2h
	 * Testad/av: Nej / namn
	 * Utcheckad/av: Ja / HC
	 * @return Boolean - Returnerar true/false om User u är admin för gruppen.
	 */
	public boolean isAdmin(User u)
	{		
		return db.isAdmin(u, this);
	}

	
	public List<Mission> getAcceptedMission(){
		acceptedMissions = db.getMissionsInGroup(id, "active");
		return acceptedMissions;
	}
	
	public List<Mission> getCompleteMission(){
		completedMissions = db.getMissionsInGroup(id, "completed");
		return completedMissions;
	}

}
