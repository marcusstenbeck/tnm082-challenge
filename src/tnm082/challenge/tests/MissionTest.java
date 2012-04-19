package tnm082.challenge.tests;

import tnm082.challenge.Mission;
import junit.framework.TestCase;

public class MissionTest extends TestCase {
	
	public void testMission() {
		Mission m = new Mission();
		
		assertNotNull(m.getName());
		assertNotNull(m.getDesc());
		assertNotNull(m.getId());
	}

	public void testMissionIntStringString() {
		// Förbered variabler för konstruktorn
		int theId = 1;
		String theName = "Team Tiger";
		String theDesc = "A pretty awesome team of well-trained tigers of code. From the jungle. Boo-yah!";
		
		// Skapa objektet
		Mission m = new Mission(theId, theName, theDesc);
		
		// kolla så att konstruktorn har tilldelat alla variabler
		assertEquals(theId, m.getId());
		assertEquals(theName, m.getName());
		assertEquals(theDesc, m.getDesc());
	}
/*
	public void testMissionMission() {
		fail("Not yet implemented");
	}
*/
	public void testGetId() {
		Mission m = new Mission();
		
		// kolla så att vi får tillbaka något
		assertNotNull(m.getId());
	}

	public void testSetId() {
		Mission m = new Mission();
		
		// Sätt ett id
		int theId = 1;
		m.setId(theId);
		
		// Se till att det satta id:t returneras
		assertEquals(theId, m.getId());
	}

	public void testGetName() {
		Mission m = new Mission();

		// Kolla så att vi får tillbaka något
		assertNotNull(m.getName());
	}

	public void testSetName() {
		Mission m = new Mission();
		
		// Sätt ett namn
		String theName = "Test Name"; 
		m.setName(theName);
		
		// Kolla så att det satta namnet returneras
		assertEquals(theName, m.getName());
	}

	public void testGetDesc() {
		Mission m = new Mission();
		
		// Kolla så att vi får tillbaka något
		assertNotNull(m.getName());
	}

	public void testSetDesc() {
		Mission m = new Mission();
		
		// Sätt en uppdragsbeskrivning
		String theDesc = "Description of an awesome challenge."; 
		m.setDesc(theDesc);
		
		// Kolla så att uppdragsbeskrivningen returneras
		assertEquals(theDesc, m.getDesc());
	}

}
