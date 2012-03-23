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

public class Users {
	private String name;
	private String pass;
	private List<Mission> do_it;
	private List<Mission> done_it;
	
	public Users() {
		name = "klas";
		pass = "kalas";
		do_it = new ArrayList<Mission>();
		done_it = new ArrayList<Mission>();
		
		
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

	public void doneIt(Mission the_mission)
	{
		//b blir true om the mission har tagits bort ur do_it
		boolean b = do_it.remove(the_mission);
		
		if(b)
			done_it.add(the_mission);
		
		/*for(Mission m : do_it)
		{
			if(m.getId()==the_mission.getId())
				do_it.remove(m);//do_it.remove(the_mission.getID()); ska tabort uppdraget från "att göra listan" med hjälp av id som hämtas från databasen
		}*/
	
	}
	public void add_do(Mission the_mission)
	{
		do_it.add(the_mission);
	
	}
	public void remove_do(Mission the_mission)
	{
		do_it.remove(the_mission);
		/*for(Mission m : do_it)
		{
			if(m.getId()==the_mission.getId())
				do_it.remove(m);
		}*/
	}
}
