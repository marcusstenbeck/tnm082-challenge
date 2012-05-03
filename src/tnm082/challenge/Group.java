package tnm082.challenge;

import java.util.*;

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

public class Group {
	private String name;
	private int id;
	private DBHandler db;

	protected List<User> userList;
	protected List<Mission> missionsList;
	
	public Group()
	{
		name = "†bergruppen";
		userList = new Vector<User>();
		id = 0;
		db = new DBHandler();
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
	
	public void addUser(User a){
		userList.add(a);	
		db.accept(a, this);
	}
	
	public void removeUser(User a){
		userList.remove(a);
		db.unaccept(a, this);
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
}
