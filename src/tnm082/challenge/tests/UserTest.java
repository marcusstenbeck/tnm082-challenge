package tnm082.challenge.tests;

import tnm082.challenge.Mission;
import tnm082.challenge.User;
import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	public void testGetName()
	{
		// Skapa en User
		User u = new User();
		
// BORDE KOLLA SÅ ATT DET SOM RETURNERAS ÄR EN TEXTSTRÄNG
		
		// kolla sÂ att vi fÂr tillbaka nÂgot när vi ber om ett namn
		assertNotNull(u.getName());
	}

	public void testSetName()
	{
		// Skapa en User
		User u = new User();
		
		// S‰tt ett namn
		String theName = "Ture Sventon";
		u.setName(theName);
		
		// Se till att namnet som sattes returneras
		assertEquals(theName, u.getName());
	}

	public void testGetPass()
	{
		// Skapa en User
		User u = new User();
		
		// kolla sÂ att vi fÂr tillbaka nÂgot
		assertNotNull(u.getPass());
	}

	public void testSetPass()
	{
		// Skapa en user
		User u = new User();
		
		// S‰tt ett password
		String thePass = "mellon";
		u.setPass(thePass);
		
		// Se till att det satta passwordet returneras
		assertEquals(thePass, u.getPass());
	}

	public void testGetId()
	{
		// Skapa en User
		User u = new User();
		
		// kolla sÂ att vi fÂr tillbaka nÂgot
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
		u.completeMission(m);
		
		// Make sure the mission doesn't exist no more!
		//assertTrue(u.getCompletedMissions());
		
		fail("Not yet implemented");
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
