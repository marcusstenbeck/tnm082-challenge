package tnm082.challenge.tests;

import java.util.List;

import tnm082.challenge.Mission;
import tnm082.challenge.User;
import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	public void testGetName()
	{
		//Skapa en User
		User u = new User();
		
// BORDE KOLLA SA ATT DET SOM RETURNERAS AR EN TEXTSTRANG
		
		//kolla sa att vi får tillbaka nagot nar vi ber om ett namn
		assertNotNull(u.getName());
	}

	public void testSetName()
	{
		// Skapa en User
		User u = new User();
		
		// Satt ett namn
		String theName = "Ture Sventon";
		u.setName(theName);
		
		// Se till att namnet som sattes returneras
		assertEquals(theName, u.getName());
	}

	public void testGetPass()
	{
		// Skapa en User
		User u = new User();
		
		// kolla sa att vi far tillbaka nagot
		assertNotNull(u.getPass());
	}

	public void testSetPass()
	{
		// Skapa en user
		User u = new User();
		
		// Satt ett password
		String thePass = "mellon";
		u.setPass(thePass);
		
		// Se till att det satta passwordet returneras
		assertEquals(thePass, u.getPass());
	}

	public void testGetId()
	{
		// Skapa en User
		User u = new User();
		
		// kolla sa att vi far tillbaka nagot
		assertNotNull(u.getId());
	}

	public void testCompleteMission()
	{
		User u = new User();
		
		// Create mission
		Mission m = new Mission();
		int missionId = 383;
		m.setId(missionId);
		
		
		// Accept mission
		u.acceptMission(m);
		
		// Check if mission exists in acceptedMissions list
		assertTrue(u.hasAcceptedMission(m));
		
		// Cancel the mission
		u.completeMission(m.getId());
		
		// Create a boolean that stores if the mission exists in among the completed missions 
		boolean existsInCompletedMissionsList = false;
		
		// Get the list of completed missions for the user
		List<Mission> completedMissions = u.getCompletedMissions();
		
		// Test if the mission exists within the completedMissions list from the user
		for(int i = 0; i < completedMissions.size(); i++)
			if(completedMissions.get(i).getId() == m.getId())
				existsInCompletedMissionsList = true;
		
		// Report if the mission exists in the list
		assertTrue(existsInCompletedMissionsList);
	}

	public void testAcceptMission() {
		
		User u = new User();
		
		// Create mission
		Mission m = new Mission();
		int missionId = 383;
		m.setId(missionId);
		
		
		// Accept mission
		u.acceptMission(m);
		
		// Check if mission exists in acceptedMissions list
		assertTrue(u.hasAcceptedMission(m));
	}

	public void testCancelMission()
	{
		User u = new User();
		
		// Create mission
		Mission m = new Mission();
		int missionId = 383;
		m.setId(missionId);
		
		
		// Accept mission
		u.acceptMission(m);
		
		// Check if mission exists in acceptedMissions list
		assertTrue(u.hasAcceptedMission(m));
		
		// Cancel the mission
		u.cancelMission(m);
		
		// Make sure the mission doesn't exist no more!
		assertFalse(u.hasAcceptedMission(m));
	}

}
