package tnm082.challenge;

import java.util.*;

public class Group {
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
	
	private String name;
	protected List<User> userList;
	
	public Group()
	{
		name = "Übergruppen";
		userList = new Vector<User>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List getUserList() {
		 
		return userList;
	}
	
	public void addUser(User a){
		userList.add(a);	
	}
	
	public void removeUser(User a){
		userList.remove(a);	
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
